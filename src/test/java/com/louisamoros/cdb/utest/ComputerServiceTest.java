// package com.louisamoros.cdb.utest;
//
// import com.louisamoros.cdb.dao.ComputerDao;
// import com.louisamoros.cdb.exception.InvalidComputerNameException;
// import com.louisamoros.cdb.exception.InvalidDateOrderException;
// import com.louisamoros.cdb.model.Computer;
// import com.louisamoros.cdb.service.ComputerService;
//
// import org.junit.Assert;
// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.Mockito;
// import org.mockito.MockitoAnnotations;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;
//
/// **
// * Computer service test class.
// */
// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration("classpath:test-mvc-application-context.xml")
// public class ComputerServiceTest {
//
// /**
// * Logger of the class.
// */
// private static final Logger LOGGER = LoggerFactory.getLogger(ComputerServiceTest.class);
//
// /**
// * Spring injection of a mock for test.
// */
// @Mock
// private ComputerDao mockComputerDao;
//
// /**
// * Autowired spring injection object after mock.
// */
// @InjectMocks
// @Autowired
// private ComputerService computerService;
//
// /**
// * Mock spring beans.
// */
// @Before
// public final void init() {
// LOGGER.info("Initialize mocks [mockComputerDao]...");
// // scans the class annotation, instantiates mocks and inject them into the bean.
// MockitoAnnotations.initMocks(this);
// }
//
// /**
// * Test get all computer ok.
// */
// @Test
// public final void getAllComputersOk() {
// LOGGER.info("getAllComputersOk...");
// Mockito.when(mockComputerDao.getAll()).thenReturn(getComputers());
// Assert.assertTrue(computerService.getAll() instanceof List<?>);
// Assert.assertEquals(computerService.getAll().size(), 2);
// }
//
// /**
// * Test create computer ok.
// */
// @Test
// public final void createComputerOk() {
// LOGGER.info("createComputerOk...");
// Computer computer1 = new Computer.Builder("computer1").company(null).introduced(null)
// .discontinued(null).build();
// Mockito.when(mockComputerDao.create(computer1)).thenReturn(computer1);
// Assert.assertTrue(computerService.create(computer1).equals(computer1));
// }
//
// /**
// * Test create computer invalid computer name.
// */
// @Test(expected = InvalidComputerNameException.class)
// public final void createComputerInvalidNameKo() {
// LOGGER.info("createComputerInvalidNameKo...");
// Computer computer1 = new Computer.Builder(null).company(null).discontinued(null)
// .introduced(null).build();
// computerService.create(computer1);
// }
//
// /**
// * Test create computer fail.
// */
// @Test(expected = InvalidDateOrderException.class)
// public final void createComputerInvalidDateOrderKo() {
// LOGGER.info("createComputerInvalidDateOrderKo...");
// Computer computer1 = new Computer.Builder("computer1").company(null)
// .discontinued(LocalDate.of(2000, 9, 9)).introduced(LocalDate.now()).build();
// computerService.create(computer1);
// }
//
// /**
// * Test delete computer.
// */
// @Test
// public final void deleteComputerOk() {
// LOGGER.info("deleteComputerOk...");
// ArrayList<Computer> computers = getComputers();
// computers.remove(1);
// mockComputerDao.delete(1);
// Mockito.when(mockComputerDao.getAll()).thenReturn(computers);
// Assert.assertEquals(computerService.getAll().size(), 1);
// }
//
// /**
// * Test update computer.
// */
// @Test
// public final void updateComputerTestOk() {
// LOGGER.info("updateComputerOk...");
// ArrayList<Computer> computers = getComputers();
// Computer computer1 = new Computer.Builder("updatedComputer").company(null).discontinued(null)
// .introduced(null).build();
// computers.set(1, computer1);
// Mockito.when(mockComputerDao.update(computer1)).thenReturn(computer1);
// Mockito.when(mockComputerDao.getAll()).thenReturn(computers);
// Assert.assertEquals(computerService.getAll().size(), 2);
// Assert.assertTrue(computer1.equals(computers.get(1)));
// }
//
// /**
// * Return list of computer for test.
// * @return list of computer
// */
// private ArrayList<Computer> getComputers() {
// Computer computer1 = new Computer.Builder("computer1").company(null).discontinued(null)
// .introduced(null).build();
// Computer computer2 = new Computer.Builder("computer2").company(null).discontinued(null)
// .introduced(null).build();
// ArrayList<Computer> computers = new ArrayList<>();
// computers.add(computer1);
// computers.add(computer2);
// return computers;
// }
//
// }
