package com.louisamoros.cdb.exception;

public class InvalidDateOrderException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InvalidDateOrderException (String message) {
		super(message);
	}
	
}
