package com.louisamoros.cdb.service.util;

import java.sql.Connection;

public interface TransactionManager {

  Connection getConnection();

  void closeConnection();

  void startTransaction();

  void commitTransaction();

  void rollbackTransaction();

  void endTransaction();

}
