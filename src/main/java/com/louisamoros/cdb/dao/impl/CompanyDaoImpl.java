package com.louisamoros.cdb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.louisamoros.cdb.dao.CompanyDao;
import com.louisamoros.cdb.dao.connection.JDBCConnectionImpl;
import com.louisamoros.cdb.dao.exception.DAOException;
import com.louisamoros.cdb.dao.mapper.MapperCompany;
import com.louisamoros.cdb.model.Company;

/**
 * <CompanyDaoImpl> implements methods of <CompanyDao> interface.
 * 
 * @author louis
 *
 */
public enum CompanyDaoImpl implements CompanyDao {

	INSTANCE;

	private JDBCConnectionImpl jdbcConnection;
	private static final String GET_COMPANIES_QUERY = "SELECT * FROM company;";
	private static Logger LOGGER = LoggerFactory.getLogger(CompanyDao.class);

	private CompanyDaoImpl() {
		jdbcConnection = JDBCConnectionImpl.INSTANCE;
	}

	public List<Company> getAll() throws DAOException {

		LOGGER.debug(GET_COMPANIES_QUERY);
		List<Company> companies = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = jdbcConnection.getConnection();

		try {
			ps = conn.prepareStatement(GET_COMPANIES_QUERY);
			rs = ps.executeQuery();
			companies = MapperCompany.toList(rs);
		} catch (SQLException e) {
			throw new DAOException("Fail during: " + GET_COMPANIES_QUERY, e);
		} finally {
			ConnectionCloser.close(rs, ps, conn, GET_COMPANIES_QUERY);
		}

		return companies;
	}

}
