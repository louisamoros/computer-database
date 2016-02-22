package com.louisamoros.cdb.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDate;

import com.louisamoros.cdb.dao.exception.DaoMapperException;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.model.Computer;
import java.sql.PreparedStatement;

public class MapperComputerDaoPs {

	/**
	 * To list.
	 *
	 * @param rs the rs
	 * @return the list
	 * @throws DaoMapperException the DAO mapper exception
	 */
	public static PreparedStatement toPs(Computer computer, PreparedStatement ps) throws DaoMapperException {

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
		} catch(SQLException e) {
			throw new DaoMapperException("Fail during prepared statement mapping." + e);
		}
				
		return ps;
	
	}

	/**
	 * To computer.
	 *
	 * @param rs the rs
	 * @return the computer
	 * @throws DaoMapperException the DAO mapper exception
	 */
	public static Computer toComputer(ResultSet rs) throws DaoMapperException {
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
				computer = new Computer.Builder(rs.getString("computer.name"))
						.id(rs.getInt("computer.id")).company(new Company.Builder().id(rs.getInt("company.id"))
								.name(rs.getString("company.name")).build())
						.introduced(dateIntroduced).discontinued(dateDiscontinued).build();
			}
		} catch (SQLException e) {
			throw new DaoMapperException("Fail to map ResultSet to Computer.", e);
		}
		return computer;
	}
	
}
