//package com.louisamoros.cdb.util;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.louisamoros.cdb.dao.ComputerDao;
//import com.louisamoros.cdb.dto.ComputerDto;
//import com.louisamoros.cdb.model.Company;
//import com.louisamoros.cdb.model.Computer;
//
///**
// * Class with static method use to convert DTO to DAO.
// * 
// * @author excilys
// *
// */
//public class MapperDto {
//
//	/**
//	 * Convert resultSet to arrayList based on company model.
//	 * 
//	 * @param resultSet<Company>
//	 * @return companies list
//	 */
//	public static ComputerDao toCompanyDao(ComputerDto dto) {
//		ComputerDto dto;
//		
//		return companies;
//	}
//
//	/**
//	 * Convert resultSet to arrayList based on computer model.
//	 * 
//	 * @param resultSet<Computer>
//	 * @return computers list
//	 */
//	public static List<Computer> toComputerArrayList(ResultSet rs) {
//		List<Computer> computers = new ArrayList<Computer>();
//		try {
//			while (rs.next()) {
//				LocalDate dateIntroduced = null;
//				LocalDate dateDiscontinued = null;
//				if (rs.getTimestamp("introduced") != null) {
//					dateIntroduced = rs.getTimestamp("introduced").toLocalDateTime().toLocalDate();
//				}
//				if (rs.getTimestamp("discontinued") != null) {
//					dateDiscontinued = rs.getTimestamp("discontinued").toLocalDateTime().toLocalDate();
//				}
//				Computer computer = new Computer(rs.getInt("computer.id"),
//						new Company(rs.getInt("company.id"), rs.getString("company.name")),
//						rs.getString("computer.name"), dateIntroduced, dateDiscontinued);
//				computers.add(computer);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return computers;
//	}
//	
//	/**
//	 * This method transform a computer resultSet to a computer model
//	 * @param resultSet
//	 * @return computer
//	 */
//	public static Computer toComputerModel(ResultSet rs) {
//		Computer computer = null;
//		try {
//			while (rs.next()) {
//				LocalDate dateIntroduced = null;
//				LocalDate dateDiscontinued = null;
//				if (rs.getTimestamp("introduced") != null) {
//					dateIntroduced = rs.getTimestamp("introduced").toLocalDateTime().toLocalDate();
//				}
//				if (rs.getTimestamp("discontinued") != null) {
//					dateDiscontinued = rs.getTimestamp("discontinued").toLocalDateTime().toLocalDate();
//				}
//				computer = new Computer(rs.getInt("computer.id"),
//						new Company(rs.getInt("company.id"), rs.getString("company.name")),
//						rs.getString("computer.name"), dateIntroduced, dateDiscontinued);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return computer;
//	}
//	
//}