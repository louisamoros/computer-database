package com.louisamoros.cdb.dao.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.louisamoros.cdb.dao.exception.DAOConfigurationException;
import com.louisamoros.cdb.dao.exception.DAOConnectionException;

/**
 * This class is an enum singleton which implements <JDBCConnection> interface
 * and manages connections.
 * 
 * @author louis
 *
 */
public enum JDBCConnectionImpl implements JDBCConnection {

	INSTANCE;

	private Connection conn = null;
	private static final String PROPERTIES_FILE = "dao.properties";
	private final String url;
	private final String driver;
	private final String username;
	private final String password;

	JDBCConnectionImpl() {

		Properties properties = new Properties();
		InputStream propertiesFile = JDBCConnection.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE);

		if (propertiesFile == null) {
			throw new DAOConfigurationException(PROPERTIES_FILE + " not found my godness.");
		}

		try {
			properties.load(propertiesFile);
		} catch (IOException e) {
			throw new DAOConfigurationException("Cannot load properties file " + PROPERTIES_FILE, e);
		}
		
		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		username = properties.getProperty("username");
		password = properties.getProperty("password");
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new DAOConfigurationException("Driver not found." + e);
		}

	}

	@Override
	public Connection getConnection() {

		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e1) {
				throw new DAOConnectionException("Rollback and close connection exception." + e);
			}
			throw new DAOConnectionException("Cannot get connection using url:" + url, e);
		}

		return conn;

	}

}
