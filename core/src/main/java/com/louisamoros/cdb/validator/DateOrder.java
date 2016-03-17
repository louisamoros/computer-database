package com.louisamoros.cdb.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation DateOrder using DateOrderConstraintValidator.
 */
@Documented
@Constraint(validatedBy = DateOrderConstraintValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface DateOrder {

  /**
   * Error message method.
   * @return string message
   */
  String message() default "Introduced and discontinued dates are in the wrong order.";

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
