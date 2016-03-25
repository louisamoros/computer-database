package com.louisamoros.cdb.restcontroller.exception;

import org.springframework.validation.Errors;

/**
 * Created by louis on 25/03/16.
 */
public class InvalidRequestException extends RuntimeException {

    private Errors errors;

    /**
     * Invalid request exception.
     * @param message the message
     * @param errors the errors
     */
    public InvalidRequestException(final String message, final Errors errors) {
        super(message);
        this.errors = errors;
    }

    public final Errors getErrors() { return errors; }

}
