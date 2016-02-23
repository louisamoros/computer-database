package com.louisamoros.cdb.dao.connection;

import java.sql.Connection;

/**
 * The Interface JDBCConnection.
 */
public interface ConnectionManager {

  Connection getConnection();

}
