package util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Company;
import model.Computer;

public class Mapper {

	public static List<Company> toCompanyArrayList(ResultSet rs) {
		List<Company> companies = new ArrayList<>();
		try {
			while (rs.next()) {
				Company company = new Company(rs.getInt("id"), rs.getString("name"));
				companies.add(company);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return companies;
	}

	public static List<Computer> toComputerArrayList(ResultSet rs) {
		List<Computer> computers = new ArrayList<>();
		try {
			while (rs.next()) {
				Computer computer = new Computer(rs.getInt("id"), rs.getInt("company_id"), rs.getString("name"),
						rs.getTimestamp("introduced"), rs.getTimestamp("discontinued"));
				computers.add(computer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return computers;
	}
}
