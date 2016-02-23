package com.louisamoros.cdb.dao.impl;

import com.louisamoros.cdb.dao.CompanyDao;
import com.louisamoros.cdb.dao.connection.JdbcConnectionImpl;
import com.louisamoros.cdb.dao.exception.DaoException;
import com.louisamoros.cdb.dao.mapper.MapperRsCompanyDao;
import com.louisamoros.cdb.model.Company;

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

  private JdbcConnectionImpl jdbcConnection;
  private static final String GET_COMPANIES_QUERY = "SELECT * FROM company;";
  private static Logger LOGGER = LoggerFactory.getLogger(CompanyDao.class);

  /**
   * Instantiates a new company dao impl.
   */
  private CompanyDaoImpl() {
    jdbcConnection = JdbcConnectionImpl.INSTANCE;
  }

  @Override
  public List<Company> getAll() {

    LOGGER.debug(GET_COMPANIES_QUERY);
    List<Company> companies = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    Connection conn = jdbcConnection.getConnection();

    try {
      ps = conn.prepareStatement(GET_COMPANIES_QUERY);
      rs = ps.executeQuery();
      companies = MapperRsCompanyDao.toList(rs);
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + GET_COMPANIES_QUERY, e);
    } finally {
      ConnectionCloser.close(rs, ps, conn, GET_COMPANIES_QUERY);
    }

    return companies;
  }

}
