package com.louisamoros.cdb.service.exception;

public class TransactionManagerException extends RuntimeException {

  private static final long serialVersionUID = -9045992823776977359L;

  public TransactionManagerException(String message, Throwable cause) {
    super(message, cause);
  }

}
