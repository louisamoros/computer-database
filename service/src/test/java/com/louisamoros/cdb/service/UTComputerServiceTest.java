package com.louisamoros.cdb.service;

import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.exception.InvalidComputerNameException;
import com.louisamoros.cdb.service.exception.InvalidDateOrderException;
import com.louisamoros.cdb.service.impl.ComputerServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Computer service class test.
 */
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:service-context.xml")
@PowerMockIgnore( {"javax.management.*"})
@PrepareForTest({Computer.class})
public class UTComputerServiceTest {

    /**
     * Logger of the class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UTComputerServiceTest.class);

    @Mock
    private ComputerDao mockComputerDao;

    @Mock
    private Computer computer;

    @InjectMocks
    private ComputerService computerService = new ComputerServiceImpl();

    /**
     * Mock spring beans.
     */
    @Before
    public final void init() {
        LOGGER.info("Initialize mocks [mockComputerDao]...");
        // scans the class annotation, instantiates mocks and inject them into the bean.
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test get all computer ok.
     */
    @Test
    public final void getAllComputersOk() {
        LOGGER.info("getAllComputersOk...");
        PowerMockito.when(mockComputerDao.findAll()).thenReturn(getComputers());
        Assert.assertTrue(computerService.findAll() instanceof List<?>);
        Assert.assertEquals(computerService.findAll().size(), 2);
    }

    /**
     * Test create computer ok.
     */
    @Test
    public final void createComputerOk() {
        LOGGER.info("createComputerOk...");
        Computer computer = new Computer.Builder("computer1").company(null).introduced(null)
                .discontinued(null).build();
        Mockito.when(mockComputerDao.save(computer)).thenReturn(computer);
        Assert.assertTrue(computerService.create(computer).equals(computer));
    }

    /**
     * Test create computer invalid computer name.
     */
    @Test(expected = InvalidComputerNameException.class)
    public final void createComputerInvalidNameKo() {
        LOGGER.info("createComputerInvalidNameKo...");
        Mockito.when(computer.getComputerName()).thenReturn(null);
        computerService.create(computer);
    }

    @Test(expected = InvalidComputerNameException.class)
    public final void createComputerInvalidNameEmptyKo() {
        LOGGER.info("createComputerInvalidNameKo...");
        Mockito.when(computer.getComputerName()).thenReturn("");
        computerService.create(computer);
    }

    /**
     * Test create computer fail.
     */
    @Test(expected = InvalidDateOrderException.class)
    public final void createComputerInvalidDateOrderKo() {
        LOGGER.info("createComputerInvalidDateOrderKo...");
        Mockito.when(computer.getComputerName()).thenReturn("computer");
        Mockito.when(computer.getDiscontinued()).thenReturn(LocalDate.of(2000, 9, 9));
        Mockito.when(computer.getIntroduced()).thenReturn(LocalDate.now());
        computerService.create(computer);
    }

    /**
     * Test update computer.
     */
    @Test
    public final void updateComputerTestOk() {
        LOGGER.info("updateComputerOk...");
        ArrayList<Computer> computers = getComputers();
        Computer computer1 = new Computer.Builder("updatedComputer").company(null).discontinued(null)
                .introduced(null).build();
        computers.set(1, computer1);
        Mockito.when(mockComputerDao.save(computer1)).thenReturn(computer1);
        Mockito.when(mockComputerDao.findAll()).thenReturn(computers);
        Assert.assertEquals(computerService.findAll().size(), 2);
        Assert.assertTrue(computer1.equals(computers.get(1)));
    }

    /**
     * Return list of computer for test.
     *
     * @return list of computer
     */
    private ArrayList<Computer> getComputers() {
        Computer computer1 = new Computer.Builder("computer1").company(null).discontinued(null)
                .introduced(null).build();
        Computer computer2 = new Computer.Builder("computer2").company(null).discontinued(null)
                .introduced(null).build();
        ArrayList<Computer> computers = new ArrayList<>();
        computers.add(computer1);
        computers.add(computer2);
        return computers;
    }

}
