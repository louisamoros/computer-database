package com.louisamoros.cdb.dao.impl;

import com.louisamoros.cdb.dao.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The Class ConnectionCloser.
 */
public class ConnectionCloser {

  /**
   * Close.
   *
   * @param rs the rs
   * @param ps the ps
   * @param conn the conn
   * @param message the message
   */
  public static void close(ResultSet rs, PreparedStatement ps, Connection conn, String message) {
    try {
      if (rs != null) {
        rs.close();
      }
      if (ps != null) {
        ps.close();
      }
      if (conn != null) {
        conn.close();
      }
    } catch (SQLException e) {
      throw new DaoException("Fail when closing after: " + message, e);
    }
  }

}
