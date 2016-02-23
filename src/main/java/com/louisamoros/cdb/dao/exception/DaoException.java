package com.louisamoros.cdb.dao.exception;

public class DaoException extends RuntimeException {

  private static final long serialVersionUID = -8368332668354835764L;

  public DaoException(String message) {
    super(message);
  }

  public DaoException(String message, Throwable cause) {
    super(message, cause);
  }

  public DaoException(Throwable cause) {
    super(cause);
  }

}