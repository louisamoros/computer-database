package com.louisamoros.cdb.dao.connection;

import java.sql.Connection;

/**
 * <JDBCConnection> interface implemented by singleton enum
 * <JDBCConnectionImpl> handle connection to database.
 * 
 * @author louis
 *
 */
public interface JDBCConnection {
	
	/**
	 * This method initialize a new connection and return it.
	 * 
	 * @return <Connection>
	 */
	Connection getConnection();

}
