package com.louisamoros.cdb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.util.JDBCConnection;
import com.louisamoros.cdb.util.Mapper;

/**
 * ComputerDaoImpl implements methods of ComputerDao interface.
 * 
 * @author excilys
 *
 */
public enum ComputerDaoImpl implements ComputerDao {

	INSTANCE;

	private JDBCConnection connectionUtilInstance;

	private ComputerDaoImpl() {
		connectionUtilInstance = JDBCConnection.INSTANCE;
	}

	public Computer getComputer(int id) {

		String query = "SELECT * FROM computer LEFT JOIN company ON computer.company_id = company.id WHERE computer.id=?;";
		ResultSet rs;
		PreparedStatement ps;
		Computer computer = null;
		Connection conn = connectionUtilInstance.getConnection();

		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			computer = Mapper.toComputerModel(rs);
		} catch (SQLException e) {
			System.out.println("Error during resquest...");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return computer;
	}

	public List<Computer> getComputers() {

		List<Computer> computers = null;
		String query = "SELECT * FROM computer LEFT JOIN company ON computer.company_id = company.id;";
		ResultSet rs;
		Statement s;
		Connection conn = connectionUtilInstance.getConnection();

		try {
			s = conn.createStatement();
			rs = s.executeQuery(query);
			computers = Mapper.toComputerArrayList(rs);
		} catch (SQLException e) {
			System.out.println("Error during resquest...");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return computers;
	}

	public Computer createComputer(Computer computer) {

		String query = "INSERT INTO computer VALUES (default, ?, ?, ?, ?);";
		PreparedStatement ps = null;
		Connection conn = connectionUtilInstance.getConnection();

		try {
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, computer.getName());
			ps.setTimestamp(2, Timestamp.valueOf(computer.getIntroducedDate().atStartOfDay()));
			ps.setTimestamp(3, Timestamp.valueOf(computer.getDiscontinuedDate().atStartOfDay()));
			ps.setInt(4, computer.getCompany().getCompanyId());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			computer.setComputerId(rs.getInt(1));
		} catch (SQLException e) {
			System.out.println("Error during resquest...");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return computer;

	}

	public Computer updateComputer(int id, Computer computer) {

		String query = "UPDATE computer SET name=?, introduced=?, discontinued=?, company_id=? WHERE id=?";
		PreparedStatement ps = null;
		Connection conn = connectionUtilInstance.getConnection();

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, computer.getName());
			ps.setTimestamp(2, Timestamp.valueOf(computer.getIntroducedDate().atStartOfDay()));
			ps.setTimestamp(3, Timestamp.valueOf(computer.getDiscontinuedDate().atStartOfDay()));
			ps.setInt(4, computer.getCompany().getCompanyId());
			ps.setInt(5, computer.getComputerId());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error during resquest...");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return computer;

	}

	public void deleteComputer(int id) {

		String query = "DELETE FROM computer WHERE id=?";
		PreparedStatement ps = null;
		Connection conn = connectionUtilInstance.getConnection();

		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error during resquest...");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
