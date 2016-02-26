package com.louisamoros.cdb.utest;

import com.louisamoros.cdb.dao.CompanyDao;
import com.louisamoros.cdb.dao.impl.CompanyDaoImpl;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.service.CompanyService;
import com.louisamoros.cdb.service.impl.CompanyServiceImpl;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class CompanyServiceTest.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(CompanyDaoImpl.class)
public class CompanyServiceTest {

  private static Logger LOGGER = LoggerFactory.getLogger(CompanyServiceTest.class);
  private static CompanyDao mockCompanyDao;
  private static CompanyService companyService;

  /**
   * Inits the.
   */
  @BeforeClass
  public static void init() {
    LOGGER.debug("Init mocking companyDao...");
    mockCompanyDao = PowerMockito.mock(CompanyDaoImpl.class);
    companyService = CompanyServiceImpl.INSTANCE;
    companyService.setCompanyDao(mockCompanyDao);
  }

  /**
   * Gets the all companies test.
   *
   * @return the all companies test
   */
  @Test
  public void getAllCompaniesTest() {
    LOGGER.debug("getAllCompaniesTest...");
    PowerMockito.when(mockCompanyDao.getAll()).thenReturn(new ArrayList<Company>());
    Assert.assertTrue(companyService.getAll() instanceof List<?>);
  }

}