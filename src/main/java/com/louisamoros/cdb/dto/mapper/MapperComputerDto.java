package com.louisamoros.cdb.dto.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.louisamoros.cdb.dto.ComputerDto;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.validator.ComputerValidator;

/**
 * The Class MapperComputerDto.
 */
public class MapperComputerDto {

	/**
	 * To computer.
	 *
	 * @param computerDto
	 *            the computer dto
	 * @return the computer
	 */
	public static Computer toComputer(ComputerDto computerDto) {

		LocalDate introduced = null;
		LocalDate discontinued = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		if (computerDto.getIntroduced() != null) {
			introduced = LocalDate.parse(computerDto.getIntroduced(), formatter);
		}
		if (computerDto.getDiscontinued() != null) {
			discontinued = LocalDate.parse(computerDto.getDiscontinued(), formatter);
		}

		Company company = null;
		if (computerDto.getCompanyId() != 0) {
			company = new Company.Builder().id(computerDto.getCompanyId()).name(computerDto.getCompanyName()).build();
		}

		Computer computer = new Computer.Builder(computerDto.getComputerName()).company(company)
				.discontinued(discontinued).introduced(introduced).id(computerDto.getComputerId()).build();
		return computer;

	}

	/**
	 * To computer list.
	 *
	 * @param computersDto
	 *            the computers dto
	 * @return the list
	 */
	public static List<Computer> toComputerList(List<ComputerDto> computersDto) {

		List<Computer> computers = new ArrayList<>();
		for (ComputerDto computerDto : computersDto) {
			computers.add(toComputer(computerDto));
		}
		return computers;

	}

	/**
	 * To computer dto.
	 *
	 * @param computer
	 *            the computer
	 * @return the computer dto
	 */
	public static ComputerDto toComputerDto(Computer computer) {

		ComputerValidator.validate(computer);
		ComputerDto computerDto = new ComputerDto.Builder(computer.getName()).companyId(computer.getCompany().getId())
				.companyName(computer.getCompany().getName()).computerId(computer.getId())
				.introduced(String.valueOf(computer.getIntroduced()))
				.discontinued(String.valueOf(computer.getDiscontinued())).build();
		return computerDto;

	}

	/**
	 * To computer dto list.
	 *
	 * @param computers
	 *            the computers
	 * @return the list
	 */
	public static List<ComputerDto> toComputerDtoList(List<Computer> computers) {

		List<ComputerDto> computersDto = new ArrayList<>();
		for (Computer computer : computers) {
			computersDto.add(toComputerDto(computer));
		}
		return computersDto;

	}

}
