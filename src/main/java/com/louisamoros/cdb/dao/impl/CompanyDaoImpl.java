package com.louisamoros.cdb.dao.impl;

import com.louisamoros.cdb.dao.CompanyDao;
import com.louisamoros.cdb.dao.util.QueryGenerator;
import com.louisamoros.cdb.model.Company;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

@Repository
public class CompanyDaoImpl implements CompanyDao {

  public static Logger LOGGER = LoggerFactory.getLogger(CompanyDao.class);

  @Autowired
  private DataSource dataSource;

  @Override
  public List<Company> getAll() {
    QueryGenerator qg = new QueryGenerator.Builder().select("*").from("company").build();
    return new ArrayList<Company>();
    // return companies;
  }

  @Override
  public void delete(int companyId) {
    QueryGenerator qg = new QueryGenerator.Builder().deleteFrom("company").where("id=?").build();
  }

}
