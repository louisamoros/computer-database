package com.louisamoros.cdb.dao.impl;

import com.louisamoros.cdb.controller.util.QueryParams;
import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.dao.exception.DaoException;
import com.louisamoros.cdb.dao.mapper.MapperComputerDaoPs;
import com.louisamoros.cdb.dao.mapper.MapperRsComputerDao;
import com.louisamoros.cdb.dao.util.QueryStatementGenerator;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.util.TransactionManager;
import com.louisamoros.cdb.service.util.TransactionManagerImpl;

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

  public static Logger LOGGER = LoggerFactory.getLogger(ComputerDao.class);
  private TransactionManager transactionManager;

  private ComputerDaoImpl() {
    transactionManager = TransactionManagerImpl.INSTANCE;
  }

  @Override
  public Computer get(int id) {
    ResultSet rs = null;
    Computer computer = null;
    Connection conn = transactionManager.getConnection();
    QueryStatementGenerator qsp = new QueryStatementGenerator.Builder(conn).select("*")
        .from("computer").leftJoinOn("company", "computer.company_id = company.id")
        .where("computer.id=?", String.valueOf(id)).build();
    LOGGER.debug(qsp.getQuery().toString());
    try {
      rs = qsp.getPreparedStatement().executeQuery();
      computer = MapperRsComputerDao.toComputer(rs);
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qsp.getQuery(), e);
    } finally {
      ObjectCloser.close(rs, qsp.getPreparedStatement(), qsp.getQuery().toString());
      transactionManager.closeConnection();
    }

    return computer;
  }

  @Override
  public List<Computer> get(QueryParams qp) {

    List<Computer> computers = null;
    ResultSet rs = null;
    Connection conn = transactionManager.getConnection();
    QueryStatementGenerator qsp = new QueryStatementGenerator.Builder(conn).select("*")
        .from("computer").leftJoinOn("company", "computer.company_id = company.id")
        .orderBy(qp.getOrderBy()).order(qp.getOrder()).limit(String.valueOf(qp.getLimit()))
        .offset(String.valueOf(qp.getOffset())).build();
    LOGGER.debug(qsp.getQuery().toString());
    try {
      rs = qsp.getPreparedStatement().executeQuery();
      computers = MapperRsComputerDao.toList(rs);
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qsp.getQuery(), e);
    } finally {
      ObjectCloser.close(rs, qsp.getPreparedStatement(), qsp.getQuery().toString());
      transactionManager.closeConnection();
    }

    return computers;
  }

  @Override
  public List<Computer> getAll() {

    List<Computer> computers = null;
    ResultSet rs = null;
    Connection conn = transactionManager.getConnection();
    QueryStatementGenerator qsp = new QueryStatementGenerator.Builder(conn).select("*")
        .from("computer").leftJoinOn("company", "computer.company_id = company.id").build();
    LOGGER.debug(qsp.getQuery().toString());
    try {
      rs = qsp.getPreparedStatement().executeQuery();
      computers = MapperRsComputerDao.toList(rs);
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qsp.getQuery(), e);
    } finally {
      ObjectCloser.close(rs, qsp.getPreparedStatement(), qsp.getQuery().toString());
      transactionManager.closeConnection();
    }

    return computers;
  }

  @Override
  public int create(Computer computer) {

    String createComputerQuery = "INSERT INTO computer VALUES (default, ?, ?, ?, ?)";
    LOGGER.debug(createComputerQuery);
    Connection conn = transactionManager.getConnection();
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
      ObjectCloser.close(rs, ps, createComputerQuery);
      transactionManager.closeConnection();
    }

    return computerId;
  }

  @Override
  public int update(Computer computer) {

    String updateComputerQuery = "UPDATE computer SET name=?, introduced=?, discontinued=?, company_id=? WHERE id=?";
    LOGGER.debug(updateComputerQuery);
    Connection conn = transactionManager.getConnection();
    PreparedStatement ps = null;

    try {
      ps = conn.prepareStatement(updateComputerQuery);
      ps = MapperComputerDaoPs.toPs(computer, ps);
      ps.setInt(5, computer.getId());
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + updateComputerQuery, e);
    } finally {
      ObjectCloser.close(null, ps, updateComputerQuery);
      transactionManager.closeConnection();
    }

    return computer.getId();
  }

  @Override
  public void delete(int id) {

    Connection conn = transactionManager.getConnection();
    QueryStatementGenerator qsp = new QueryStatementGenerator.Builder(conn).deleteFrom("computer")
        .where("id=?", String.valueOf(id)).build();
    LOGGER.debug(qsp.getQuery().toString());
    try {
      qsp.getPreparedStatement().executeUpdate();
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qsp.getQuery(), e);
    } finally {
      ObjectCloser.close(null, qsp.getPreparedStatement(), qsp.getQuery().toString());
      transactionManager.closeConnection();
    }

  }

  @Override
  public int count() {

    Connection conn = transactionManager.getConnection();
    ResultSet rs = null;
    int count = 0;
    QueryStatementGenerator qsp = new QueryStatementGenerator.Builder(conn)
        .selectCountFrom("computer").build();
    LOGGER.debug(qsp.getQuery().toString());
    try {
      rs = qsp.getPreparedStatement().executeQuery();
      rs.next();
      count = rs.getInt(1);
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qsp.getQuery(), e);
    } finally {
      ObjectCloser.close(rs, qsp.getPreparedStatement(), qsp.getQuery().toString());
      transactionManager.closeConnection();
    }

    return count;
  }

  @Override
  public void deleteByCompanyId(int companyId) {

    Connection conn = transactionManager.getConnection();
    QueryStatementGenerator qsp = new QueryStatementGenerator.Builder(conn).deleteFrom("computer")
        .where("company_id=?", String.valueOf(companyId)).build();
    LOGGER.debug(qsp.getQuery().toString());
    try {
      qsp.getPreparedStatement().executeUpdate();
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qsp.getQuery(), e);
    } finally {
      ObjectCloser.close(null, qsp.getPreparedStatement(), qsp.getQuery().toString());
      transactionManager.closeConnection();
    }

  }

}
