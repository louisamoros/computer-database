package com.louisamoros.cdb.service.util;

import com.louisamoros.cdb.dao.connection.ConnectionManager;
import com.louisamoros.cdb.dao.connection.ConnectionManagerImpl;
import com.louisamoros.cdb.service.exception.TransactionManagerException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public enum TransactionManagerImpl implements TransactionManager {

  INSTANCE;

  public static final Logger LOGGER = LoggerFactory.getLogger(TransactionManagerImpl.class);
  public final ThreadLocal<Connection> context = new ThreadLocal<Connection>();
  private static ConnectionManager connectionManager;

  static {
    connectionManager = ConnectionManagerImpl.INSTANCE;
  }

  @Override
  public Connection getConnection() {
    Connection conn = context.get();
    if (conn == null) {
      conn = connectionManager.getConnection();
      context.set(conn);
    }
    return conn;
  }

  @Override
  public void closeConnection() {
    Connection conn = context.get();
    try {
      if (conn != null && conn.getAutoCommit()) {
        conn.close();
        context.remove();
      }
    } catch (SQLException e) {
      throw new TransactionManagerException("Closing connection failed", e);
    }

  }

  @Override
  public void startTransaction() {
    try {
      getConnection().setAutoCommit(false);
    } catch (SQLException e) {
      throw new TransactionManagerException("Starting connection failed." + e);
    }
  }

  @Override
  public void commitTransaction() {
    try {
      context.get().commit();
      LOGGER.info("successfully commited");
    } catch (SQLException e) {
      LOGGER.error("failed to commit transaction");
      throw new TransactionManagerException("Commiting transaction failed." + e);
    }
  }

  @Override
  public void rollbackTransaction() {
    try {
      context.get().rollback();
    } catch (SQLException e) {
      throw new TransactionManagerException("Rollback on transaction failed." + e);
    }
  }

  @Override
  public void endTransaction() {
    try {
      context.get().close();
    } catch (SQLException e) {
      throw new TransactionManagerException("Ending transaction failed." + e);
    }
    context.remove();
  }

}
