package com.louisamoros.cdb.exception;

/**
 * Invalid computer name exception class.
 */
public class InvalidComputerNameException extends RuntimeException {

  private static final long serialVersionUID = 8718293537205394531L;

  /**
   * Thrown an invalid computer name runtime exception.
   *
   * @param message
   */
  public InvalidComputerNameException(final String message) {
    super(message);
  }

}
