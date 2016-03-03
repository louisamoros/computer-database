package com.louisamoros.cdb.dao.impl;

import com.louisamoros.cdb.controller.util.QueryParams;
import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.dao.exception.DaoException;
import com.louisamoros.cdb.dao.mapper.MapperComputerDaoPs;
import com.louisamoros.cdb.dao.mapper.MapperRsComputerDao;
import com.louisamoros.cdb.dao.util.ObjectCloser;
import com.louisamoros.cdb.dao.util.QueryGenerator;
import com.louisamoros.cdb.model.Computer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

@Repository
public class ComputerDaoImpl implements ComputerDao {

  public static Logger LOGGER = LoggerFactory.getLogger(ComputerDao.class);

  @Autowired
  private DataSource dataSource;

  @Override
  public Computer get(int id) {

    ResultSet rs = null;
    PreparedStatement ps = null;
    Computer computer = null;
    Connection conn = null;

    // @formatter:off
    QueryGenerator qg = new QueryGenerator
        .Builder()
        .select("*")
        .from("computer")
        .leftJoinOn("company", "computer.company_id = company.id")
        .where("computer.id=?")
        .build();
    // @formatter:on

    LOGGER.info(qg.getQuery().toString());

    try {
      conn = dataSource.getConnection();
      ps = conn.prepareStatement(qg.getQuery().toString());
      ps.setInt(1, id);
      rs = ps.executeQuery();
      computer = MapperRsComputerDao.toComputer(rs);
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qg.getQuery(), e);
    } finally {
      ObjectCloser.close(rs, ps, qg.getQuery().toString());
    }

    return computer;
  }

  @Override
  public List<Computer> get(QueryParams qp) {

    List<Computer> computers = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    Connection conn = null;

    // @formatter:off
    QueryGenerator qg = new QueryGenerator
        .Builder()
        .select("*")
        .from("computer")
        .leftJoinOn("company", "computer.company_id = company.id")
        .orderBy(qp.getOrderBy())
        .order(qp.getOrder())
        .limit(String.valueOf(qp.getLimit()))
        .offset(String.valueOf(qp.getOffset()))
        .build();
    // @formatter:on

    LOGGER.info(qg.getQuery().toString());

    try {
      conn = dataSource.getConnection();
      ps = conn.prepareStatement(qg.getQuery().toString());
      rs = ps.executeQuery();
      computers = MapperRsComputerDao.toList(rs);
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qg.getQuery(), e);
    } finally {
      ObjectCloser.close(rs, ps, qg.getQuery().toString());
    }

    return computers;
  }

  @Override
  public List<Computer> getAll() {

    List<Computer> computers = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    Connection conn = null;

    // @formatter:off
    QueryGenerator qg = new QueryGenerator
        .Builder()
        .select("*")
        .from("computer")
        .leftJoinOn("company", "computer.company_id = company.id")
        .build();
    // @formatter:off
    
    LOGGER.info(qg.getQuery().toString());
    
    try {
      conn = dataSource.getConnection();
      ps = conn.prepareStatement(qg.getQuery().toString());
      rs = ps.executeQuery();
      computers = MapperRsComputerDao.toList(rs);
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qg.getQuery(), e);
    } finally {
      ObjectCloser.close(rs, ps, qg.getQuery().toString());
    }

    return computers;
  }

  @Override
  public int create(Computer computer) {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int computerId = 0;

    // @formatter:off
    QueryGenerator qg = new QueryGenerator
        .Builder()
        .insertInto("computer", "(default, ?, ?, ?, ?)")
        .build();
    // @formatter:on

    LOGGER.info(qg.getQuery().toString());

    try {
      conn = dataSource.getConnection();
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
    }

    return computerId;
  }

  @Override
  public int update(Computer computer) {

    Connection conn = null;
    PreparedStatement ps = null;

    // @formatter:off
    QueryGenerator qg = new QueryGenerator
        .Builder()
        .update("computer", "name=?, introduced=?, discontinued=?, company_id=?")
        .where("id=?")
        .build();
    // @formatter:on

    LOGGER.info(qg.getQuery().toString());

    try {
      conn = dataSource.getConnection();
      ps = conn.prepareStatement(qg.getQuery().toString());
      ps = MapperComputerDaoPs.toPs(computer, ps);
      ps.setInt(5, computer.getId());
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qg.getQuery().toString(), e);
    } finally {
      ObjectCloser.close(null, ps, qg.getQuery().toString());
    }

    return computer.getId();
  }

  @Override
  public void delete(int id) {

    Connection conn = null;
    PreparedStatement ps = null;

    // @formatter:off
    QueryGenerator qg = new QueryGenerator
        .Builder()
        .deleteFrom("computer")
        .where("id=?")
        .build();
    // @formatter:on

    LOGGER.info(qg.getQuery().toString());

    try {
      conn = dataSource.getConnection();
      ps = conn.prepareStatement(qg.getQuery().toString());
      ps.setInt(1, id);
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qg.getQuery(), e);
    } finally {
      ObjectCloser.close(null, ps, qg.getQuery().toString());
    }

  }

  @Override
  public int count() {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    int count = 0;

    // @formatter:off
    QueryGenerator qg = new QueryGenerator
        .Builder()
        .selectCountFrom("computer")
        .build();
    // @formatter:on

    LOGGER.info(qg.getQuery().toString());

    try {
      conn = dataSource.getConnection();
      ps = conn.prepareStatement(qg.getQuery().toString());
      rs = ps.executeQuery();
      rs.next();
      count = rs.getInt(1);
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qg.getQuery(), e);
    } finally {
      ObjectCloser.close(rs, ps, qg.getQuery().toString());
    }

    return count;
  }

  @Override
  public void deleteByCompanyId(int companyId) {

    PreparedStatement ps = null;
    Connection conn = null;

    // @formatter:off
    QueryGenerator qsp = new QueryGenerator
        .Builder()
        .deleteFrom("computer")
        .where("company_id=?")
        .build();
    // @formatter:off
    
    LOGGER.info(qsp.getQuery().toString());
    
    try {
      conn = dataSource.getConnection();
      ps = conn.prepareStatement(qsp.getQuery().toString());
      ps.setInt(1, companyId);
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qsp.getQuery(), e);
    } finally {
      ObjectCloser.close(null, ps, qsp.getQuery().toString());
    }

  }

}
