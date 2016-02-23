package com.louisamoros.cdb.exception;

/**
 * The Class InvalidComputerNameException.
 */
public class InvalidComputerNameException extends RuntimeException {

  private static final long serialVersionUID = 8718293537205394531L;

  /**
   * Instantiates a new invalid computer name exception.
   *
   * @param message the message
   */
  public InvalidComputerNameException(String message) {
    super(message);
  }

  /**
   * Instantiates a new invalid computer name exception.
   *
   * @param message the message
   * @param cause the cause
   */
  public InvalidComputerNameException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Instantiates a new invalid computer name exception.
   *
   * @param cause the cause
   */
  public InvalidComputerNameException(Throwable cause) {
    super(cause);
  }

}
