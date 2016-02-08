package util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.ResultSet;

import model.Company;

public class Mapper {

	public static List<Company> toCompanyArrayList(ResultSet rs) {
		List<Company> companies = new ArrayList<>();
		try {
			while(rs.next()) {
				Company company = new Company(rs.getInt("id"),rs.getString("name"));
				companies.add(company);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return companies;
	}	
}
