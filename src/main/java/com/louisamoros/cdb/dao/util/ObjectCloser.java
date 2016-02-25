package com.louisamoros.cdb.dao.util;

import com.louisamoros.cdb.dao.exception.DaoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The Class ObjectCloser.
 */
public class ObjectCloser {

  /**
   * Close.
   *
   * @param rs the rs
   * @param ps the ps
   * @param message the message
   */
  public static void close(ResultSet rs, PreparedStatement ps, String message) {
    try {
      if (rs != null) {
        rs.close();
      }
      if (ps != null) {
        ps.close();
      }
    } catch (SQLException e) {
      throw new DaoException("Fail when closing after: " + message, e);
    }
  }

}
