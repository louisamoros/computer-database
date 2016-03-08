package com.louisamoros.cdb.dao.mapper;

import com.louisamoros.cdb.model.Company;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implementation of RowMapper for company model.
 */
public class CompanyRowMapper implements RowMapper<Company> {

    @Override
    public final Company mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        // @formatter:off
        return new Company
            .Builder()
            .name(rs.getString("name"))
            .id(rs.getInt("id"))
            .build();
        // @formatter:on
    }

}
