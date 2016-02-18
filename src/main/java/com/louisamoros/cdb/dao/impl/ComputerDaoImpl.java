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
import com.louisamoros.cdb.dao.connection.JDBCConnectionImpl;
import com.louisamoros.cdb.dao.exception.DAOException;
import com.louisamoros.cdb.dao.mapper.MapperComputer;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.model.Computer;

/**
 * <ComputerDaoImpl> implements methods of <ComputerDao> interface.
 * 
 * @author louis
 *
 */
public enum ComputerDaoImpl implements ComputerDao {

	INSTANCE;

	private JDBCConnectionImpl jdbcConnectionImpl;
	private static final String GET_COMPUTER_QUERY = "SELECT * FROM computer LEFT JOIN company ON computer.company_id = company.id WHERE computer.id=?;";
	private static final String GET_ALL_COMPUTERS_QUERY = "SELECT * FROM computer LEFT JOIN company ON computer.company_id = company.id;";
	private static final String GET_COMPUTERS_QUERY = "SELECT * FROM computer LEFT JOIN company ON computer.company_id = company.id ORDER BY computer.name LIMIT ? OFFSET ?;";
	private static final String UPDATE_COMPUTER_QUERY = "UPDATE computer SET name=?, introduced=?, discontinued=?, company_id=? WHERE id=?";
	private static final String DELETE_COMPUTER_QUERY = "DELETE FROM computer WHERE id=?";
	private static final String COUNT_COMPUTERS_QUERY = "SELECT COUNT(*) FROM computer;";
	private static final String CREATE_COMPUTER_QUERY = "INSERT INTO computer VALUES (default, ?, ?, ?, ?);";
	private static Logger LOGGER = LoggerFactory.getLogger(ComputerDao.class);

	private ComputerDaoImpl() {
		jdbcConnectionImpl = JDBCConnectionImpl.INSTANCE;
	}

	@Override
	public Computer get(int id) throws DAOException {

		LOGGER.debug(GET_COMPUTER_QUERY);
		ResultSet rs = null;
		PreparedStatement ps = null;
		Computer computer = null;
		Connection conn = jdbcConnectionImpl.getConnection();

		try {
			ps = conn.prepareStatement(GET_COMPUTER_QUERY);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			computer = MapperComputer.toComputer(rs);
		} catch (SQLException e) {
			throw new DAOException("Fail during: " + GET_COMPUTER_QUERY, e);
		} finally {
			ConnectionCloser.close(rs, ps, conn, GET_COMPUTER_QUERY);
		}

		return computer;
	}

	@Override
	public List<Computer> getAll() throws DAOException {

		LOGGER.debug(GET_ALL_COMPUTERS_QUERY);
		List<Computer> computers = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = jdbcConnectionImpl.getConnection();

		try {
			ps = conn.prepareStatement(GET_ALL_COMPUTERS_QUERY);
			rs = ps.executeQuery();
			computers = MapperComputer.toList(rs);
		} catch (SQLException e) {
			throw new DAOException("Fail during: " + GET_ALL_COMPUTERS_QUERY, e);
		} finally {
			ConnectionCloser.close(rs, ps, conn, GET_ALL_COMPUTERS_QUERY);
		}

		return computers;
	}

	@Override
	public List<Computer> get(int offset, int limit) throws DAOException {

		LOGGER.debug(GET_COMPUTERS_QUERY);
		List<Computer> computers = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = jdbcConnectionImpl.getConnection();

		try {
			ps = conn.prepareStatement(GET_COMPUTERS_QUERY);
			ps.setInt(1, limit);
			ps.setInt(2, offset);
			rs = ps.executeQuery();
			computers = MapperComputer.toList(rs);
		} catch (SQLException e) {
			throw new DAOException("Fail during: " + GET_COMPUTERS_QUERY, e);
		} finally {
			ConnectionCloser.close(rs, ps, conn, GET_COMPUTERS_QUERY);
		}

		return computers;
	}

	@Override
	public Computer create(Computer computer) throws DAOException {

		LOGGER.debug(CREATE_COMPUTER_QUERY);
		Connection conn = jdbcConnectionImpl.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Timestamp dateIntroduced = null;
		Timestamp dateDiscontinued = null;

		if (computer.getIntroduced() != null) {
			dateIntroduced = Timestamp.valueOf(computer.getIntroduced().atStartOfDay());
		}
		if (computer.getDiscontinued() != null) {
			dateDiscontinued = Timestamp.valueOf(computer.getDiscontinued().atStartOfDay());
		}

		try {
			ps = conn.prepareStatement(CREATE_COMPUTER_QUERY, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, computer.getName());
			ps.setTimestamp(2, dateIntroduced);
			ps.setTimestamp(3, dateDiscontinued);
			ps.setInt(4, computer.getCompany().getId());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			rs.next();
			computer = new Computer.Builder(computer.getName())
					.company(new Company.Builder().id(computer.getCompany().getId()).build())
					.introduced(computer.getIntroduced())
					.discontinued(computer.getDiscontinued())
					.id(rs.getInt(1))
					.build();
		} catch (SQLException e) {
			throw new DAOException("Fail during: " + CREATE_COMPUTER_QUERY, e);
		} finally {
			ConnectionCloser.close(rs, ps, conn, CREATE_COMPUTER_QUERY);
		}

		return computer;
	}

	@Override
	public Computer update(Computer computer) throws DAOException {

		LOGGER.debug(UPDATE_COMPUTER_QUERY);
		Connection conn = jdbcConnectionImpl.getConnection();
		PreparedStatement ps = null;
		
		Timestamp dateIntroduced = null;
		Timestamp dateDiscontinued = null;

		if (computer.getIntroduced() != null) {
			dateIntroduced = Timestamp.valueOf(computer.getIntroduced().atStartOfDay());
		}
		if (computer.getDiscontinued() != null) {
			dateDiscontinued = Timestamp.valueOf(computer.getDiscontinued().atStartOfDay());
		}

		try {
			ps = conn.prepareStatement(UPDATE_COMPUTER_QUERY);
			ps.setString(1, computer.getName());
			ps.setTimestamp(2, dateIntroduced);
			ps.setTimestamp(3, dateDiscontinued);
			ps.setInt(4, computer.getCompany().getId());
			ps.setInt(5, computer.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Fail during: " + UPDATE_COMPUTER_QUERY, e);
		} finally {
			ConnectionCloser.close(ps, conn, UPDATE_COMPUTER_QUERY);
		}

		return computer;
	}

	@Override
	public void delete(int id) throws DAOException {

		LOGGER.debug(DELETE_COMPUTER_QUERY);
		Connection conn = jdbcConnectionImpl.getConnection();
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(DELETE_COMPUTER_QUERY);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Fail during: " + DELETE_COMPUTER_QUERY, e);
		} finally {
			ConnectionCloser.close(ps, conn, DELETE_COMPUTER_QUERY);
		}

	}

	@Override
	public int count() throws DAOException {
		
		LOGGER.debug(COUNT_COMPUTERS_QUERY);
		Connection conn = jdbcConnectionImpl.getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		int count = 0;

		try {
			ps = conn.prepareStatement(COUNT_COMPUTERS_QUERY);
			rs = ps.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			throw new DAOException("Fail during: " + COUNT_COMPUTERS_QUERY, e);
		} finally {
			ConnectionCloser.close(rs, ps, conn, COUNT_COMPUTERS_QUERY);
		}

		return count;
	}

}
