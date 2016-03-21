package com.louisamoros.cdb.model;


import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;

/**
 * Abstract builder class used to set validation workflow when building model with builder pattern.
 * @param <T> the model to check and build
 */
public abstract class AbstractBuilder<T> {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * Internal building class to be override by builder class model.
     * @return T specified type of object
     */
    protected abstract T buildInternal();

    /**
     * Building method wrapping the validation.
     * @throws ConstraintViolationException the constraint violation exception
     * @return T specified type of object
     */
    public final T build() throws ConstraintViolationException {

        T object = buildInternal();

        Set<ConstraintViolation<T>> violations = validator.validate(object);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
        }

        return object;
    }

}
