package com.louisamoros.cdb.dto;

import java.time.LocalDate;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.louisamoros.cdb.exception.IntegrityException;
import com.louisamoros.cdb.exception.InvalidComputerNameException;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.dto.mapper.ComputerDaoMapper;

public class MapperDtoTest {

	private static Logger LOGGER = LoggerFactory.getLogger(MapperDtoTest.class);

	@Test
	public void toComputerDtoTest() {
		LOGGER.debug("toComputerDtoTest...");
		
		ComputerDto computerDtoExpected = new ComputerDto();
		computerDtoExpected.setName("computerTest");
		computerDtoExpected.setComputerId(1);
		computerDtoExpected.setDiscontinuedDate("2000/09/21");
		computerDtoExpected.setIntroducedDate("2000/09/21");
		computerDtoExpected.setCompanyId(1);
		computerDtoExpected.setCompanyName("companyTest");

		Company company = new Company(1, "companyTest");
		Computer computer = new Computer(1, company, "computerTest", LocalDate.of(2000, 9, 21), LocalDate.of(2000, 9, 21));

		ComputerDto computerDto = ComputerDaoMapper.toComputerDto(computer);

		Assert.assertEquals(computerDtoExpected.getCompanyId(), computerDto.getCompanyId());
		Assert.assertEquals(computerDtoExpected.getCompanyName(), computerDto.getCompanyName());
		Assert.assertEquals(computerDtoExpected.getComputerId(), computerDto.getComputerId());
		Assert.assertEquals(computerDtoExpected.getName(), computerDto.getName());
		Assert.assertEquals(computerDtoExpected.getIntroducedDate(), computerDto.getIntroducedDate());
		Assert.assertEquals(computerDtoExpected.getDiscontinuedDate(), computerDto.getDiscontinuedDate());
	}
	
	@Test
	public void toComputerDtoNullTest() {
		LOGGER.debug("toComputerDtoNullTest...");
		
		ComputerDto computerDtoExpected = new ComputerDto();
		computerDtoExpected.setName("computerTest");
		computerDtoExpected.setComputerId(0);
		computerDtoExpected.setDiscontinuedDate("");
		computerDtoExpected.setIntroducedDate("");
		computerDtoExpected.setCompanyId(0);
		computerDtoExpected.setCompanyName("");

		Company company = null;
		Computer computer = new Computer(company, "computerTest", null, null);

		ComputerDto computerDto = ComputerDaoMapper.toComputerDto(computer);

		Assert.assertEquals(computerDtoExpected.getCompanyId(), computerDto.getCompanyId());
		Assert.assertEquals(computerDtoExpected.getCompanyName(), computerDto.getCompanyName());
		Assert.assertEquals(computerDtoExpected.getComputerId(), computerDto.getComputerId());
		Assert.assertEquals(computerDtoExpected.getName(), computerDto.getName());
		Assert.assertEquals(computerDtoExpected.getIntroducedDate(), computerDto.getIntroducedDate());
		Assert.assertEquals(computerDtoExpected.getDiscontinuedDate(), computerDto.getDiscontinuedDate());
	}
	
	@Test (expected = InvalidComputerNameException.class)
	public void toComputerDtoNoComputerNameTest() {
		LOGGER.debug("toComputerDtoNoComputerNameTest...");
		
		Company company = null;
		Computer computer = new Computer(company, null, null, null);

		ComputerDaoMapper.toComputerDto(computer);
	}
	
	@Test (expected = IntegrityException.class)
	public void toComputerDtoNoComputerTest() {
		LOGGER.debug("toComputerDtoNoComputerTest...");
		
		Computer computer = null;

		ComputerDaoMapper.toComputerDto(computer);
	}
	
	@Test
	public void toComputerTest() {
		LOGGER.debug("toComputerTest...");
		Company companyExpected = new Company(1, "companyTest");
		Computer computerExpected = new Computer(1, companyExpected, "computerTest", LocalDate.of(2000, 9, 21), LocalDate.of(2000, 9, 21));

		ComputerDto computerDto = new ComputerDto();
		computerDto.setName("computerTest");
		computerDto.setComputerId(1);
		computerDto.setDiscontinuedDate("2000/09/21");
		computerDto.setIntroducedDate("2000/09/21");
		computerDto.setCompanyId(1);
		computerDto.setCompanyName("companyTest");

		Computer computer = ComputerDaoMapper.toComputer(computerDto);

		Assert.assertEquals(computerExpected.getCompany(), computer.getCompany());
		Assert.assertEquals(computerExpected.getComputerId(), computer.getComputerId());
		Assert.assertEquals(computerExpected.getName(), computer.getName());
		Assert.assertEquals(computerExpected.getDiscontinuedDate(), computer.getDiscontinuedDate());
		Assert.assertEquals(computerExpected.getIntroducedDate(), computer.getIntroducedDate());
	}
	
	@Test
	public void toComputerNullTest() {
		LOGGER.debug("toComputerNullTest...");
		Company companyExpected = null;
		Computer computerExpected = new Computer(companyExpected, "computerTest", null, null);
		
		ComputerDto computerDto = new ComputerDto();
		computerDto.setName("computerTest");
		computerDto.setComputerId(0);
		computerDto.setDiscontinuedDate("");
		computerDto.setIntroducedDate("");
		computerDto.setCompanyId(0);
		computerDto.setCompanyName("");

		Computer computer = ComputerDaoMapper.toComputer(computerDto);

		Assert.assertEquals(computerExpected.getCompany(), computer.getCompany());
		Assert.assertEquals(computerExpected.getComputerId(), computer.getComputerId());
		Assert.assertEquals(computerExpected.getName(), computer.getName());
		Assert.assertEquals(computerExpected.getIntroducedDate(), computer.getIntroducedDate());
		Assert.assertEquals(computerExpected.getDiscontinuedDate(), computer.getDiscontinuedDate());
	}
	
	@Test (expected = InvalidComputerNameException.class)
	public void toComputerNoComputerNameTest() {
		LOGGER.debug("toComputerNoComputerNameTest...");
		
		Company company = null;
		Computer computer = new Computer(company, null, null, null);

		ComputerDaoMapper.toComputerDto(computer);
	}
	
	@Test (expected = IntegrityException.class)
	public void toComputerNoComputerTest() {
		LOGGER.debug("toComputerDtoNoComputerTest...");
		
		Computer computer = null;

		ComputerDaoMapper.toComputerDto(computer);
	}

}
