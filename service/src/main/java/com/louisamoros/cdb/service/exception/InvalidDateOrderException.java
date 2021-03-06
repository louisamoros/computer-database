package com.louisamoros.cdb.service.exception;

/**
 * Invalid date order exception class.
 */
public class InvalidDateOrderException extends RuntimeException {

  private static final long serialVersionUID = 9093049111645783104L;

  /**
   * Thrown an invalid date order runtime exception.
   *
   * @param message the message to display
   */
  public InvalidDateOrderException(final String message) {
    super(message);
  }

}
