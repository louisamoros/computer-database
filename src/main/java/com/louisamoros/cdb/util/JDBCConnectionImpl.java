package com.louisamoros.cdb.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.louisamoros.cdb.dao.DAOConfigurationException;

/**
 * This class is an enum singleton which manage connections.
 * 
 * @author excilys
 *
 */
public enum JDBCConnectionImpl implements JDBCConnection {

	INSTANCE;

	private Connection conn = null;
	private static final String PROPERTIES_FILE = "dao.properties";
	private static Properties properties;
	
	static {
		
		properties = new Properties();
		InputStream propertiesFile = JDBCConnection.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE);
//		InputStream propertiesFile = JDBCConnection.class.getResourceAsStream("/src/test/resources/dao.properties");

		if (propertiesFile == null) {
			throw new DAOConfigurationException(PROPERTIES_FILE + " not found my godness.");
		}

		try {
			properties.load(propertiesFile);
		} catch (IOException e) {
			throw new DAOConfigurationException("Cannot load properties file " + PROPERTIES_FILE, e);
		}

		try {
			Class.forName(properties.getProperty("driver"));
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
	@Override
	public Connection getConnection() {

		try {
			conn = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),
					properties.getProperty("password"));
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

	@Override
	public Properties getProperties() {
		return properties;
	}
	
}
