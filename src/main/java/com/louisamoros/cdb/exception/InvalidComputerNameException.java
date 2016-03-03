package com.louisamoros.cdb.exception;

public class InvalidComputerNameException extends RuntimeException {

  private static final long serialVersionUID = 8718293537205394531L;

  public InvalidComputerNameException(String message) {
    super(message);
  }

}
