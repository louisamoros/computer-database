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
	private static final String GET_COMPUTER_QUERY = "SELECT * FROM computer LEFT JOIN company ON computer.company_id = company.id WHERE computer.id=?;";
	private static final String GET_COMPUTERS_QUERY = "SELECT * FROM computer LEFT JOIN company ON computer.company_id = company.id;";
	private static final String UPDATE_COMPUTER_QUERY = "UPDATE computer SET name=?, introduced=?, discontinued=?, company_id=? WHERE id=?";
	private static final String DELETE_COMPUTER_QUERY = "DELETE FROM computer WHERE id=?";
	private static final String CREATE_COMPUTER_QUERY = "INSERT INTO computer VALUES (default, ?, ?, ?, ?);";
	
	private ComputerDaoImpl() {
		connectionUtilInstance = JDBCConnection.INSTANCE;
	}

	public Computer getComputer(int id) {

		ResultSet rs;
		PreparedStatement ps;
		Computer computer = null;
		Connection conn = connectionUtilInstance.getConnection();

		try {
			ps = conn.prepareStatement(GET_COMPUTER_QUERY);
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
		ResultSet rs;
		Statement s;
		Connection conn = connectionUtilInstance.getConnection();

		try {
			s = conn.createStatement();
			rs = s.executeQuery(GET_COMPUTERS_QUERY);
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

		PreparedStatement ps = null;
		Connection conn = connectionUtilInstance.getConnection();

		try {
			ps = conn.prepareStatement(CREATE_COMPUTER_QUERY, Statement.RETURN_GENERATED_KEYS);
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

		PreparedStatement ps = null;
		Connection conn = connectionUtilInstance.getConnection();

		try {
			ps = conn.prepareStatement(UPDATE_COMPUTER_QUERY);
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

		PreparedStatement ps = null;
		Connection conn = connectionUtilInstance.getConnection();

		try {
			ps = conn.prepareStatement(DELETE_COMPUTER_QUERY);
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
