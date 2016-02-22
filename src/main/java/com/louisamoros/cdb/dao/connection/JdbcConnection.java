package com.louisamoros.cdb.dao.connection;

import java.sql.Connection;

/**
 * The Interface JDBCConnection.
 */
public interface JdbcConnection {

  /**
   * Gets the connection.
   *
   * @return the connection
   */
  Connection getConnection();

}
