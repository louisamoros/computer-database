package com.louisamoros.cdb.dmo.validator;

import com.louisamoros.cdb.dmo.ComputerDmo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

/**
 * DateOrderConstraintValidator class use to validate date order for annotation.
 */
public class DateOrderConstraintValidator implements ConstraintValidator<DateOrder, ComputerDmo> {

  @Override
  public void initialize(final DateOrder dateOrder) {
  }

  @Override
  public final boolean isValid(final ComputerDmo computerDmo,
      final ConstraintValidatorContext context) {

    if (computerDmo == null) {
      return false;
    }

    LocalDate introduced = computerDmo.getIntroduced();
    LocalDate discontinued = computerDmo.getDiscontinued();

    if (introduced == null || discontinued == null) {
      return true;
    }

    if (introduced.isAfter(discontinued)) {
      return false;
    }

    return true;

  }

}
