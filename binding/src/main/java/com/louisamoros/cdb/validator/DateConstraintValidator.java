package com.louisamoros.cdb.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * DateConstraintValidator class use to validate date format for annotation.
 */
public class DateConstraintValidator implements ConstraintValidator<Date, String> {

  private String pattern;

  @Override
  public final void initialize(final Date date) {
    this.pattern = date.pattern();
  }

  @Override
  public final boolean isValid(final String date, final ConstraintValidatorContext context) {

    if (date == null || date.isEmpty()) {
      return true;
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
    dateFormat.setLenient(false);
    try {
      dateFormat.parse(date.trim());
    } catch (ParseException pe) {
      return false;
    }
    return true;
  }

}
