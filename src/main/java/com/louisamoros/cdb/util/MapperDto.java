package com.louisamoros.cdb.util;

import java.time.LocalDate;

import com.louisamoros.cdb.dto.ComputerDto;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.model.Computer;

/**
 * Class with static method use to convert DTO to DAO.
 * 
 * @author excilys
 *
 */
public class MapperDto {

	/**
	 * Convert ComputerDao element to Computer model.
	 * 
	 * @param computer
	 *            dto
	 * @return computer model
	 */
	public static Computer toComputer(ComputerDto computerDto) {
		Company company = new Company(computerDto.getCompanyId(), computerDto.getCompanyName());
		Computer computer = new Computer(computerDto.getComputerId(), company, computerDto.getName(),
				LocalDate.parse(computerDto.getIntroducedDate().replace("/", "-")), LocalDate.parse(computerDto.getDiscontinuedDate().replace("/", "-")));
		return computer;
	}

	/**
	 * Convert Computer model to ComputerDao element.
	 * 
	 * @param computer
	 *            model
	 * @return computer dto
	 */
	public static ComputerDto toComputerDto(Computer computer) {
		ComputerDto computerDto = new ComputerDto(computer.getComputerId(), computer.getName(),
				computer.getDiscontinuedDate().toString().replace("-", "/"), computer.getIntroducedDate().toString().replace("-", "/"),
				computer.getCompany().getName(), computer.getCompany().getCompanyId());
		return computerDto;
	}

}
