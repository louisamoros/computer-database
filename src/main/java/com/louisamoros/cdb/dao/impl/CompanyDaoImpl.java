package com.louisamoros.cdb.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.louisamoros.cdb.dao.CompanyDao;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.util.JDBCConnection;
import com.louisamoros.cdb.util.Mapper;

/**
 * CompanyDaoImpl implements methods of CompanyDao interface.
 * @author excilys
 *
 */
public enum CompanyDaoImpl implements CompanyDao {
	
	INSTANCE;

	private JDBCConnection connectionUtilInstance;
	
	private CompanyDaoImpl() {
		connectionUtilInstance = JDBCConnection.INSTANCE;
	}
		
	public List<Company> getCompanies() {

		List<Company> companies = null;
		String query = "SELECT * FROM company;";
		ResultSet rs;
		Statement s;
		Connection conn = connectionUtilInstance.getConnection();

		try {
			s = conn.createStatement();
			rs = s.executeQuery(query);
			return Mapper.toCompanyArrayList(rs);
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

		return companies;

	}

}
