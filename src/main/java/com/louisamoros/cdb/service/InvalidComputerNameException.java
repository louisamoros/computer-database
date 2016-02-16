package com.louisamoros.cdb.service;

public class InvalidComputerNameException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InvalidComputerNameException (String message) {
		super(message);
	}
	
}
