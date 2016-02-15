package com.louisamoros.cdb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.dao.DAOException;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.util.JDBCConnectionImpl;
import com.louisamoros.cdb.util.MapperResultSet;

/**
 * ComputerDaoImpl implements methods of ComputerDao interface.
 * 
 * @author excilys
 *
 */
public enum ComputerDaoImpl implements ComputerDao {

	INSTANCE;

	private JDBCConnectionImpl jdbcConnectionImpl;
	private static final String GET_COMPUTER_QUERY = "SELECT * FROM computer LEFT JOIN company ON computer.company_id = company.id WHERE computer.id=?;";
	private static final String GET_ALL_COMPUTERS_QUERY = "SELECT * FROM computer LEFT JOIN company ON computer.company_id = company.id;";
	private static final String GET_COMPUTERS_QUERY = "SELECT * FROM computer LEFT JOIN company ON computer.company_id = company.id LIMIT %d OFFSET %d;";
	private static final String UPDATE_COMPUTER_QUERY = "UPDATE computer SET name=?, introduced=?, discontinued=?, company_id=? WHERE id=?";
	private static final String DELETE_COMPUTER_QUERY = "DELETE FROM computer WHERE id=?";
	private static final String COUNT_COMPUTERS_QUERY = "SELECT COUNT(*) FROM computer;";
	private static final String CREATE_COMPUTER_QUERY = "INSERT INTO computer VALUES (default, ?, ?, ?, ?);";
	private static Logger LOGGER = LoggerFactory.getLogger(ComputerDao.class);
	
	private ComputerDaoImpl() {
		jdbcConnectionImpl = JDBCConnectionImpl.INSTANCE;
	}

	@Override
	public Computer getComputer(int id) throws DAOException {

		LOGGER.debug(GET_COMPUTER_QUERY);
		ResultSet rs;
		PreparedStatement ps;
		Computer computer = null;
		Connection conn = jdbcConnectionImpl.getConnection();

		try {
			ps = conn.prepareStatement(GET_COMPUTER_QUERY);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			computer = MapperResultSet.toComputerModel(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Fail during: " + GET_COMPUTER_QUERY);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("Fail when closing after: " + GET_COMPUTER_QUERY);
			}
		}

		return computer;
	}

	@Override
	public List<Computer> getAllComputers() throws DAOException {

		LOGGER.debug(GET_ALL_COMPUTERS_QUERY);
		List<Computer> computers = null;
		ResultSet rs;
		Statement s;
		Connection conn = jdbcConnectionImpl.getConnection();

		try {
			s = conn.createStatement();
			rs = s.executeQuery(GET_ALL_COMPUTERS_QUERY);
			computers = MapperResultSet.toComputerArrayList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Fail during: " + GET_ALL_COMPUTERS_QUERY);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("Fail when closing after: " + GET_ALL_COMPUTERS_QUERY);
			}
		}

		return computers;
	}
	
	@Override
	public List<Computer> getComputers(int offset, int steps) throws DAOException {

		LOGGER.debug(GET_COMPUTER_QUERY);
		List<Computer> computers = null;
		ResultSet rs;
		Statement s;
		Connection conn = jdbcConnectionImpl.getConnection();

		try {
			s = conn.createStatement();
			String query = String.format(GET_COMPUTERS_QUERY, steps, offset);
			rs = s.executeQuery(query);
			computers = MapperResultSet.toComputerArrayList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Fail during: " + GET_COMPUTER_QUERY);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("Fail when closing after: " + GET_COMPUTER_QUERY);
			}
		}

		return computers;
	}

	@Override
	public Computer createComputer(Computer computer) throws DAOException {

		LOGGER.debug(CREATE_COMPUTER_QUERY);
		PreparedStatement ps = null;
		Connection conn = jdbcConnectionImpl.getConnection();
		Timestamp dateIntroduced = null;
		Timestamp dateDiscontinued = null;
		
		if (computer.getIntroducedDate() != null) {
			dateIntroduced = Timestamp.valueOf(computer.getIntroducedDate().atStartOfDay());
		}
		if (computer.getDiscontinuedDate() != null) {
			dateDiscontinued = Timestamp.valueOf(computer.getDiscontinuedDate().atStartOfDay());
		}
		
		try {
			ps = conn.prepareStatement(CREATE_COMPUTER_QUERY, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, computer.getName());
			ps.setTimestamp(2, dateIntroduced);
			ps.setTimestamp(3, dateDiscontinued);
			ps.setInt(4, computer.getCompany().getCompanyId());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			computer.setComputerId(rs.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Fail during: " + CREATE_COMPUTER_QUERY);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("Fail when closing after: " + CREATE_COMPUTER_QUERY);
			}
		}

		return computer;
	}

	@Override
	public Computer updateComputer(Computer computer) throws DAOException {

		LOGGER.debug(UPDATE_COMPUTER_QUERY);
		PreparedStatement ps = null;
		Connection conn = jdbcConnectionImpl.getConnection();
		Timestamp dateIntroduced = null;
		Timestamp dateDiscontinued = null;
		
		if (computer.getIntroducedDate() != null) {
			dateIntroduced = Timestamp.valueOf(computer.getIntroducedDate().atStartOfDay());
		}
		if (computer.getDiscontinuedDate() != null) {
			dateDiscontinued = Timestamp.valueOf(computer.getDiscontinuedDate().atStartOfDay());
		}
		
		try {
			ps = conn.prepareStatement(UPDATE_COMPUTER_QUERY);
			ps.setString(1, computer.getName());
			ps.setTimestamp(2, dateIntroduced);
			ps.setTimestamp(3, dateDiscontinued);
			ps.setInt(4, computer.getCompany().getCompanyId());
			ps.setInt(5, computer.getComputerId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Fail during: " + UPDATE_COMPUTER_QUERY);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("Fail when closing after: " + UPDATE_COMPUTER_QUERY);
			}
		}

		return computer;
	}

	@Override
	public void deleteComputer(int id) throws DAOException {

		LOGGER.debug(DELETE_COMPUTER_QUERY);
		PreparedStatement ps = null;
		Connection conn = jdbcConnectionImpl.getConnection();

		try {
			ps = conn.prepareStatement(DELETE_COMPUTER_QUERY);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Fail during: " + DELETE_COMPUTER_QUERY);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("Fail when closing after: " + DELETE_COMPUTER_QUERY);
			}
		}

	}

	@Override
	public int getNumberOfComputers() throws DAOException {
		LOGGER.debug(COUNT_COMPUTERS_QUERY);
		ResultSet rs;
		PreparedStatement ps;
		int numberOfComputers = 0;
		Connection conn = jdbcConnectionImpl.getConnection();

		try {
			ps = conn.prepareStatement(COUNT_COMPUTERS_QUERY);
			rs = ps.executeQuery();
			rs.next();
		    numberOfComputers = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Fail during: " + COUNT_COMPUTERS_QUERY);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("Fail when closing after: " + COUNT_COMPUTERS_QUERY);
			}
		}

		return numberOfComputers;
	}
	
}
