package com.louisamoros.cdb.dao;

import com.louisamoros.cdb.model.Computer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;

/**
 * Testing dao class for computer.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:persistence-context.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UTComputerDaoTest {

    /**
     * Logger of the class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UTComputerDaoTest.class);

    @Autowired
    ComputerDao computerDao;

    @Test
    public final void deleteComputerOk() {
        LOGGER.info("deleteComputerOk...");
        computerDao.delete((long) 1);
        List<Computer> computers = (List<Computer>) computerDao.findAll();
        Assert.assertEquals(24, computers.size());
    }

    @Test
    public final void findAllOk() {
        LOGGER.info("findAllOk...");
        List<Computer> computers = (List<Computer>) computerDao.findAll();
        Assert.assertEquals(25, computers.size());
    }

    @Test
    public final void findAllPageOk() {
        LOGGER.info("findAllPageOk...");
        Pageable pageRequest = new PageRequest(1, 10);
        Page<Computer> page = computerDao.findAll(null, pageRequest);
        Assert.assertEquals(10, page.getContent().size());
        Assert.assertEquals(25, page.getTotalElements());
        Assert.assertEquals(3, page.getTotalPages());
    }

    @Test
    public final void createOk() {
        LOGGER.info("createOk...");
        Computer computer = new Computer.Builder("computer").build();
        computerDao.save(computer);
        List<Computer> computers = (List<Computer>) computerDao.findAll();
        Assert.assertEquals(26, computers.size());
        Assert.assertEquals(computers.get(25).getComputerName(), "computer");
    }

    @Test
    public final void updateOk() {
        LOGGER.info("updateOk...");
        Computer computer = new Computer.Builder("computer-bis").id((long) 25).build();
        computerDao.save(computer);
        List<Computer> computers = (List<Computer>) computerDao.findAll();
        Assert.assertEquals(25, computers.size());
        Assert.assertEquals(computers.get(24).getComputerName(), "computer-bis");
    }

}
