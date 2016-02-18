package com.louisamoros.cdb.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.louisamoros.cdb.dao.exception.DAOMapperException;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.model.Computer;

/**
 * Mapper class with static method use to convert ResultSet to List for
 * <Computer> object model.
 * 
 * @author louis
 *
 */
public class MapperComputerDao {

	/**
	 * Convert ResultSet to List<Computer> based on <Computer> model.
	 * 
	 * @param ResultSet<Computer>
	 * @return List<Computer>
	 */
	public static List<Computer> toList(ResultSet rs) throws DAOMapperException {
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
				Computer computer = new Computer.Builder(rs.getString("computer.name"))
						.id(rs.getInt("computer.id"))
						.company(new Company.Builder().id(rs.getInt("company.id")).name(rs.getString("company.name")).build())
						.introduced(dateIntroduced)
						.discontinued(dateDiscontinued)
						.build();
				computers.add(computer);
			}
		} catch (SQLException e) {
			throw new DAOMapperException("Fail to map ResultSet of Computer to List of Computer.", e);
		}
		return computers;
	}

	/**
	 * Convert ResultSet to <Computer> model
	 * 
	 * @param ResultSet
	 * @return <Computer>
	 */
	public static Computer toComputer(ResultSet rs) throws DAOMapperException {
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
						.id(rs.getInt("computer.id"))
						.company(new Company.Builder().id(rs.getInt("company.id")).name(rs.getString("company.name")).build())
						.introduced(dateIntroduced)
						.discontinued(dateDiscontinued)
						.build();
			}
		} catch (SQLException e) {
			throw new DAOMapperException("Fail to map ResultSet to Computer.", e);
		}
		return computer;
	}
}
