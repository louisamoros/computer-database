package com.louisamoros.cdb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.louisamoros.cdb.dao.exception.DAOException;

/**
 * <ConnectionCloser> class is used to close (via static methods) a <Connection>, <PreparedStatement> nor <ResultSet>.
 * @author louis
 *
 */
public class ConnectionCloser {

	/**
	 * Close in a try catch all the given parameters and throw new <DaoException> with given message.
	 * @param <ResultSet>
	 * @param <PreparedStatement>
	 * @param <Connection>
	 * @param message
	 */
	public static void close(ResultSet rs, PreparedStatement ps, Connection conn, String message) {
		try {
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			throw new DAOException("Fail when closing after: " + message, e);
		}
	}

	/**
	 * Close in a try catch all the given parameters and throw new <DaoException> with given message.
	 * @param <PreparedStatement>
	 * @param <Connection>
	 * @param message
	 */
	public static void close(PreparedStatement ps, Connection conn, String message) {
		try {
			ps.close();
			conn.close();
		} catch (SQLException e) {
			throw new DAOException("Fail when closing after: " + message, e);
		}
	}

	
}
