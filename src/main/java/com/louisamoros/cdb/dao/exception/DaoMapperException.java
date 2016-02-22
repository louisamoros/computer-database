package com.louisamoros.cdb.dao.exception;

/**
 * The Class DAOMapperException.
 */
public class DaoMapperException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new dao mapper exception.
   *
   * @param message the message
   */
  public DaoMapperException(String message) {
    super(message);
  }

  /**
   * Instantiates a new DAO mapper exception.
   *
   * @param message the message
   * @param cause the cause
   */
  public DaoMapperException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Instantiates a new DAO mapper exception.
   *
   * @param cause the cause
   */
  public DaoMapperException(Throwable cause) {
    super(cause);
  }
}
