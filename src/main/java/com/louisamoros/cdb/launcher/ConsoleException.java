package com.louisamoros.cdb.launcher;


/**
 * Runtime exception for handling console errors.
 * 
 * @author McDowell
 */
public class ConsoleException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public ConsoleException(Throwable t) {
    super(t);
  }
}
