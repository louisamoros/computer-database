package com.louisamoros.cdb.util;

import java.time.LocalDate;

import com.louisamoros.cdb.dto.CompanyDto;
import com.louisamoros.cdb.dto.ComputerDto;
import com.louisamoros.cdb.exception.IntegrityException;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.exception.InvalidComputerNameException;

/**
 * Class with static method use to convert DTO to DAO.
 *
 * @author excilys
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

		if (computerDto == null) {
			throw new IntegrityException("A computer dto can't be empty.");
		}

		Computer computer = new Computer();
		computer.setComputerId(computerDto.getComputerId());

		if (computerDto.getName() == "" || computerDto.getName() == null) {
			throw new InvalidComputerNameException("Computer name is required.");
		} else {
			computer.setName(computerDto.getName());
		}
		
		if (computerDto.getIntroducedDate() == "" || computerDto.getIntroducedDate() == null) {
			computer.setIntroducedDate(null);
		} else {
			computer.setIntroducedDate(LocalDate.parse(computerDto.getIntroducedDate().replace("/", "-")));
		}

		if (computerDto.getDiscontinuedDate() == "" || computerDto.getDiscontinuedDate() == null) {
			computer.setDiscontinuedDate(null);
		} else {
			computer.setDiscontinuedDate(LocalDate.parse(computerDto.getDiscontinuedDate().replace("/", "-")));
		}

		if (computerDto.getCompanyId() == 0) {
			computer.setCompany(null);
		} else if (computerDto.getCompanyName() == "" || computerDto.getCompanyName() == null) {
			computer.setCompany(new Company(computerDto.getCompanyId(), null));
		} else {
			computer.setCompany(new Company(computerDto.getCompanyId(), computerDto.getCompanyName()));
		}

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

		if (computer == null) {
			throw new IntegrityException("A computer can't be empty.");
		}

		ComputerDto computerDto = new ComputerDto();

		if (computer.getName() == "" || computer.getName() == null) {
			throw new InvalidComputerNameException("Computer name is required.");
		} else {
			computerDto.setName(computer.getName());
		}

		if (computer.getIntroducedDate() == null) {
			computerDto.setIntroducedDate("");
		} else {
			computerDto.setIntroducedDate(computer.getIntroducedDate().toString().replace("-", "/"));
		}

		if (computer.getDiscontinuedDate() == null) {
			computerDto.setDiscontinuedDate("");
		} else {
			computerDto.setDiscontinuedDate(computer.getDiscontinuedDate().toString().replace("-", "/"));
		}
	
		if (computer.getComputerId() == 0) {
			computerDto.setComputerId(0);
		} else {
			computerDto.setComputerId(computer.getComputerId());
		}
		
		if(computer.getCompany() == null) {
			computerDto.setCompanyId(0);
			computerDto.setCompanyName("");
		} else if (computer.getCompany().getName() != null) {
			computerDto.setCompanyName(computer.getCompany().getName());
			computerDto.setCompanyId(computer.getCompany().getCompanyId());
		} else {
			computerDto.setCompanyName("");
			computerDto.setCompanyId(computer.getCompany().getCompanyId());
		}
		
		return computerDto;
	}

	/**
	 * Convert CompanyDao element to Company model.
	 *
	 * @param company
	 *            dto
	 * @return company model
	 */
	public static Company toCompany(CompanyDto companyDto) {

		if (companyDto == null) {
			throw new IntegrityException("A company dto can't be empty.");
		}

		Company company = new Company();

		if (companyDto.getName() == "") {
			company.setName(null);
		} else {
			company.setName(companyDto.getName());
		}
		company.setCompanyId(companyDto.getCompanyId());

		return company;
	}

	/**
	 * Convert Company model to CompanyDao element.
	 *
	 * @param company
	 *            model
	 * @return company dto
	 */
	public static CompanyDto toCompanyDto(Company company) {

		if (company == null) {
			throw new IntegrityException("A company can't be empty.");
		}

		CompanyDto companyDto = new CompanyDto();

		if (company.getName() == null) {
			companyDto.setName("");
		} else {
			companyDto.setName(company.getName());
		}
		companyDto.setCompanyId(company.getCompanyId());

		return companyDto;
	}

}
