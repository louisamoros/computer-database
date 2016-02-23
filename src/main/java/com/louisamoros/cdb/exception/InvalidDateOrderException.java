package com.louisamoros.cdb.exception;

/**
 * The Class InvalidDateOrderException.
 */
public class InvalidDateOrderException extends RuntimeException {

  private static final long serialVersionUID = 9093049111645783104L;

  /**
   * Instantiates a new invalid date order exception.
   *
   * @param message the message
   */
  public InvalidDateOrderException(String message) {
    super(message);
  }

  /**
   * Instantiates a new invalid date order exception.
   *
   * @param message the message
   * @param cause the cause
   */
  public InvalidDateOrderException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Instantiates a new invalid date order exception.
   *
   * @param cause the cause
   */
  public InvalidDateOrderException(Throwable cause) {
    super(cause);
  }

}
