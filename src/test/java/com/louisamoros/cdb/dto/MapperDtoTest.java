package com.louisamoros.cdb.dto;

import java.time.LocalDate;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.util.MapperDto;

public class MapperDtoTest {

	private static Logger LOGGER = LoggerFactory.getLogger(MapperDtoTest.class);

	@Test
	public void toComputerDtoTest() {
		LOGGER.debug("toComputerDtoTest...");
		ComputerDto computerDtoExpected = new ComputerDto(1, "computerTest", "2000/09/21", "2000/09/21", "companyTest", 1);
		Company company = new Company(1, "companyTest");
		Computer computer = new Computer(1, company, "computerTest", LocalDate.of(2000, 9, 21), LocalDate.of(2000, 9, 21));
		ComputerDto computerDto = MapperDto.toComputerDto(computer);
		Assert.assertEquals(computerDtoExpected.getCompanyId(), computerDto.getCompanyId());
		Assert.assertEquals(computerDtoExpected.getCompanyName(), computerDto.getCompanyName());
		Assert.assertEquals(computerDtoExpected.getComputerId(), computerDto.getComputerId());
		Assert.assertEquals(computerDtoExpected.getName(), computerDto.getName());
		Assert.assertEquals(computerDtoExpected.getIntroducedDate(), computerDto.getIntroducedDate());
		Assert.assertEquals(computerDtoExpected.getDiscontinuedDate(), computerDto.getDiscontinuedDate());
	}
	
	@Test
	public void toComputerTest() {
		LOGGER.debug("toComputerTest...");
		Company companyExpected = new Company(1, "companyTest");
		Computer computerExpected = new Computer(1, companyExpected, "computerTest", LocalDate.of(2000, 9, 21), LocalDate.of(2000, 9, 21));
		ComputerDto computerDto = new ComputerDto(1, "computerTest", "2000/09/21", "2000/09/21", "companyTest", 1);
		Computer computer = MapperDto.toComputer(computerDto);
		Assert.assertEquals(computerExpected.getCompany(), computer.getCompany());
		Assert.assertEquals(computerExpected.getComputerId(), computer.getComputerId());
		Assert.assertEquals(computerExpected.getName(), computer.getName());
		Assert.assertEquals(computerExpected.getDiscontinuedDate(), computer.getDiscontinuedDate());
		Assert.assertEquals(computerExpected.getIntroducedDate(), computer.getIntroducedDate());
	}
	
	@Test
	public void toComputerNullDtoTest() {
		LOGGER.debug("toComputerNullDtoTest...");
//		ComputerDto computerDtoExpected = new ComputerDto(1, "computerTest", "2000/09/21", "2000/09/21", "companyTest", 1);
		Computer computer = new Computer(null, "computerTest", null, null);
		ComputerDto computerDto = MapperDto.toComputerDto(computer);
//		Assert.assertEquals(computerDtoExpected.getCompanyId(), computerDto.getCompanyId());
//		Assert.assertEquals(computerDtoExpected.getCompanyName(), computerDto.getCompanyName());
//		Assert.assertEquals(computerDtoExpected.getComputerId(), computerDto.getComputerId());
//		Assert.assertEquals(computerDtoExpected.getName(), computerDto.getName());
//		Assert.assertEquals(computerDtoExpected.getIntroducedDate(), computerDto.getIntroducedDate());
//		Assert.assertEquals(computerDtoExpected.getDiscontinuedDate(), computerDto.getDiscontinuedDate());
	}
	
//	@Test
//	public void toComputerNullTest() {
//		LOGGER.debug("toComputerTest...");
//		Company companyExpected = new Company(1, "companyTest");
//		Computer computerExpected = new Computer(1, companyExpected, "computerTest", LocalDate.of(2000, 9, 21), LocalDate.of(2000, 9, 21));
//		ComputerDto computerDto = new ComputerDto(1, "computerTest", "2000/09/21", "2000/09/21", "companyTest", 1);
//		Computer computer = MapperDto.toComputer(computerDto);
//		Assert.assertEquals(computerExpected.getCompany(), computer.getCompany());
//		Assert.assertEquals(computerExpected.getComputerId(), computer.getComputerId());
//		Assert.assertEquals(computerExpected.getName(), computer.getName());
//		Assert.assertEquals(computerExpected.getDiscontinuedDate(), computer.getDiscontinuedDate());
//		Assert.assertEquals(computerExpected.getIntroducedDate(), computer.getIntroducedDate());
//	}

}
