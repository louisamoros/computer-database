package com.louisamoros.cdb.dao.impl;

import com.louisamoros.cdb.dao.CompanyDao;
import com.louisamoros.cdb.dao.mapper.CompanyRowMapper;
import com.louisamoros.cdb.dao.util.QueryGenerator;
import com.louisamoros.cdb.model.Company;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class CompanyDaoImpl implements CompanyDao {

  public static Logger LOGGER = LoggerFactory.getLogger(CompanyDao.class);

  @Autowired
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Override
  public List<Company> getAll() {
    // @formatter:off
    QueryGenerator queryGenerator = new QueryGenerator
        .Builder()
        .select("*")
        .from("company")
        .build();
    // @formatter:on
    LOGGER.info(queryGenerator.getQuery().toString());
    return namedParameterJdbcTemplate.query(queryGenerator.getQuery().toString(), new HashMap(),
        new CompanyRowMapper());
  }

  @Override
  public void delete(int companyId) {
    // @formatter:off
    QueryGenerator queryGenerator = new QueryGenerator
        .Builder()
        .deleteFrom("company")
        .where("id=:companyId")
        .build();
    // @formatter:on
    LOGGER.info(queryGenerator.getQuery().toString());
    SqlParameterSource namedParameters = new MapSqlParameterSource("companyId", companyId);
    namedParameterJdbcTemplate.queryForObject(queryGenerator.getQuery().toString(), namedParameters,
        Integer.class);
  }

}
