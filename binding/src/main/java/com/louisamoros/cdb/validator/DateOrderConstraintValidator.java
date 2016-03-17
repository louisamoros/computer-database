package com.louisamoros.cdb.validator;

import com.louisamoros.cdb.ComputerDto;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * DateOrderConstraintValidator class use to validate date order for annotation.
 */
public class DateOrderConstraintValidator implements ConstraintValidator<DateOrder, ComputerDto> {

  @Override
  public void initialize(final DateOrder dateOrder) {
  }

  @Override
  public final boolean isValid(final ComputerDto computerDto,
      final ConstraintValidatorContext context) {

    if (computerDto == null) {
      return false;
    }

    @Date
    String introduced = computerDto.getIntroduced();

    @Date
    String discontinued = computerDto.getDiscontinued();

    if (introduced == null || discontinued == null || introduced.isEmpty()
        || discontinued.isEmpty()) {
      return true;
    }

    LocalDate introducedDate = LocalDate.parse(introduced);
    LocalDate discontinuedDate = LocalDate.parse(discontinued);

    if (introducedDate.isAfter(discontinuedDate)) {
      return false;
    }

    return true;

  }

}
