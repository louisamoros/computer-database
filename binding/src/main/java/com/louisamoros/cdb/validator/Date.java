package com.louisamoros.cdb.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Annotation Date uses DateConstraintValidator.
 */
@Documented
@Constraint(validatedBy = DateConstraintValidator.class)
@Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Date {

    /**
     * Error message method.
     * @return string message
     */
    String message() default "Date format invalid.";

    /**
     * Pattern parameter return YYYY-MM-DD.
     * @return pattern
     */
    String pattern() default "YYYY-MM-dd";

    /**
     * Groups attribute that allows the specification of validation groups,
     * to which this constraint belongs (Grouping constraints).
     * This must default to an empty array of type Class<?>.
     * @return empty array of type Class<?>
     */
    Class<?>[] groups() default {};

    /**
     * Payload attribute that can be used by clients of the Bean Validation API
     * to assign custom payload objects to a constraint. This attribute is not used by the API itself.
     * @return empty Class<? extends Payload>
     */
    Class<? extends Payload>[] payload() default {};
}
