package com.louisamoros.cdb.service.validator;

import java.util.List;

import com.louisamoros.cdb.exception.IntegrityException;
import com.louisamoros.cdb.exception.InvalidComputerNameException;
import com.louisamoros.cdb.exception.InvalidDateOrderException;
import com.louisamoros.cdb.model.Computer;

/**
 * Verication class for a computer or a list of computers.
 * 
 * @author louis
 *
 */
public class ComputerValidator {

	/**
	 * Verify computer object and throw runtime exception if anything wrong.
	 * 
	 * @param <Computer>
	 */
	public static void validate(Computer computer) {

		if (computer == null) {
			throw new IntegrityException("Computer cannot be null validation says.");
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
	 * Verify computer object list using validate method.
	 * 
	 * @param <List>
	 *            of <Computer>
	 */
	public static void validate(List<Computer> computers) {

		for (Computer computer : computers) {
			validate(computer);
		}

	}

}
