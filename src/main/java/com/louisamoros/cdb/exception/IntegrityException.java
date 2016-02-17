package com.louisamoros.cdb.exception;

/**
 * Wrap exception when Object is not correct.
 * 
 * @author louis
 *
 */
public class IntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IntegrityException(String message) {
		super(message);
	}

	public IntegrityException(String message, Throwable cause) {
		super(message, cause);
	}

	public IntegrityException(Throwable cause) {
		super(cause);
	}

}
