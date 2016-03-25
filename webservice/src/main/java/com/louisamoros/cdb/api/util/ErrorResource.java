package com.louisamoros.cdb.api.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Error resource class.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResource {
    private String code;
    private String message;
    private List<FieldErrorResource> fieldErrors;

    /**
     * Constructor
     * @param code the code
     * @param message the message
     */
    public ErrorResource(final String code, final String message) {
        this.code = code;
        this.message = message;
    }

    public final String getCode() { return code; }

    public final void setCode(final String code) { this.code = code; }

    public final String getMessage() { return message; }

    public final void setMessage(final String message) { this.message = message; }

    public final List<FieldErrorResource> getFieldErrors() { return fieldErrors; }

    public final void setFieldErrors(final List<FieldErrorResource> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
