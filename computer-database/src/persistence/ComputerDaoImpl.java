package persistence;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import model.Company;
import model.Computer;
import util.Mapper;

public class ComputerDaoImpl implements ComputerDao {

	ComputerDaoImpl() {
	}

	public Computer getComputer(int id) {
		// TODO
		return null;
	}

	public List<Computer> getComputers() {
	
		List<Computer> computers= null;
		String query = "SELECT * FROM computer;";
		ResultSet results;
		Statement stmt;

		try {
			stmt = (Statement) DaoFactory.connect().createStatement();
			results = (ResultSet) stmt.executeQuery(query);
			return Mapper.toComputerArrayList(results);
		} catch (SQLException e1) {
			System.out.println("Error during resquest...");
			e1.printStackTrace();
		} finally {
			DaoFactory.close();
		}

		return computers;
	}
	
	public Computer createComputer() {
		// TODO
		return null;
	}

	public Computer updateComputer(int id) {
		// TODO
		return null;
	}

	public void deleteComputer(int id) {
		// TODO
	}

}
