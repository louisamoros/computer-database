package com.louisamoros.cdb.dao.exception;

/**
 * Catch exception in DAOs mappers
 * @author louis
 *
 */
public class DAOMapperException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DAOMapperException(String message) {
		super(message);
	}

	public DAOMapperException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOMapperException(Throwable cause) {
		super(cause);
	}
}
