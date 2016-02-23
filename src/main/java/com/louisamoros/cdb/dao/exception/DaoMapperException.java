package com.louisamoros.cdb.dao.exception;

public class DaoMapperException extends RuntimeException {

  private static final long serialVersionUID = -6373559448045138854L;

  public DaoMapperException(String message) {
    super(message);
  }

  public DaoMapperException(String message, Throwable cause) {
    super(message, cause);
  }

  public DaoMapperException(Throwable cause) {
    super(cause);
  }
}
