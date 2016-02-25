package com.louisamoros.cdb.dao.impl;

import com.louisamoros.cdb.dao.CompanyDao;
import com.louisamoros.cdb.dao.exception.DaoException;
import com.louisamoros.cdb.dao.mapper.MapperRsCompanyDao;
import com.louisamoros.cdb.dao.util.ObjectCloser;
import com.louisamoros.cdb.dao.util.QueryGenerator;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.service.util.TransactionManager;
import com.louisamoros.cdb.service.util.TransactionManagerImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * The Enum CompanyDaoImpl.
 */
public enum CompanyDaoImpl implements CompanyDao {

  INSTANCE;

  public static Logger LOGGER = LoggerFactory.getLogger(CompanyDao.class);
  private TransactionManager transactionManager;

  private CompanyDaoImpl() {
    transactionManager = TransactionManagerImpl.INSTANCE;
  }

  @Override
  public List<Company> getAll() {

    List<Company> companies = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    Connection conn = transactionManager.getConnection();
    QueryGenerator qg = new QueryGenerator.Builder().select("*").from("company").build();

    try {
      ps = conn.prepareStatement(qg.getQuery().toString());
      rs = ps.executeQuery();

      companies = MapperRsCompanyDao.toList(rs);
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qg.getQuery(), e);
    } finally {
      ObjectCloser.close(rs, ps, qg.getQuery().toString());
      transactionManager.closeConnection();
    }

    return companies;
  }

  @Override
  public void delete(int companyId) {

    PreparedStatement ps = null;
    Connection conn = transactionManager.getConnection();
    QueryGenerator qg = new QueryGenerator.Builder().deleteFrom("company").where("id=?").build();

    try {
      ps = conn.prepareStatement(qg.getQuery().toString());
      ps.setInt(1, companyId);
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qg.getQuery(), e);
    } finally {
      ObjectCloser.close(null, ps, qg.getQuery().toString());
      transactionManager.closeConnection();
    }

  }

}
