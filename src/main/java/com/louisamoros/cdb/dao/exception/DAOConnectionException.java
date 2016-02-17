package com.louisamoros.cdb.dao.exception;

public class DAOConnectionException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DAOConnectionException(String message) {
		super(message);
	}

	public DAOConnectionException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOConnectionException(Throwable cause) {
		super(cause);
	}
}