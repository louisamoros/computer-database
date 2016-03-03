package com.louisamoros.cdb.dao.exception;

public class DaoConnectionException extends RuntimeException {

  private static final long serialVersionUID = 7081259968426831842L;

  public DaoConnectionException(String message, Throwable cause) {
    super(message, cause);
  }

}