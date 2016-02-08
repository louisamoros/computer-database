package persistence;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import model.Company;
import util.Mapper;

public class CompanyDaoImpl implements CompanyDao {

	CompanyDaoImpl() {}

	public List<Company> getCompanies() {
		
		List<Company> companies = null;
		String query = "SELECT * FROM company;";
		ResultSet results;
		Statement stmt;

		try {
			stmt = (Statement) DaoFactory.connect().createStatement();
			results = (ResultSet) stmt.executeQuery(query);
			return Mapper.toCompanyArrayList(results);
		} catch (SQLException e1) {
			System.out.println("Error during resquest...");
			e1.printStackTrace();
		} finally {
			DaoFactory.close();
		}

		return companies;
	}

}
