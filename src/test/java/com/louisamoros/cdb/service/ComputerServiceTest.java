package com.louisamoros.cdb.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.louisamoros.cdb.exception.InvalidComputerNameException;
import com.louisamoros.cdb.exception.InvalidDateOrderException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.dao.impl.ComputerDaoImpl;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.impl.ComputerServiceImpl;


@RunWith(PowerMockRunner.class)
@PrepareForTest(ComputerDaoImpl.class)
public class ComputerServiceTest {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ComputerServiceTest.class);
	private static ComputerDao mockComputerDao;
	private static ComputerService computerService;

	@BeforeClass
	public static void init() {
		LOGGER.debug("Init mocking computerDao...");
		mockComputerDao = PowerMockito.mock(ComputerDaoImpl.class);
		computerService = ComputerServiceImpl.INSTANCE;
		computerService.setComputerDao(mockComputerDao);
	}

	@Test
	public void getAllComputersTest() {
		LOGGER.debug("getAllComputersTest...");
		PowerMockito.when(mockComputerDao.getAll()).thenReturn(getComputers());
		Assert.assertTrue(computerService.getAll() instanceof List<?>);
		Assert.assertEquals(computerService.getAll().size(), 2);
	}

	@Test
	public void getComputersTest() {
		LOGGER.debug("getComputersTest...");
		PowerMockito.when(mockComputerDao.get(0, 10)).thenReturn(getComputers());
		Assert.assertTrue(computerService.get(0, 10) instanceof List<?>);
		Assert.assertEquals(computerService.get(0, 10).size(), 2);
	}

	@Test
	public void createComputerTest() {
		LOGGER.debug("createComputerTest...");
		Computer computer1 = new Computer.Builder("computer1").company(null).introduced(null).discontinued(null).build();
		Computer computerReturn = new Computer.Builder("computer1").id(1).company(null).discontinued(null).introduced(null).build();
		PowerMockito.when(mockComputerDao.create(computer1)).thenReturn(computerReturn);
		Computer createdComputer = computerService.create(computer1);
		Assert.assertTrue(createdComputer.equals(computerReturn));
	}
	
	@Test (expected = InvalidComputerNameException.class)
	public void createComputerInvalidNameTest() {
		LOGGER.debug("createComputerInvalidNameTest...");
		Computer computer1 = new Computer.Builder(null).company(null).discontinued(null).introduced(null).build();
		computerService.create(computer1);
	}
	
	@Test (expected = InvalidDateOrderException.class)
	public void createComputerInvalidDateOrderTest() {
		LOGGER.debug("createComputerInvalidDateOrderTest...");
		Computer computer1 = new Computer.Builder("computer1").company(null).discontinued(LocalDate.of(2000, 9, 9)).introduced(LocalDate.now()).build();
		computerService.create(computer1);
	}
	
	@Test
	public void deleteComputerTest() {
		LOGGER.debug("deleteComputerTest...");
		ArrayList<Computer> computers = getComputers();
		computers.remove(1);
		mockComputerDao.delete(1);
		PowerMockito.when(mockComputerDao.getAll()).thenReturn(computers);
		Assert.assertEquals(computerService.getAll().size(), 1);		
	}
	
	@Test
	public void updateComputerTest() {
		LOGGER.debug("updateComputerTest...");
		ArrayList<Computer> computers = getComputers();
		Computer computer1 = new Computer.Builder("updatedComputer").company(null).discontinued(null).introduced(null).build();
		computers.set(1, computer1);
		PowerMockito.when(mockComputerDao.update(computer1)).thenReturn(computer1);
		PowerMockito.when(mockComputerDao.getAll()).thenReturn(computers);
		Assert.assertEquals(computerService.getAll().size(), 2);
		Assert.assertTrue(computer1.equals(computers.get(1)));
	}
	
	private ArrayList<Computer> getComputers() {
		Computer computer1 = new Computer.Builder("computer1").company(null).discontinued(null).introduced(null).build();
		Computer computer2 = new Computer.Builder("computer2").company(null).discontinued(null).introduced(null).build();
		ArrayList<Computer> computers = new ArrayList<Computer>();
		computers.add(computer1);
		computers.add(computer2);
		return computers;
	}
	
}