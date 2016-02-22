package com.louisamoros.cdb.dao.exception;

/**
 * The Class DaoConnectionException.
 */
public class DaoConnectionException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new dao connection exception.
   *
   * @param message the message
   */
  public DaoConnectionException(String message) {
    super(message);
  }

  /**
   * Instantiates a new dao connection exception.
   *
   * @param message the message
   * @param cause the cause
   */
  public DaoConnectionException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Instantiates a new dao connection exception.
   *
   * @param cause the cause
   */
  public DaoConnectionException(Throwable cause) {
    super(cause);
  }
}