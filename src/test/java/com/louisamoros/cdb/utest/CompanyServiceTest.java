package com.louisamoros.cdb.utest;

import com.louisamoros.cdb.dao.CompanyDao;
import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.service.CompanyService;

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

import java.util.ArrayList;
import java.util.List;

/**
 * Company service test.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-mvc-application-context.xml")
public class CompanyServiceTest {

  /**
   * Logger of the class.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(CompanyServiceTest.class);

  /**
   * Spring injection of company dao mock.
   */
  @Mock
  private CompanyDao mockCompanyDao;

  /**
   * Spring injection of computer dao mock.
   */
  @Mock
  private ComputerDao mockComputerDao;

  /**
   * Autowired spring injection company service after mocks.
   */
  @InjectMocks
  @Autowired
  private CompanyService companyService;

  /**
   * Initialize mocks.
   */
  @Before
  public final void setUp() {
    LOGGER.info("Initialize mocks [mockCompanyDao][mockComputerDao]...");
    // scans the class annotation, instantiates mocks and inject them into the bean.
    MockitoAnnotations.initMocks(this);
  }

  /**
   * Gets all companies test.
   */
  @Test
  public final void getAllCompaniesOk() {
    LOGGER.info("getAllCompaniesOk...");
    Mockito.when(mockCompanyDao.getAll()).thenReturn(getCompanies());
    Assert.assertTrue(companyService.getAll().size() == 3);
  }

  /**
   * Get companies method for test.
   * @return companies the list of company
   */
  private List<Company> getCompanies() {
    List<Company> companies = new ArrayList<>();
    Company company = new Company.Builder().name("company1").id(1).build();
    companies.add(company);
    company = new Company.Builder().name("company2").id(2).build();
    companies.add(company);
    company = new Company.Builder().name("company3").id(3).build();
    companies.add(company);
    return companies;
  }

}
