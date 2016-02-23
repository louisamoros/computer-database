package com.louisamoros.cdb.dao.impl;

import com.louisamoros.cdb.dao.CompanyDao;
import com.louisamoros.cdb.dao.connection.ConnectionManager;
import com.louisamoros.cdb.dao.connection.ConnectionManagerImpl;
import com.louisamoros.cdb.dao.exception.DaoException;
import com.louisamoros.cdb.dao.mapper.MapperRsCompanyDao;
import com.louisamoros.cdb.dao.util.QueryStatementGenerator;
import com.louisamoros.cdb.model.Company;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * The Enum CompanyDaoImpl.
 */
public enum CompanyDaoImpl implements CompanyDao {

  INSTANCE;

  public static Logger LOGGER = LoggerFactory.getLogger(CompanyDao.class);
  private ConnectionManager connectionManager;

  private CompanyDaoImpl() {
    connectionManager = ConnectionManagerImpl.INSTANCE;
  }

  @Override
  public List<Company> getAll() {

    List<Company> companies = null;
    ResultSet rs = null;
    Connection conn = connectionManager.getConnection();
    QueryStatementGenerator qsp = new QueryStatementGenerator.Builder(conn).select("*")
        .from("company").build();

    try {
      rs = qsp.getPreparedStatement().executeQuery();
      companies = MapperRsCompanyDao.toList(rs);
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qsp.getQuery(), e);
    } finally {
      ObjectCloser.close(rs, qsp.getPreparedStatement(), qsp.getQuery().toString());
    }

    return companies;
  }

  @Override
  public void delete(int companyId) {

    Connection conn = connectionManager.getConnection();
    QueryStatementGenerator qsp = new QueryStatementGenerator.Builder(conn).deleteFrom("company")
        .where("id=?", String.valueOf(companyId)).build();;

    try {
      qsp.getPreparedStatement().executeUpdate();
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qsp.getQuery(), e);
    } finally {
      ObjectCloser.close(null, qsp.getPreparedStatement(), qsp.getQuery().toString());
    }

  }

}
