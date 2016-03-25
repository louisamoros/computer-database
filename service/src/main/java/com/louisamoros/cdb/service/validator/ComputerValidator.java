package com.louisamoros.cdb.service.validator;

import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.exception.IntegrityException;
import com.louisamoros.cdb.service.exception.InvalidComputerNameException;
import com.louisamoros.cdb.service.exception.InvalidDateOrderException;

import java.util.List;

/**
 * ComputerDmo model validator class.
 */
public final class ComputerValidator {

  /**
   * ComputerDmo validator constructor.
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
      throw new IntegrityException("ComputerDmo cannot be null.");
    }
    if (computer.getIntroduced() != null && computer.getDiscontinued() != null
        && computer.getIntroduced().isAfter(computer.getDiscontinued())) {
      throw new InvalidDateOrderException("Introduced date should be before discontinued date.");
    }
    if (computer.getName() == null || computer.getName().isEmpty()) {
      throw new InvalidComputerNameException("ComputerDmo name is required.");
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
