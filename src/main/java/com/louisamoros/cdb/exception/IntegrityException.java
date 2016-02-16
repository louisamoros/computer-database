package com.louisamoros.cdb.exception;

public class IntegrityException  extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public IntegrityException (String message) {
        super(message);
    }

}
