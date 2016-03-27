package com.louisamoros.cdb.service;

import com.louisamoros.cdb.dao.CompanyDao;
import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.service.impl.CompanyServiceImpl;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Company service class test.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:service-context.xml")
public class UTCompanyServiceTest {

    /**
     * Logger of the class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UTCompanyServiceTest.class);

    @Mock
    private CompanyDao mockCompanyDao;

    @Mock
    private ComputerDao mockComputerDao;

    @InjectMocks
    private final CompanyService companyService = new CompanyServiceImpl();

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
        Mockito.when(mockCompanyDao.findAll()).thenReturn(getCompanies());
        List<Company> companies = companyService.findAll();
        LOGGER.info(companies.toString());
        Assert.assertEquals(3, companies.size());
    }

    /**
     * Get companies method for test.
     *
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
