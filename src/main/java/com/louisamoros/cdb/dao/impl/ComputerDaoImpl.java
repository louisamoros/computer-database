package com.louisamoros.cdb.dao.impl;

import com.louisamoros.cdb.controller.util.Params;
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

/**
 * Spring repository for implementation of computer dao.
 */
@Repository
public class ComputerDaoImpl implements ComputerDao {

    /**
     * Logger of the class.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(ComputerDao.class);

    /**
     * Autowired spring injection of jdbc template (named parameter overlay).
     */
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public final Computer get(final int id) {

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
    public final List<Computer> get(final Params params) {

        // @formatter:off
        QueryGenerator queryGenerator = new QueryGenerator
            .Builder()
            .select("*")
            .from("computer")
            .leftJoinOn("company", "computer.company_id = company.id")
            .where("computer.name")
            .like(params.getSearch())
            .or("company.name")
            .like(params.getSearch())
            .orderBy(params.getBy())
            .order(params.getOrder())
            .limit(String.valueOf(params.getLimit()))
            .offset(String.valueOf(params.getOffset()))
            .build();
        // @formatter:on
        LOGGER.info(queryGenerator.getQuery().toString());
        SqlParameterSource namedParameters = new MapSqlParameterSource();
        List<Computer> list = namedParameterJdbcTemplate.query(queryGenerator.getQuery().toString(),
                namedParameters, new ComputerRowMapper());
        System.out.println(list.size());
        return list;
    }

    @Override
    public final List<Computer> getAll() {

        // @formatter:off
        QueryGenerator queryGenerator = new QueryGenerator
            .Builder()
            .select("*")
            .from("computer")
            .leftJoinOn("company", "computer.company_id = company.id")
            .build();
        // @formatter:on
        LOGGER.info(queryGenerator.getQuery().toString());
        return namedParameterJdbcTemplate.query(queryGenerator.getQuery().toString(),
                new HashMap<>(), new ComputerRowMapper());

    }

    @Override
    public final int create(final Computer computer) {

        // @formatter:off
        QueryGenerator queryGenerator = new QueryGenerator
            .Builder()
            .insertInto("computer", "(default, :computerName, :introduced, :discontinued, :company.companyId)")
            .build();
        // @formatter:on

        LOGGER.info(queryGenerator.getQuery().toString());
        // map the computer class model based on the class name attributes.
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(computer);
        return namedParameterJdbcTemplate.update(queryGenerator.getQuery().toString(),
                namedParameters);

    }

    @Override
    public final int update(final Computer computer) {

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
        namedParameterJdbcTemplate.update(qg.getQuery().toString(), namedParameters);
        return 2;

    }

    @Override
    public final void delete(final int computerId) {

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
    public final int count(final Params params) {
        // @formatter:off
        QueryGenerator qg = new QueryGenerator
            .Builder()
            .selectCountFrom("computer")
            .leftJoinOn("company", "computer.company_id = company.id")
            .where("computer.name")
            .like(params.getSearch())
            .or("company.name")
            .like(params.getSearch())
            .build();
        // @formatter:on

        LOGGER.info(qg.getQuery().toString());
        SqlParameterSource namedParameters = new MapSqlParameterSource();
        return namedParameterJdbcTemplate.queryForObject(qg.getQuery().toString(), namedParameters,
                Integer.class);

    }

    @Override
    public final void deleteByCompanyId(final int companyId) {

        // @formatter:off
        QueryGenerator queryGenerator = new QueryGenerator
            .Builder()
            .deleteFrom("computer")
            .where("company_id=:companyId")
            .build();
        // @formatter:on
        LOGGER.info(queryGenerator.getQuery().toString());
        SqlParameterSource namedParameters = new MapSqlParameterSource("companyId", companyId);
        namedParameterJdbcTemplate.update(queryGenerator.getQuery().toString(), namedParameters);
        LOGGER.info("The deleted company Id (deleteByCompanyId): " + companyId);

    }

}
