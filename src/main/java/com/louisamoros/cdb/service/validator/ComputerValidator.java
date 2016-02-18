package com.louisamoros.cdb.service.validator;

import com.louisamoros.cdb.exception.InvalidComputerNameException;
import com.louisamoros.cdb.exception.InvalidDateOrderException;
import com.louisamoros.cdb.model.Computer;

public class ComputerValidator {

	public static void validate(Computer computer) {
		if(computer.getIntroduced() != null && computer.getDiscontinued() != null && computer.getIntroduced().isAfter(computer.getDiscontinued())) {
			throw new InvalidDateOrderException("Intoduced date should be before discontinued date.");
		}
		if (computer.getName() == null || computer.getName().isEmpty()) {
			throw new InvalidComputerNameException("Computer name is required.");
		}
	}
	
}
