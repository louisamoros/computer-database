package com.louisamoros.cdb.exception;

public class InvalidDateOrderException extends RuntimeException {

  private static final long serialVersionUID = 9093049111645783104L;

  public InvalidDateOrderException(String message) {
    super(message);
  }

  public InvalidDateOrderException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidDateOrderException(Throwable cause) {
    super(cause);
  }

}
