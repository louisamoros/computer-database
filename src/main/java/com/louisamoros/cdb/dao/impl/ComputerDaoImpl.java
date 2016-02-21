package com.louisamoros.cdb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.dao.connection.JDBCConnectionImpl;
import com.louisamoros.cdb.dao.exception.DAOException;
import com.louisamoros.cdb.dao.mapper.MapperComputerDaoPs;
import com.louisamoros.cdb.dao.mapper.MapperRsComputerDao;
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
	private static final String GET_COMPUTER_QUERY = "SELECT * FROM computer LEFT JOIN company ON computer.company_id = company.id WHERE computer.id=?";
	private static final String GET_ALL_COMPUTERS_QUERY = "SELECT * FROM computer LEFT JOIN company ON computer.company_id = company.id";
	private static final String GET_COMPUTERS_QUERY = "SELECT * FROM computer LEFT JOIN company ON computer.company_id = company.id ORDER BY computer.name LIMIT ? OFFSET ?";
	private static final String UPDATE_COMPUTER_QUERY = "UPDATE computer SET name=?, introduced=?, discontinued=?, company_id=? WHERE id=?";
	private static final String DELETE_COMPUTER_QUERY = "DELETE FROM computer WHERE id=?";
	private static final String COUNT_COMPUTERS_QUERY = "SELECT COUNT(*) FROM computer";
	private static final String CREATE_COMPUTER_QUERY = "INSERT INTO computer VALUES (default, ?, ?, ?, ?)";
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
			computer = MapperRsComputerDao.toComputer(rs);
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
			computers = MapperRsComputerDao.toList(rs);
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
			computers = MapperRsComputerDao.toList(rs);
		} catch (SQLException e) {
			throw new DAOException("Fail during: " + GET_COMPUTERS_QUERY, e);
		} finally {
			ConnectionCloser.close(rs, ps, conn, GET_COMPUTERS_QUERY);
		}

		return computers;
	}

	@Override
	public int create(Computer computer) throws DAOException {

		LOGGER.debug(CREATE_COMPUTER_QUERY);
		Connection conn = jdbcConnectionImpl.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int computerId = 0;
		
		try {
			ps = conn.prepareStatement(CREATE_COMPUTER_QUERY, Statement.RETURN_GENERATED_KEYS);	
			ps = MapperComputerDaoPs.toPs(computer, ps);
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			rs.next();
			computerId = rs.getInt(1);
		} catch (SQLException e) {
			throw new DAOException("Fail during: " + CREATE_COMPUTER_QUERY, e);
		} finally {
			ConnectionCloser.close(rs, ps, conn, CREATE_COMPUTER_QUERY);
		}

		return computerId;
	}

	@Override
	public int update(Computer computer) throws DAOException {

		LOGGER.debug(UPDATE_COMPUTER_QUERY);
		Connection conn = jdbcConnectionImpl.getConnection();
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(UPDATE_COMPUTER_QUERY);
			ps = MapperComputerDaoPs.toPs(computer, ps);
			ps.setInt(5, computer.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Fail during: " + UPDATE_COMPUTER_QUERY, e);
		} finally {
			ConnectionCloser.close(null, ps, conn, UPDATE_COMPUTER_QUERY);
		}

		return computer.getId();
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
			ConnectionCloser.close(null, ps, conn, DELETE_COMPUTER_QUERY);
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
