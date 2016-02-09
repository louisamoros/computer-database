package com.louisamoros.cdb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.util.Mapper;

/**
 * ComputerDaoImpl implements methods of ComputerDao interface.
 * @author excilys
 *
 */
public class ComputerDaoImpl implements ComputerDao {

	ComputerDaoImpl() {
	}

	public Computer getComputer(int id) {

		String query = "SELECT * FROM computer WHERE id=?;";
		ResultSet rs;
		PreparedStatement ps;
		Computer computer = null;

		try {
			ps = DaoFactory.connect().prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				computer = new Computer(rs.getInt("id"), rs.getInt("company_id"), rs.getString("name"),
						rs.getTimestamp("introduced"), rs.getTimestamp("discontinued"));
			}
		} catch (SQLException e) {
			System.out.println("Error during resquest...");
			e.printStackTrace();
		} finally {
			DaoFactory.close();
		}

		return computer;
	}

	public List<Computer> getComputers() {

		List<Computer> computers = null;
		String query = "SELECT * FROM computer;";
		ResultSet rs;
		Statement s;

		try {
			s = DaoFactory.connect().createStatement();
			rs = s.executeQuery(query);
			return Mapper.toComputerArrayList(rs);
		} catch (SQLException e) {
			System.out.println("Error during resquest...");
			e.printStackTrace();
		} finally {
			DaoFactory.close();
		}

		return computers;
	}

	public Computer createComputer(Computer computer) {

		String query = "INSERT INTO computer VALUES (default, ?, ?, ?, ?);";
		PreparedStatement ps = null;

		try {
			ps = DaoFactory.connect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, computer.getName());
			ps.setTimestamp(2, computer.getIntroducedDate());
			ps.setTimestamp(3, computer.getDiscontinuedDate());
			ps.setInt(4, computer.getCompanyId());
			ps.executeUpdate();
			
			// Use to return object with generated ID.
			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                computer.setComputerId(generatedKeys.getInt(1));
	            }
	            else {
	                throw new SQLException("Creating computer failed, no ID obtained.");
	            }
	        }
		} catch (SQLException e) {
			System.out.println("Error during resquest...");
			e.printStackTrace();
		} finally {
			DaoFactory.close();
		}

		return computer;

	}

	public Computer updateComputer(int id, Computer computer) {
		
		String query = "UPDATE computer SET name=?, introduced=?, discontinued=?, company_id=? WHERE id=?";
		PreparedStatement ps = null;

		try {
			ps = DaoFactory.connect().prepareStatement(query);
			ps.setString(1, computer.getName());
			ps.setTimestamp(2, computer.getIntroducedDate());
			ps.setTimestamp(3, computer.getDiscontinuedDate());
			ps.setInt(4, computer.getCompanyId());
			ps.setInt(5, computer.getComputerId());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error during resquest...");
			e.printStackTrace();
		} finally {
			DaoFactory.close();
		}

		return computer;

	}

	public void deleteComputer(int id) {

		String query = "DELETE FROM computer WHERE id=?";
		PreparedStatement ps = null;

		try {
			ps = DaoFactory.connect().prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error during resquest...");
			e.printStackTrace();
		} finally {
			DaoFactory.close();
		}

	}

}
