package com.louisamoros.computerDatabase.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Dao factory singleton
 * @author excilys
 *
 */
public class DaoFactory {

	private static Connection conn = null;
	private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/";
	private static final String DB_NAME = "computer-database-db?zeroDateTimeBehavior=convertToNull";
	private static final String USER_NAME = "root";
	private static final String USER_PWD = "root";
	
	private static DaoFactory instance = new DaoFactory();

	private DaoFactory() {
	}
	
	public static DaoFactory getInstance() {
		return instance;
	}
	
	static {
		try {
			Class.forName(MYSQL_DRIVER); 
		} catch (ClassNotFoundException e) {
			System.out.println("Error using mysql driver...");
			e.printStackTrace();
		}
	}
	
	/**
	 * Create static connection to the database using attributes.
	 * @return connection
	 */
	public static Connection connect() {

		try {
			StringBuilder dbNameUrl = new StringBuilder(URL);
			dbNameUrl.append(DB_NAME);
			conn = DriverManager.getConnection(dbNameUrl.toString(), USER_NAME, USER_PWD);
		} catch (SQLException e) {
			System.out.println("Error during connection...rollback and close");
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * Close static connection to the database.
	 */
	public static void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error closing connection...");
			e.printStackTrace();
		}
	}

	/**
	 * Create a new computer dao object.
	 * @return created the computer dao implementation
	 */
	public static ComputerDaoImpl getComputerDao() {
		return new ComputerDaoImpl();
	}
	/**
	 * Create a new company dao object.
	 * @return created the company dao implementation
	 */
	public static CompanyDaoImpl getCompanyDao() {
		return new CompanyDaoImpl();
	}
}
