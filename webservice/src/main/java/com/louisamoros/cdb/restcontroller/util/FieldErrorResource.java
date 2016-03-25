package com.louisamoros.cdb.restcontroller.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by louis on 25/03/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FieldErrorResource {
    private String resource;
    private String field;
    private String code;
    private String message;

    public final String getResource() {
        return resource;
    }

    public final void setResource(final String resource) {
        this.resource = resource;
    }

    public final String getField() {
        return field;
    }

    public final void setField(final String field) {
        this.field = field;
    }

    public final String getCode() {
        return code;
    }

    public final void setCode(final String code) {
        this.code = code;
    }

    public final String getMessage() {
        return message;
    }

    public final void setMessage(final String message) {
        this.message = message;
    }
}
