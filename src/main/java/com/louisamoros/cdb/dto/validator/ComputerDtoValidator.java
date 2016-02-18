package com.louisamoros.cdb.dto.validator;

import java.util.List;

import com.louisamoros.cdb.dto.ComputerDto;

/**
 * Verication class for a computer or a list of computers.
 * 
 * @author louis
 *
 */

public class ComputerDtoValidator {

	/**
	 * Verify computer dto object and throw runtime exception if anything wrong.
	 * 
	 * @param <ComputerDto>
	 */
	public static void validate(ComputerDto computerDto) {

		// if (computer == null) {
		// throw new IntegrityException("Computer cannot be null validation
		// says.");
		// }
		// if (computer.getIntroduced() != null && computer.getDiscontinued() !=
		// null
		// && computer.getIntroduced().isAfter(computer.getDiscontinued())) {
		// throw new InvalidDateOrderException("Intoduced date should be before
		// discontinued date.");
		// }
		// if (computer.getName() == null || computer.getName().isEmpty()) {
		// throw new InvalidComputerNameException("Computer name is required.");
		// }

	}

	/**
	 * Verify computer dto object list using validate method.
	 * 
	 * @param <List>
	 *            of <ComputerDto>
	 */
	public static void validate(List<ComputerDto> computersDto) {

		for (ComputerDto computerDto : computersDto) {
			validate(computerDto);
		}

	}

}
