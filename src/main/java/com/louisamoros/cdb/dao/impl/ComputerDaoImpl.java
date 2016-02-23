package com.louisamoros.cdb.dao.impl;

import com.louisamoros.cdb.controller.util.QueryParams;
import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.dao.connection.JdbcConnectionImpl;
import com.louisamoros.cdb.dao.exception.DaoException;
import com.louisamoros.cdb.dao.mapper.MapperComputerDaoPs;
import com.louisamoros.cdb.dao.mapper.MapperRsComputerDao;
import com.louisamoros.cdb.dao.util.QueryStatementGenerator;
import com.louisamoros.cdb.model.Computer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * The Enum ComputerDaoImpl.
 */
public enum ComputerDaoImpl implements ComputerDao {

  INSTANCE;

  private JdbcConnectionImpl jdbcConnectionImpl;
  private static Logger LOGGER = LoggerFactory.getLogger(ComputerDao.class);

  /**
   * Instantiates a new computer dao impl.
   */
  private ComputerDaoImpl() {
    jdbcConnectionImpl = JdbcConnectionImpl.INSTANCE;
  }

  @Override
  public Computer get(int id) throws DaoException {
    ResultSet rs = null;
    Computer computer = null;
    Connection conn = jdbcConnectionImpl.getConnection();
    QueryStatementGenerator qsp = new QueryStatementGenerator.Builder(conn).select("*")
        .from("computer").leftJoinOn("company", "computer.company_id = company.id")
        .where("computer.id=?", String.valueOf(id)).build();

    try {
      rs = qsp.getPreparedStatement().executeQuery();
      computer = MapperRsComputerDao.toComputer(rs);
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qsp.getQuery(), e);
    } finally {
      ConnectionCloser.close(rs, qsp.getPreparedStatement(), conn, qsp.getQuery().toString());
    }

    return computer;
  }

  @Override
  public List<Computer> get(QueryParams qp) throws DaoException {

    List<Computer> computers = null;
    ResultSet rs = null;
    Connection conn = jdbcConnectionImpl.getConnection();
    QueryStatementGenerator qsp = new QueryStatementGenerator.Builder(conn).select("*")
        .from("computer").leftJoinOn("company", "computer.company_id = company.id")
        .orderBy(qp.getOrderBy()).order(qp.getOrder()).limit(String.valueOf(qp.getLimit()))
        .offset(String.valueOf(qp.getOffset())).build();

    try {
      rs = qsp.getPreparedStatement().executeQuery();
      computers = MapperRsComputerDao.toList(rs);
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qsp.getQuery(), e);
    } finally {
      ConnectionCloser.close(rs, qsp.getPreparedStatement(), conn, qsp.getQuery().toString());
    }

    return computers;
  }

  @Override
  public List<Computer> getAll() throws DaoException {

    List<Computer> computers = null;
    ResultSet rs = null;
    Connection conn = jdbcConnectionImpl.getConnection();
    QueryStatementGenerator qsp = new QueryStatementGenerator.Builder(conn).select("*")
        .from("computer").leftJoinOn("company", "computer.company_id = company.id").build();

    try {
      rs = qsp.getPreparedStatement().executeQuery();
      computers = MapperRsComputerDao.toList(rs);
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qsp.getQuery(), e);
    } finally {
      ConnectionCloser.close(rs, qsp.getPreparedStatement(), conn, qsp.getQuery().toString());
    }

    return computers;
  }

  @Override
  public int create(Computer computer) throws DaoException {

    String createComputerQuery = "INSERT INTO computer VALUES (default, ?, ?, ?, ?)";
    LOGGER.debug(createComputerQuery);
    Connection conn = jdbcConnectionImpl.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    int computerId = 0;

    try {
      ps = conn.prepareStatement(createComputerQuery, Statement.RETURN_GENERATED_KEYS);
      ps = MapperComputerDaoPs.toPs(computer, ps);
      ps.executeUpdate();
      rs = ps.getGeneratedKeys();
      rs.next();
      computerId = rs.getInt(1);
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + createComputerQuery, e);
    } finally {
      ConnectionCloser.close(rs, ps, conn, createComputerQuery);
    }

    return computerId;
  }

  @Override
  public int update(Computer computer) throws DaoException {

    String sql = "UPDATE computer SET name=?, introduced=?, discontinued=?, company_id=? WHERE id=?";
    LOGGER.debug(sql);
    Connection conn = jdbcConnectionImpl.getConnection();
    PreparedStatement ps = null;

    try {
      ps = conn.prepareStatement(sql);
      ps = MapperComputerDaoPs.toPs(computer, ps);
      ps.setInt(5, computer.getId());
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + sql, e);
    } finally {
      ConnectionCloser.close(null, ps, conn, sql);
    }

    return computer.getId();
  }

  @Override
  public void delete(int id) throws DaoException {

    Connection conn = jdbcConnectionImpl.getConnection();
    QueryStatementGenerator qsp = new QueryStatementGenerator.Builder(conn).deleteFrom("computer")
        .where("id=?", String.valueOf(id)).build();

    try {
      qsp.getPreparedStatement().executeUpdate();
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qsp.getQuery(), e);
    } finally {
      ConnectionCloser.close(null, qsp.getPreparedStatement(), conn, qsp.getQuery().toString());
    }

  }

  @Override
  public int count() throws DaoException {

    Connection conn = jdbcConnectionImpl.getConnection();
    ResultSet rs = null;
    int count = 0;
    QueryStatementGenerator qsp = new QueryStatementGenerator.Builder(conn)
        .selectCountFrom("computer").build();

    try {
      rs = qsp.getPreparedStatement().executeQuery();
      rs.next();
      count = rs.getInt(1);
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qsp.getQuery(), e);
    } finally {
      ConnectionCloser.close(rs, qsp.getPreparedStatement(), conn, qsp.getQuery().toString());
    }

    return count;
  }

}
