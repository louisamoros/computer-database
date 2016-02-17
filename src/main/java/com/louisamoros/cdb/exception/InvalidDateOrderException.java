package com.louisamoros.cdb.exception;

/**
 * Wrap exception when Computer local date are not in the order as they should.
 * 
 * @author louis
 *
 */
public class InvalidDateOrderException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidDateOrderException(String message) {
		super(message);
	}

	public InvalidDateOrderException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidDateOrderException(Throwable cause) {
		super(cause);
	}

}
