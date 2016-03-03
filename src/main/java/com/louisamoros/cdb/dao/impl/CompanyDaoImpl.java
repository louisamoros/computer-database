package com.louisamoros.cdb.dao.impl;

import com.louisamoros.cdb.dao.CompanyDao;
import com.louisamoros.cdb.dao.exception.DaoException;
import com.louisamoros.cdb.dao.mapper.MapperRsCompanyDao;
import com.louisamoros.cdb.dao.util.ObjectCloser;
import com.louisamoros.cdb.dao.util.QueryGenerator;
import com.louisamoros.cdb.model.Company;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

@Repository
public class CompanyDaoImpl implements CompanyDao {

  public static Logger LOGGER = LoggerFactory.getLogger(CompanyDao.class);

  @Autowired
  private DataSource dataSource;

  @Override
  public List<Company> getAll() {

    List<Company> companies = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    Connection conn = null;
    QueryGenerator qg = new QueryGenerator.Builder().select("*").from("company").build();

    try {
      conn = dataSource.getConnection();
      ps = conn.prepareStatement(qg.getQuery().toString());
      rs = ps.executeQuery();

      companies = MapperRsCompanyDao.toList(rs);
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qg.getQuery(), e);
    } finally {
      ObjectCloser.close(rs, ps, qg.getQuery().toString());
    }

    return companies;
  }

  @Override
  public void delete(int companyId) {

    PreparedStatement ps = null;
    Connection conn = null;
    QueryGenerator qg = new QueryGenerator.Builder().deleteFrom("company").where("id=?").build();

    try {
      conn = dataSource.getConnection();
      ps = conn.prepareStatement(qg.getQuery().toString());
      ps.setInt(1, companyId);
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new DaoException("Fail during: " + qg.getQuery(), e);
    } finally {
      ObjectCloser.close(null, ps, qg.getQuery().toString());
    }

  }

}
