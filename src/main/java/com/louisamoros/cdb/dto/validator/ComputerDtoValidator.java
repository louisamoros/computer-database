package com.louisamoros.cdb.dto.validator;

import com.louisamoros.cdb.dto.ComputerDto;
import com.louisamoros.cdb.exception.IntegrityException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Computer dto validator.
 */
public final class ComputerDtoValidator {

  /* Date Format (yyyy-mm-dd) Regular Expression Pattern */
  private static final String DATE_PATTERN = "((19|20)\\d\\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])";

  /**
   * The computer dto validator constructor.
   */
  private ComputerDtoValidator() {
    super();
  }

  /**
   * Validate.
   *
   * @param computerDto the computer dto
   */
  public static void validate(final ComputerDto computerDto) {

    if (computerDto == null) {
      throw new IntegrityException("Computer cannot be empty.");
    }
    if (computerDto.getComputerName() == null || computerDto.getComputerName().isEmpty()) {
      throw new IntegrityException("Computer name is required.");
    }
    if (computerDto.getIntroduced() != null) {
      if (!computerDto.getIntroduced().isEmpty()) {
        if (!isDateValid(computerDto.getIntroduced())) {
          throw new IntegrityException("Introduced date format invalid.");
        }
      }
    }
    if (computerDto.getDiscontinued() != null) {
      if (!computerDto.getDiscontinued().isEmpty()) {
        if (!isDateValid(computerDto.getDiscontinued())) {
          throw new IntegrityException("Discontinued date format invalid.");
        }
      }
    }
  }

  /**
   * Validate date method based on the pattern attribute of the class.
   *
   * @param date the date to validate
   * @return boolean
   */
  private static boolean isDateValid(final String date) {

    Pattern pattern = Pattern.compile(DATE_PATTERN);
    Matcher matcher = pattern.matcher(date);
    boolean isValid;

    if (matcher.matches()) {

      matcher.reset();

      if (matcher.find()) {

        String day = matcher.group(3);
        String month = matcher.group(2);
        int year = Integer.parseInt(matcher.group(1));

        if (day.equals("31")
            && (month.equals("4") || month.equals("6") || month.equals("9") || month.equals("11")
                || month.equals("04") || month.equals("06") || month.equals("09"))) {
          isValid = false; // only 1,3,5,7,8,10,12 has 31 days
        } else if (month.equals("2") || month.equals("02")) {
          // leap year
          if (year % 4 == 0) {
            if (day.equals("30") || day.equals("31")) {
              isValid = false;
            } else {
              return true;
            }
          } else {
            if (day.equals("29") || day.equals("30") || day.equals("31")) {
              isValid = false;
            } else {
              isValid = true;
            }
          }
        } else {
          isValid = true;
        }
      } else {
        isValid = false;
      }
    } else {
      isValid = false;
    }

    return isValid;
  }

}
