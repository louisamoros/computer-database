package com.louisamoros.cdb.model.validator;

import com.louisamoros.cdb.model.Computer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

/**
 * DateOrderConstraintValidator class use to validate date order for annotation.
 */
public class DateOrderConstraintValidator implements ConstraintValidator<DateOrder, Computer> {

  @Override
  public void initialize(final DateOrder dateOrder) {
  }

  @Override
  public final boolean isValid(final Computer computer,
      final ConstraintValidatorContext context) {

    if (computer == null) {
      return false;
    }

    LocalDate introduced = computer.getIntroduced();
    LocalDate discontinued = computer.getDiscontinued();

    if (introduced == null || discontinued == null) {
      return true;
    }

    if (introduced.isAfter(discontinued)) {
      return false;
    }

    return true;

  }

}
