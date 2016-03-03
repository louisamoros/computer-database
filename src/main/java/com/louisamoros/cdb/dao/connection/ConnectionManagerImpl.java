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

  private static Connection conn;

  @Autowired
  private DataSource dataSource;

  @Override
  public Connection getConnection() {

    try {
      conn = dataSource.getConnection();
    } catch (SQLException e) {
      try {
        conn.rollback();
        conn.close();
      } catch (SQLException e1) {
        throw new DaoConnectionException("Rollback and close connection exception.", e);
      }
      throw new DaoConnectionException("Cannot get connection using url.", e);
    }

    return conn;

  }

}
