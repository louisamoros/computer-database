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

/**
 * Spring repository for implementation of company dao.
 */
@Repository
public class CompanyDaoImpl implements CompanyDao {

    /**
     * Logger for the class.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(CompanyDao.class);

    /**
     * Autowired spring injection of jdbc template (named parameter overlay).
     */
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public final List<Company> getAll() {

        // @formatter:off
        QueryGenerator queryGenerator = new QueryGenerator
            .Builder()
            .select("*")
            .from("company")
            .build();
        // @formatter:on
        LOGGER.info(queryGenerator.getQuery().toString());
        return namedParameterJdbcTemplate.query(queryGenerator.getQuery().toString(), new HashMap<>(),
                new CompanyRowMapper());

    }

    @Override
    public final void delete(final int companyId) {

        // @formatter:off
        QueryGenerator queryGenerator = new QueryGenerator
            .Builder()
            .deleteFrom("company")
            .where("id=:companyId")
            .build();
        // @formatter:on
        LOGGER.info(queryGenerator.getQuery().toString());
        SqlParameterSource namedParameters = new MapSqlParameterSource("companyId", companyId);
        namedParameterJdbcTemplate.update(queryGenerator.getQuery().toString(), namedParameters);

    }

}
