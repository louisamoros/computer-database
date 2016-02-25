package com.louisamoros.cdb.dao.impl;

import com.louisamoros.cdb.controller.util.QueryParams;
import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.dao.exception.DaoException;
import com.louisamoros.cdb.dao.mapper.MapperComputerDaoPs;
import com.louisamoros.cdb.dao.mapper.MapperRsComputerDao;
import com.louisamoros.cdb.dao.util.ObjectCloser;
import com.louisamoros.cdb.dao.util.QueryGenerator;
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
    PreparedStatement ps = null;
    Computer computer = null;
    Connection conn = transactionManager.getConnection();
    QueryGenerator qg = new QueryGenerator.Builder().select("*").from("computer")
        .leftJoinOn("company", "computer.company_id = company.id").where("computer.id=?").build();
    LOGGER.debug(qg.getQuery().toString());

    try {
      ps = conn.prepareStatement(qg.getQuery().toString());
      ps.setInt(1, id);
      rs = ps.executeQuery();
      computer = MapperRsComputerDao.toComputer(rs);
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qg.getQuery(), e);
    } finally {
      ObjectCloser.close(rs, ps, qg.getQuery().toString());
      transactionManager.closeConnection();
    }

    return computer;
  }

  @Override
  public List<Computer> get(QueryParams qp) {

    List<Computer> computers = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    Connection conn = transactionManager.getConnection();
    QueryGenerator qg = new QueryGenerator.Builder().select("*").from("computer")
        .leftJoinOn("company", "computer.company_id = company.id").orderBy(qp.getOrderBy())
        .order(qp.getOrder()).limit(String.valueOf(qp.getLimit()))
        .offset(String.valueOf(qp.getOffset())).build();
    LOGGER.debug(qg.getQuery().toString());
    try {
      ps = conn.prepareStatement(qg.getQuery().toString());
      rs = ps.executeQuery();
      computers = MapperRsComputerDao.toList(rs);
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qg.getQuery(), e);
    } finally {
      ObjectCloser.close(rs, ps, qg.getQuery().toString());
      transactionManager.closeConnection();
    }

    return computers;
  }

  @Override
  public List<Computer> getAll() {

    List<Computer> computers = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    Connection conn = transactionManager.getConnection();
    QueryGenerator qg = new QueryGenerator.Builder().select("*").from("computer")
        .leftJoinOn("company", "computer.company_id = company.id").build();
    LOGGER.debug(qg.getQuery().toString());
    try {
      ps = conn.prepareStatement(qg.getQuery().toString());
      rs = ps.executeQuery();
      computers = MapperRsComputerDao.toList(rs);
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qg.getQuery(), e);
    } finally {
      ObjectCloser.close(rs, ps, qg.getQuery().toString());
      transactionManager.closeConnection();
    }

    return computers;
  }

  @Override
  public int create(Computer computer) {

    // String createComputerQuery = "INSERT INTO computer VALUES (default, ?, ?, ?, ?)";
    Connection conn = transactionManager.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    int computerId = 0;
    QueryGenerator qg = new QueryGenerator.Builder().insertInto("computer", "(default, ?, ?, ?, ?)")
        .build();
    LOGGER.debug(qg.getQuery().toString());

    try {
      ps = conn.prepareStatement(qg.getQuery().toString(), Statement.RETURN_GENERATED_KEYS);
      ps = MapperComputerDaoPs.toPs(computer, ps);
      ps.executeUpdate();
      rs = ps.getGeneratedKeys();
      rs.next();
      computerId = rs.getInt(1);
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qg.getQuery(), e);
    } finally {
      ObjectCloser.close(rs, ps, qg.getQuery().toString());
      transactionManager.closeConnection();
    }

    return computerId;
  }

  @Override
  public int update(Computer computer) {

    // String updateComputerQuery = "UPDATE computer SET name=?, introduced=?, discontinued=?,
    // company_id=? WHERE id=?";
    Connection conn = transactionManager.getConnection();
    PreparedStatement ps = null;
    QueryGenerator qg = new QueryGenerator.Builder()
        .update("computer", "name=?, introduced=?, discontinued=?, company_id=?").where("id=?")
        .build();
    LOGGER.debug(qg.getQuery().toString());

    try {
      ps = conn.prepareStatement(qg.getQuery().toString());
      ps = MapperComputerDaoPs.toPs(computer, ps);
      ps.setInt(5, computer.getId());
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qg.getQuery().toString(), e);
    } finally {
      ObjectCloser.close(null, ps, qg.getQuery().toString());
      transactionManager.closeConnection();
    }

    return computer.getId();
  }

  @Override
  public void delete(int id) {

    Connection conn = transactionManager.getConnection();
    PreparedStatement ps = null;
    QueryGenerator qg = new QueryGenerator.Builder().deleteFrom("computer").where("id=?").build();
    LOGGER.debug(qg.getQuery().toString());
    try {
      ps = conn.prepareStatement(qg.getQuery().toString());
      ps.setInt(1, id);
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qg.getQuery(), e);
    } finally {
      ObjectCloser.close(null, ps, qg.getQuery().toString());
      transactionManager.closeConnection();
    }

  }

  @Override
  public int count() {

    Connection conn = transactionManager.getConnection();
    ResultSet rs = null;
    PreparedStatement ps = null;
    int count = 0;
    QueryGenerator qg = new QueryGenerator.Builder().selectCountFrom("computer").build();
    LOGGER.debug(qg.getQuery().toString());
    try {
      ps = conn.prepareStatement(qg.getQuery().toString());
      rs = ps.executeQuery();
      rs.next();
      count = rs.getInt(1);
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qg.getQuery(), e);
    } finally {
      ObjectCloser.close(rs, ps, qg.getQuery().toString());
      transactionManager.closeConnection();
    }

    return count;
  }

  @Override
  public void deleteByCompanyId(int companyId) {

    PreparedStatement ps = null;
    Connection conn = transactionManager.getConnection();
    QueryGenerator qsp = new QueryGenerator.Builder().deleteFrom("computer").where("company_id=?")
        .build();
    LOGGER.debug(qsp.getQuery().toString());
    try {
      ps = conn.prepareStatement(qsp.getQuery().toString());
      ps.setInt(1, companyId);
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qsp.getQuery(), e);
    } finally {
      ObjectCloser.close(null, ps, qsp.getQuery().toString());
      transactionManager.closeConnection();
    }

  }

}
