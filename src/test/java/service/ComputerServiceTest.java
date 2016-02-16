package service;

import java.util.ArrayList;
import java.util.List;

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
import com.louisamoros.cdb.service.ComputerService;
import com.louisamoros.cdb.service.impl.ComputerServiceImpl;


@RunWith(PowerMockRunner.class)
@PrepareForTest(ComputerDaoImpl.class)
public class ComputerServiceTest {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ComputerServiceTest.class);
	private static ComputerDao mockComputerDao;

	@BeforeClass
	public static void init() {
		LOGGER.debug("Init mocking computerDao...");
		mockComputerDao = PowerMockito.mock(ComputerDaoImpl.class);
		PowerMockito.when(mockComputerDao.getAllComputers()).thenReturn(new ArrayList<Computer>());
		
		
	}

	@Test
	public void getAllComputersTest() {
		LOGGER.debug("getAllComputersTest...");
		ComputerService computerService = ComputerServiceImpl.INSTANCE;
		computerService.setComputerDao(mockComputerDao);
		Assert.assertTrue(computerService.getAllComputers() instanceof List<?>);
	}

	@Test
	public void getComputersTest() {
		LOGGER.debug("getComputersTest...");
		ComputerService computerService = ComputerServiceImpl.INSTANCE;
		computerService.setComputerDao(mockComputerDao);
		Assert.assertTrue(computerService.getAllComputers() instanceof List<?>);
	}

	
}