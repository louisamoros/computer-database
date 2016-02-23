package com.louisamoros.cdb.exception;

public class IntegrityException extends RuntimeException {

  private static final long serialVersionUID = -4752871327020390873L;

  public IntegrityException(String message) {
    super(message);
  }

  public IntegrityException(String message, Throwable cause) {
    super(message, cause);
  }

  public IntegrityException(Throwable cause) {
    super(cause);
  }

}
