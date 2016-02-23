package com.louisamoros.cdb.dao.exception;

public class DaoConfigurationException extends RuntimeException {

  private static final long serialVersionUID = -6712260270527836434L;

  public DaoConfigurationException(String message) {
    super(message);
  }

  public DaoConfigurationException(String message, Throwable cause) {
    super(message, cause);
  }

  public DaoConfigurationException(Throwable cause) {
    super(cause);
  }
}
