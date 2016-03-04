package com.louisamoros.cdb.dao.mapper;

import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.model.Computer;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ComputerRowMapper implements RowMapper<Computer> {

  @Override
  public Computer mapRow(ResultSet rs, int rowNum) throws SQLException {
    LocalDate dateIntroduced = null;
    LocalDate dateDiscontinued = null;
    if (rs.getTimestamp("introduced") != null) {
      dateIntroduced = rs.getTimestamp("introduced").toLocalDateTime().toLocalDate();
    }
    if (rs.getTimestamp("discontinued") != null) {
      dateDiscontinued = rs.getTimestamp("discontinued").toLocalDateTime().toLocalDate();
    }
    // @formatter:off
    return new Computer
        .Builder(rs.getString("computer.name"))
        .id(rs.getInt("computer.id"))
        .company(new Company
            .Builder()
            .id(rs.getInt("company.id"))
            .name(rs.getString("company.name"))
            .build())
        .introduced(dateIntroduced)
        .discontinued(dateDiscontinued)
        .build();
    // @formatter:on
  }

}