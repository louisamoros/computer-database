package com.louisamoros.cdb.dao.impl;

import com.louisamoros.cdb.controller.util.QueryParams;
import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.dao.mapper.ComputerRowMapper;
import com.louisamoros.cdb.dao.util.QueryGenerator;
import com.louisamoros.cdb.model.Computer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ComputerDaoImpl implements ComputerDao {

  public static Logger LOGGER = LoggerFactory.getLogger(ComputerDao.class);

  @Autowired
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Override
  public Computer get(int id) {

    // @formatter:off
    QueryGenerator queryGenerator = new QueryGenerator
        .Builder()
        .select("*")
        .from("computer")
        .leftJoinOn("company", "computer.company_id = company.id")
        .where("computer.id=:computerId")
        .build();
    // @formatter:on

    LOGGER.info(queryGenerator.getQuery().toString());
    SqlParameterSource namedParameters = new MapSqlParameterSource("computerId", id);
    return namedParameterJdbcTemplate.queryForObject(queryGenerator.getQuery().toString(),
        namedParameters, new ComputerRowMapper());
  }

  @Override
  public List<Computer> get(QueryParams queryParams) {

    // @formatter:off
    QueryGenerator queryGenerator = new QueryGenerator
        .Builder()
        .select("*")
        .from("computer")
        .leftJoinOn("company", "computer.company_id = company.id")
        .orderBy(queryParams.getOrderBy())
        .order(queryParams.getOrder())
        .limit(String.valueOf(queryParams.getLimit()))
        .offset(String.valueOf(queryParams.getOffset()))
        .build();
    // @formatter:on

    LOGGER.info(queryGenerator.getQuery().toString());
    SqlParameterSource namedParameters = new MapSqlParameterSource();

    return namedParameterJdbcTemplate.query(queryGenerator.getQuery().toString(), namedParameters,
        new ComputerRowMapper());
  }

  @Override
  public List<Computer> getAll() {

    // @formatter:off
    QueryGenerator queryGenerator = new QueryGenerator
        .Builder()
        .select("*")
        .from("computer")
        .leftJoinOn("company", "computer.company_id = company.id")
        .build();
    // @formatter:off
    
    LOGGER.info(queryGenerator.getQuery().toString());
    return namedParameterJdbcTemplate.query(queryGenerator.getQuery().toString(), new HashMap<>(), new ComputerRowMapper());
  }

  @Override
  public int create(Computer computer) {

    // @formatter:off
    QueryGenerator queryGenerator = new QueryGenerator
        .Builder()
        .insertInto("computer", "(default, :computerName, :introduced, :discontinued, :company.companyId)")
        .build();
    // @formatter:on

    LOGGER.info(queryGenerator.getQuery().toString());
    // map the computer class model based on the class name attributes.
    SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(computer);
    return namedParameterJdbcTemplate.update(queryGenerator.getQuery().toString(), namedParameters);
  }

  @Override
  public int update(Computer computer) {

    // @formatter:off
    QueryGenerator qg = new QueryGenerator
        .Builder()
        .update("computer", "name=:computerName, introduced=:introduced, discontinued=:discontinued, company_id=:company.companyId")
        .where("id=:computerId")
        .build();
    // @formatter:on

    LOGGER.info(qg.getQuery().toString());

    // map the computer class model based on the class name attributes.
    SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(computer);
    System.out.println(namedParameters.getValue("company"));
    // System.out.println(namedParameters);
    namedParameterJdbcTemplate.update(qg.getQuery().toString(), namedParameters);
    return 2;
  }

  @Override
  public void delete(int computerId) {

    // @formatter:off
    QueryGenerator qg = new QueryGenerator
        .Builder()
        .deleteFrom("computer")
        .where("id=:id")
        .build();
    // @formatter:on

    LOGGER.info(qg.getQuery().toString());
    SqlParameterSource namedParameters = new MapSqlParameterSource("id", computerId);
    namedParameterJdbcTemplate.update(qg.getQuery().toString(), namedParameters);
    LOGGER.info("The deleted computer Id: " + computerId);
  }

  @Override
  public int count() {

    // @formatter:off
    QueryGenerator qg = new QueryGenerator
        .Builder()
        .selectCountFrom("computer")
        .build();
    // @formatter:on

    LOGGER.info(qg.getQuery().toString());
    SqlParameterSource namedParameters = new MapSqlParameterSource();
    return namedParameterJdbcTemplate.queryForObject(qg.getQuery().toString(), namedParameters,
        Integer.class);
  }

  @Override
  public void deleteByCompanyId(int companyId) {

    // @formatter:off
    QueryGenerator queryGenerator = new QueryGenerator
        .Builder()
        .deleteFrom("computer")
        .where("company_id=:companyId")
        .build();
    // @formatter:off
    
    LOGGER.info(queryGenerator.getQuery().toString());
    SqlParameterSource namedParameters = new MapSqlParameterSource("companyId", companyId);
    namedParameterJdbcTemplate.update(queryGenerator.getQuery().toString(), namedParameters);
    LOGGER.info("The deleted company Id (deleteByCompanyId): " + companyId);
  }

}
