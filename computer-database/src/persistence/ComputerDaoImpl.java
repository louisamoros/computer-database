package persistence;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import model.Computer;
import util.Mapper;

public class ComputerDaoImpl implements ComputerDao {

	ComputerDaoImpl() {
	}

	public Computer getComputer(int id) {

		String query = "SELECT * FROM computer WHERE id=?;";
		ResultSet results;
		PreparedStatement ps;
		Computer computer = null;

		try {
			ps = (PreparedStatement) DaoFactory.connect().prepareStatement(query);
			ps.setInt(1, id);
			results = (ResultSet) ps.executeQuery();
			while(results.next()) {
				computer = new Computer (
						results.getInt("id"),
						results.getInt("company_id"),
						results.getString("name"),
						results.getTimestamp("introduced"),
						results.getTimestamp("discontinued")
				);
			}
		} catch (SQLException e1) {
			System.out.println("Error during resquest...");
			e1.printStackTrace();
		} finally {
			DaoFactory.close();
		}

		return computer;
	}

	public List<Computer> getComputers() {
	
		List<Computer> computers = null;
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
