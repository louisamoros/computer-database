package com.louisamoros.cdb.exception;

/**
 * The Class IntegrityException.
 */
public class IntegrityException extends RuntimeException {

  private static final long serialVersionUID = -4752871327020390873L;

  /**
   * Instantiates a new integrity exception.
   *
   * @param message the message
   */
  public IntegrityException(String message) {
    super(message);
  }

  /**
   * Instantiates a new integrity exception.
   *
   * @param message the message
   * @param cause the cause
   */
  public IntegrityException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Instantiates a new integrity exception.
   *
   * @param cause the cause
   */
  public IntegrityException(Throwable cause) {
    super(cause);
  }

}
