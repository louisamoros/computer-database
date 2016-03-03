package com.louisamoros.cdb.dao.connection;

import com.louisamoros.cdb.dao.exception.DaoConnectionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * The Enum JDBCConnectionImpl.
 */
@Component
public class ConnectionManagerImpl implements ConnectionManager {

  // private static final String PROPERTIES_FILE = "dao.properties";
  // private static final String URL;
  // private static final String DRIVER;
  // private static final String USERNAME;
  // private static final String PASSWORD;
  // private static BoneCP connPool;
  private Connection conn;

  @Autowired
  private DataSource dataSource;

  static {

    // try {
    //
    // Properties properties = new Properties();
    // InputStream propertiesFile = ConnectionManager.class.getClassLoader()
    // .getResourceAsStream(PROPERTIES_FILE);
    //
    // properties.load(propertiesFile);
    // DRIVER = properties.getProperty("driver");
    // URL = properties.getProperty("url");
    // USERNAME = properties.getProperty("username");
    // PASSWORD = properties.getProperty("password");
    // Class.forName(DRIVER);
    //
    // BoneCPConfig boneCpConfig = new BoneCPConfig();
    // boneCpConfig.setJdbcUrl(URL);
    // boneCpConfig.setUsername(USERNAME);
    // boneCpConfig.setPassword(PASSWORD);
    // boneCpConfig.setPartitionCount(1);
    // boneCpConfig.setMaxConnectionsPerPartition(5);
    // connPool = new BoneCP(boneCpConfig);
    //
    // } catch (IOException e) {
    // throw new DaoConfigurationException("Cannot load properties file " + PROPERTIES_FILE, e);
    // } catch (ClassNotFoundException e) {
    // throw new DaoConfigurationException("Driver not found." + e);
    // } catch (SQLException e) {
    // throw new DaoConfigurationException("Connection pool failed." + e);
    // }

  }

  @Override
  public Connection getConnection() {

    try {
      conn = dataSource.getConnection();
    } catch (SQLException e) {
      try {
        conn.rollback();
        conn.close();
      } catch (SQLException e1) {
        throw new DaoConnectionException("Rollback and close connection exception." + e);
      }
      throw new DaoConnectionException("Cannot get connection using url.", e);
    }

    return conn;

  }

}
