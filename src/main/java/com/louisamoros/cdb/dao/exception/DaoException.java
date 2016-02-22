package com.louisamoros.cdb.dao.exception;

/**
 * The Class DAOException.
 */
public class DaoException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new DAO exception.
   *
   * @param message the message
   */
  public DaoException(String message) {
    super(message);
  }

  /**
   * Instantiates a new DAO exception.
   *
   * @param message the message
   * @param cause the cause
   */
  public DaoException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Instantiates a new DAO exception.
   *
   * @param cause the cause
   */
  public DaoException(Throwable cause) {
    super(cause);
  }

}