package com.louisamoros.cdb.utest;

import com.louisamoros.cdb.dao.CompanyDao;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.service.CompanyService;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class CompanyServiceTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-application-context.xml")
public class CompanyServiceTest {

  private static Logger LOGGER = LoggerFactory.getLogger(CompanyServiceTest.class);

  @Autowired
  private static CompanyDao mockCompanyDao;

  @Autowired
  private static CompanyService companyService;

  /**
   * Inits the.
   */
  @BeforeClass
  public static void init() {
    LOGGER.info("Init mocking companyDao...");
    companyService.setCompanyDao(mockCompanyDao);
  }

  /**
   * Gets the all companies test.
   *
   * @return the all companies test
   */
  @Test
  public void getAllCompaniesTest() {
    LOGGER.info("getAllCompaniesTest...");
    Mockito.when(mockCompanyDao.getAll()).thenReturn(new ArrayList<Company>());
    Assert.assertTrue(companyService.getAll() instanceof List<?>);
  }

}
