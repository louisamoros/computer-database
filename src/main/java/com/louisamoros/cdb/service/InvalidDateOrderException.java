package com.louisamoros.cdb.service;

public class InvalidDateOrderException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InvalidDateOrderException (String message) {
		super(message);
	}
	
}
