package com.louisamoros.cdb.dto.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.louisamoros.cdb.dto.ComputerDto;
import com.louisamoros.cdb.model.Company;
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

		Computer computer = new Computer.Builder(computerDto.getComputerName())
				.company(
						new Company.Builder().id(computerDto.getCompanyId()).name(computerDto.getCompanyName()).build())
				.discontinued(LocalDate.parse(computerDto.getDiscontinuedDate()))
				.introduced(LocalDate.parse(computerDto.getIntroducedDate())).id(computerDto.getComputerId()).build();
		return computer;

	}

	/**
	 * Convert List of ComputerDto element to ComputerDao model.
	 * 
	 * @param <List>
	 *            of <ComputerDto>
	 * @return <List> of <Computer>
	 */
	public static List<Computer> toComputerList(List<ComputerDto> computersDto) {
		
		List<Computer> computers = new ArrayList<>();
		for(ComputerDto computerDto:computersDto) {
			computers.add(toComputer(computerDto));
		}
		return computers;

	}

	/**
	 * Convert Computer model to ComputerDao element.
	 *
	 * @param <Computer>
	 * @return <ComputerDto>
	 */
	public static ComputerDto toComputerDto(Computer computer) {

		ComputerValidator.validate(computer);
		ComputerDto computerDto = new ComputerDto.Builder(computer.getName())
				.companyId(computer.getCompany().getId())
				.companyName(computer.getCompany().getName())
				.computerId(computer.getId())
				.introduced(String.valueOf(computer.getIntroduced()))
				.discontinued(String.valueOf(computer.getDiscontinued()))
				.build();
		return computerDto;

	}

	/**
	 * To computer dto list.
	 *
	 * @param computers the computers
	 * @return the list
	 */
	public static List<ComputerDto> toComputerDtoList(List<Computer> computers) {

		List<ComputerDto> computersDto = new ArrayList<>();
		for(Computer computer:computers) {
			computersDto.add(toComputerDto(computer));
		}
		return computersDto;

	}

}
