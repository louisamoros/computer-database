package com.louisamoros.cdb.service.validator;

import com.louisamoros.cdb.exception.IntegrityException;
import com.louisamoros.cdb.exception.InvalidComputerNameException;
import com.louisamoros.cdb.exception.InvalidDateOrderException;
import com.louisamoros.cdb.model.Computer;

import java.util.List;

/**
 * The Class ComputerValidator.
 */
public class ComputerValidator {

  /**
   * Validate.
   *
   * @param computer the computer
   */
  public static void validate(Computer computer) {

    if (computer == null) {
      throw new IntegrityException("Computer cannot be null.");
    }
    if (computer.getIntroduced() != null && computer.getDiscontinued() != null
        && computer.getIntroduced().isAfter(computer.getDiscontinued())) {
      throw new InvalidDateOrderException("Intoduced date should be before discontinued date.");
    }
    if (computer.getName() == null || computer.getName().isEmpty()) {
      throw new InvalidComputerNameException("Computer name is required.");
    }

  }

  /**
   * Validate.
   *
   * @param computers the computers
   */
  public static void validate(List<Computer> computers) {

    for (Computer computer : computers) {
      validate(computer);
    }

  }

}
