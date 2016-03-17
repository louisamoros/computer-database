package com.louisamoros.cdb.validator;

import com.louisamoros.cdb.exception.IntegrityException;
import com.louisamoros.cdb.exception.InvalidComputerNameException;
import com.louisamoros.cdb.exception.InvalidDateOrderException;
import com.louisamoros.cdb.model.Computer;

import java.util.List;

/**
 * Computer model validator class.
 */
public final class ComputerValidator {

  /**
   * Computer validator constructor.
   */
  private ComputerValidator() {
    super();
  }

  /**
   * Validation method of a computer.
   *
   * @param computer the computer
   */
  public static void validate(final Computer computer) {

    if (computer == null) {
      throw new IntegrityException("Computer cannot be null.");
    }
    if (computer.getIntroduced() != null && computer.getDiscontinued() != null
        && computer.getIntroduced().isAfter(computer.getDiscontinued())) {
      throw new InvalidDateOrderException("Introduced date should be before discontinued date.");
    }
    if (computer.getComputerName() == null || computer.getComputerName().isEmpty()) {
      throw new InvalidComputerNameException("Computer name is required.");
    }

  }

  /**
   * Validation method of a company list.
   *
   * @param computers the list of computer
   */
  public static void validate(final List<Computer> computers) {

    computers.forEach(computer -> validate(computer));

  }

}
