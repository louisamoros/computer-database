package com.louisamoros.cdb.dto.mapper;

import java.util.List;

import com.louisamoros.cdb.dto.ComputerDto;
import com.louisamoros.cdb.dto.validator.ComputerDtoValidator;
import com.louisamoros.cdb.exception.IntegrityException;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.validator.ComputerValidator;

/**
 * Computer mapper between dto and model.
 *
 * @author louis
 */
public class MapperComputerDto {

	/**
	 * Convert ComputerDao element to Computer model.
	 *
	 * @param <ComputerDto>
	 * @return <Computer>
	 */
	public static Computer toComputer(ComputerDto computerDto) {

		ComputerDtoValidator.validate(computerDto);
		if (computerDto == null) {
			throw new IntegrityException("A computer dto can't be null.");
		}
		return null;
		
	}
	
	/**
	 * Convert List of ComputerDto element to ComputerDao model.
	 * @param <List> of <ComputerDto>
	 * @return <List> of <Computer>
	 */
	public static List<Computer> toComputerList(List<ComputerDto> computersDto) {
	
		ComputerDtoValidator.validate(computersDto);
		if (computersDto == null) {
			throw new IntegrityException("List of computers dto can't be null.");
		}
		return null;
	
	}

	/**
	 * Convert Computer model to ComputerDao element.
	 *
	 * @param <Computer>
	 * @return <ComputerDto>
	 */
	public static ComputerDto toComputerDto(Computer computer) {

		ComputerValidator.validate(computer);
		if (computer == null) {
			throw new IntegrityException("A computer can't be null.");
		}
		return null;
	
	}

	/**
	 * Convert List of Computer model to ComputerDao element.
	 * @param <List> of <Computer>
	 * @return <List> of <ComputerDto>
	 */
	public static List<ComputerDto> toComputerDtoList(List<Computer> computers) {
		
		ComputerValidator.validate(computers);
		if (computers == null) {
			throw new IntegrityException("List of computers can't be null.");
		}
		return null;
	
	}

}
