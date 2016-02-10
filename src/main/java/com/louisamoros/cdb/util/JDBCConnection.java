package com.louisamoros.cdb.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.louisamoros.cdb.exception.DAOConfigurationException;

/**
 * This class is an enum singleton which manage connections.
 * 
 * @author excilys
 *
 */
public enum JDBCConnection {

	INSTANCE;

	private Connection conn = null;
	private static final String PROPERTIES_FILE = "/com/louisamoros/cdb/dao/dao.properties";
	private static String url;
	private static String driver;
	private static String username;
	private static String password;
	
	private JDBCConnection() {
	}

	static {
		Properties properties = new Properties();
		InputStream propertiesFile = JDBCConnection.class.getResourceAsStream(PROPERTIES_FILE);

		if (propertiesFile == null) {
			throw new DAOConfigurationException(PROPERTIES_FILE + " not found my godness.");
		}

		try {
			properties.load(propertiesFile);
			url = properties.getProperty("url");
			driver = properties.getProperty("driver");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
		} catch (IOException e) {
			throw new DAOConfigurationException("Cannot load properties file " + PROPERTIES_FILE, e);
		}

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Error using mysql driver...");
			e.printStackTrace();
		}
	}

	/**
	 * This method initialize a new connection and give it to the class where it
	 * has been called
	 * 
	 * @return connection
	 */
	public Connection getConnection() {

		try {
			conn = DriverManager.getConnection(url, username, password);
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
	 * This method close a given connection.
	 * @param connection
	 */
	public void closeConnection(Connection conn) {
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
