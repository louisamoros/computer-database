package com.louisamoros.cdb.controller.exception;

public class RestRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RestRequestException(String message) {
		super(message);
	}

	public RestRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public RestRequestException(Throwable cause) {
		super(cause);
	}
	
}
