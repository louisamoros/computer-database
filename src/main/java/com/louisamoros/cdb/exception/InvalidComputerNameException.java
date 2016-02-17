package com.louisamoros.cdb.exception;

/**
 * Wrap exception when Computer name is empty or null.
 * 
 * @author louis
 *
 */
public class InvalidComputerNameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidComputerNameException(String message) {
		super(message);
	}

	public InvalidComputerNameException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidComputerNameException(Throwable cause) {
		super(cause);
	}

}
