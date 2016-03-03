package com.louisamoros.cdb.dao.mapper;

import com.louisamoros.cdb.dao.exception.DaoMapperException;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.model.Computer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MapperRsComputerDao {

  /**
   * To list.
   *
   * @param rs the rs
   * @return the list
   * @throws DaoMapperException the dao mapper exception
   */
  public static List<Computer> toList(ResultSet rs) {
    List<Computer> computers = new ArrayList<Computer>();
    try {
      while (rs.next()) {
        LocalDate dateIntroduced = null;
        LocalDate dateDiscontinued = null;
        if (rs.getTimestamp("introduced") != null) {
          dateIntroduced = rs.getTimestamp("introduced").toLocalDateTime().toLocalDate();
        }
        if (rs.getTimestamp("discontinued") != null) {
          dateDiscontinued = rs.getTimestamp("discontinued").toLocalDateTime().toLocalDate();
        }
        // @formatter:off
        Computer computer = new Computer
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
        computers.add(computer);
      }
    } catch (SQLException e) {
      throw new DaoMapperException("Fail to map ResultSet of Computer to List of Computer.", e);
    }
    return computers;
  }

  /**
   * To computer.
   *
   * @param rs the rs
   * @return the computer
   * @throws DaoMapperException the dao mapper exception
   */
  public static Computer toComputer(ResultSet rs) {
    Computer computer = null;
    try {
      while (rs.next()) {
        LocalDate dateIntroduced = null;
        LocalDate dateDiscontinued = null;
        if (rs.getTimestamp("introduced") != null) {
          dateIntroduced = rs.getTimestamp("introduced").toLocalDateTime().toLocalDate();
        }
        if (rs.getTimestamp("discontinued") != null) {
          dateDiscontinued = rs.getTimestamp("discontinued").toLocalDateTime().toLocalDate();
        }
        // @formatter:off
        computer = new Computer
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
    } catch (SQLException e) {
      throw new DaoMapperException("Fail to map ResultSet to Computer.", e);
    }
    return computer;
  }

}
