package com.louisamoros.cdb.utest;

import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.exception.InvalidComputerNameException;
import com.louisamoros.cdb.exception.InvalidDateOrderException;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.ComputerService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-application-context.xml")
public class ComputerServiceTest {

  private static Logger LOGGER = LoggerFactory.getLogger(ComputerServiceTest.class);

  @Mock
  private ComputerDao mockComputerDao;

  @InjectMocks
  @Autowired
  private ComputerService computerService;

  /**
   * Inits the.
   */
  @Before
  public void init() {
    LOGGER.info("Initialize mocks [mockComputerDao]...");
    // scans the class annotation, instantiates mocks and inject them into the bean.
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void getAllComputersOk() {
    LOGGER.info("getAllComputersOk...");
    Mockito.when(mockComputerDao.getAll()).thenReturn(getComputers());
    Assert.assertTrue(computerService.getAll() instanceof List<?>);
    Assert.assertEquals(computerService.getAll().size(), 2);
  }

  @Test
  public void createComputerOk() {
    LOGGER.info("createComputerOk...");
    Computer computer1 = new Computer.Builder("computer1").company(null).introduced(null)
        .discontinued(null).build();
    Mockito.when(mockComputerDao.create(computer1)).thenReturn(1);
    int createdComputerId = computerService.create(computer1);
    Assert.assertTrue(createdComputerId == 1);
  }

  @Test(expected = InvalidComputerNameException.class)
  public void createComputerInvalidNameKo() {
    LOGGER.info("createComputerInvalidNameKo...");
    Computer computer1 = new Computer.Builder(null).company(null).discontinued(null)
        .introduced(null).build();
    computerService.create(computer1);
  }

  @Test(expected = InvalidDateOrderException.class)
  public void createComputerInvalidDateOrderKo() {
    LOGGER.info("createComputerInvalidDateOrderKo...");
    Computer computer1 = new Computer.Builder("computer1").company(null)
        .discontinued(LocalDate.of(2000, 9, 9)).introduced(LocalDate.now()).build();
    computerService.create(computer1);
  }

  @Test
  public void deleteComputerOk() {
    LOGGER.info("deleteComputerOk...");
    ArrayList<Computer> computers = getComputers();
    computers.remove(1);
    mockComputerDao.delete(1);
    Mockito.when(mockComputerDao.getAll()).thenReturn(computers);
    Assert.assertEquals(computerService.getAll().size(), 1);
  }

  @Test
  public void updateComputerTestOk() {
    LOGGER.info("updateComputerOk...");
    ArrayList<Computer> computers = getComputers();
    Computer computer1 = new Computer.Builder("updatedComputer").company(null).discontinued(null)
        .introduced(null).build();
    computers.set(1, computer1);
    Mockito.when(mockComputerDao.update(computer1)).thenReturn(computer1.getId());
    Mockito.when(mockComputerDao.getAll()).thenReturn(computers);
    Assert.assertEquals(computerService.getAll().size(), 2);
    Assert.assertTrue(computer1.equals(computers.get(1)));
  }

  private ArrayList<Computer> getComputers() {
    Computer computer1 = new Computer.Builder("computer1").company(null).discontinued(null)
        .introduced(null).build();
    Computer computer2 = new Computer.Builder("computer2").company(null).discontinued(null)
        .introduced(null).build();
    ArrayList<Computer> computers = new ArrayList<Computer>();
    computers.add(computer1);
    computers.add(computer2);
    return computers;
  }

}
