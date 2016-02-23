package com.louisamoros.cdb.dao.connection;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;
import com.louisamoros.cdb.dao.exception.DaoConfigurationException;
import com.louisamoros.cdb.dao.exception.DaoConnectionException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * The Enum JDBCConnectionImpl.
 */
public enum ConnectionManagerImpl implements ConnectionManager {

  INSTANCE;

  private static final String PROPERTIES_FILE = "dao.properties";
  private static final String URL;
  private static final String DRIVER;
  private static final String USERNAME;
  private static final String PASSWORD;
  private static BoneCP connPool;
  private Connection conn;

  static {

    try {

      Properties properties = new Properties();
      InputStream propertiesFile = ConnectionManager.class.getClassLoader()
          .getResourceAsStream(PROPERTIES_FILE);

      properties.load(propertiesFile);
      DRIVER = properties.getProperty("driver");
      URL = properties.getProperty("url");
      USERNAME = properties.getProperty("username");
      PASSWORD = properties.getProperty("password");
      Class.forName(DRIVER);

      BoneCPConfig boneCpConfig = new BoneCPConfig();
      boneCpConfig.setJdbcUrl(URL);
      boneCpConfig.setUsername(USERNAME);
      boneCpConfig.setPassword(PASSWORD);
      boneCpConfig.setPartitionCount(1);
      boneCpConfig.setMaxConnectionsPerPartition(5);
      connPool = new BoneCP(boneCpConfig);

    } catch (IOException e) {
      throw new DaoConfigurationException("Cannot load properties file " + PROPERTIES_FILE, e);
    } catch (ClassNotFoundException e) {
      throw new DaoConfigurationException("Driver not found." + e);
    } catch (SQLException e) {
      throw new DaoConfigurationException("Connection pool failed." + e);
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
        throw new DaoConnectionException("Rollback and close connection exception." + e);
      }
      throw new DaoConnectionException("Cannot get connection using url:" + URL, e);
    }

    return conn;

  }

}
