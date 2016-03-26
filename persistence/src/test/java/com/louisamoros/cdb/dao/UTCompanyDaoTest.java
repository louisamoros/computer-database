package com.louisamoros.cdb.dao;

import com.louisamoros.cdb.model.Company;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Testing dao class for company.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:persistence-context.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UTCompanyDaoTest {

    /**
     * Logger of the class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UTComputerDaoTest.class);

    @Autowired
    CompanyDao companyDao;

    @Test
    public final void findAllOk() {
        LOGGER.info("findAllOk...");
        List<Company> companies = (List<Company>) companyDao.findAll();
        Assert.assertEquals(14, companies.size());
    }

}
