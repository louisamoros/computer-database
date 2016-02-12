package com.louisamoros.cdb.util;

import java.sql.Connection;
import java.util.Properties;

public interface JDBCConnection {

	public Connection getConnection();
	public Properties getProperties();
	
}
