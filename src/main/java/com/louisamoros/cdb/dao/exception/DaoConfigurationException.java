package com.louisamoros.cdb.dao.exception;

/**
 * The Class DaoConfigurationException.
 */
public class DaoConfigurationException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new dao configuration exception.
   *
   * @param message the message
   */
  public DaoConfigurationException(String message) {
    super(message);
  }

  /**
   * Instantiates a new dao configuration exception.
   *
   * @param message the message
   * @param cause the cause
   */
  public DaoConfigurationException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Instantiates a new dao configuration exception.
   *
   * @param cause the cause
   */
  public DaoConfigurationException(Throwable cause) {
    super(cause);
  }
}
