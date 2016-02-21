package com.louisamoros.cdb.dao.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;
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

	private Connection conn;
	private static BoneCP connPool;
	private static final String PROPERTIES_FILE = "dao.properties";
	private final static String url;
	private final static String driver;
	private final static String username;
	private final static String password;

	static {

		try {

			Properties properties = new Properties();
			InputStream propertiesFile = JDBCConnection.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE);

			properties.load(propertiesFile);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
            Class.forName(driver);

			BoneCPConfig boneCPConfig = new BoneCPConfig();
			boneCPConfig.setJdbcUrl(url);
			boneCPConfig.setUsername(username);
			boneCPConfig.setPassword(password);
			boneCPConfig.setPartitionCount(1);
			boneCPConfig.setMaxConnectionsPerPartition(5);
			connPool = new BoneCP(boneCPConfig);

        } catch (IOException e) {
			throw new DAOConfigurationException("Cannot load properties file " + PROPERTIES_FILE, e);
		} catch (ClassNotFoundException e) {
			throw new DAOConfigurationException("Driver not found." + e);
		} catch (SQLException e) {
			throw new DAOConfigurationException("Connection pool failed." + e);
		}

	}

	@Override
	public Connection getConnection() {

		try {
			conn = connPool.getConnection();
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
