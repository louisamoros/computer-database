package com.louisamoros.cdb.exception;

public class IntegrityException extends RuntimeException {

  private static final long serialVersionUID = -4752871327020390873L;

  public IntegrityException(String message) {
    super(message);
  }

}
