package com.louisamoros.cdb.dao.mapper;

import com.louisamoros.cdb.dao.exception.DaoMapperException;
import com.louisamoros.cdb.model.Computer;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;

public class MapperComputerDaoPs {

  /**
   * To ps.
   *
   * @param computer the computer
   * @param ps the ps
   * @return the prepared statement
   */
  public static PreparedStatement toPs(Computer computer, PreparedStatement ps) {

    try {
      ps.setString(1, computer.getName());
      if (computer.getIntroduced() != null) {
        ps.setTimestamp(2, Timestamp.valueOf(computer.getIntroduced().atStartOfDay()));
      } else {
        ps.setNull(2, Types.TIMESTAMP);
      }
      if (computer.getDiscontinued() != null) {
        ps.setTimestamp(3, Timestamp.valueOf(computer.getDiscontinued().atStartOfDay()));
      } else {
        ps.setNull(3, Types.TIMESTAMP);
      }
      if (computer.getCompany() != null) {
        ps.setInt(4, computer.getCompany().getId());
      } else {
        ps.setNull(4, Types.INTEGER);
      }
    } catch (SQLException e) {
      throw new DaoMapperException("Fail during prepared statement mapping.", e);
    }

    return ps;

  }

}
