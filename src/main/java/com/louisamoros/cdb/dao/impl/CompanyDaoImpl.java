package com.louisamoros.cdb.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.louisamoros.cdb.dao.CompanyDao;
import com.louisamoros.cdb.dao.DAOException;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.util.JDBCConnectionImpl;
import com.louisamoros.cdb.util.MapperResultSet;

/**
 * CompanyDaoImpl implements methods of CompanyDao interface.
 * @author excilys
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
	
	public List<Company> getCompanies() throws DAOException {

		LOGGER.debug(GET_COMPANIES_QUERY);
		List<Company> companies = null;
		ResultSet rs;
		Statement s;
		Connection conn = jdbcConnection.getConnection();

		try {
			s = conn.createStatement();
			rs = s.executeQuery(GET_COMPANIES_QUERY);
			companies = MapperResultSet.toCompanyArrayList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Fail during: " + GET_COMPANIES_QUERY);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("Fail when closing after: " + GET_COMPANIES_QUERY);
			}
		}

		return companies;

	}

}
