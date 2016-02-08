package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.Company;
import util.Mapper;

public class CompanyDaoImpl implements CompanyDao {

	CompanyDaoImpl() {
	}

	public List<Company> getCompanies() {

		List<Company> companies = null;
		String query = "SELECT * FROM company;";
		ResultSet rs;
		Statement s;

		try {
			s = DaoFactory.connect().createStatement();
			rs = s.executeQuery(query);
			return Mapper.toCompanyArrayList(rs);
		} catch (SQLException e) {
			System.out.println("Error during resquest...");
			e.printStackTrace();
		} finally {
			DaoFactory.close();
		}

		return companies;

	}

}
