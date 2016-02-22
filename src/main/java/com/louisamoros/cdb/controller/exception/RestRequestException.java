package com.louisamoros.cdb.controller.exception;

/**
 * The Class RestRequestException.
 */
public class RestRequestException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new rest request exception.
   *
   * @param message the message
   */
  public RestRequestException(String message) {
    super(message);
  }

  /**
   * Instantiates a new rest request exception.
   *
   * @param message the message
   * @param cause the cause
   */
  public RestRequestException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Instantiates a new rest request exception.
   *
   * @param cause the cause
   */
  public RestRequestException(Throwable cause) {
    super(cause);
  }

}
