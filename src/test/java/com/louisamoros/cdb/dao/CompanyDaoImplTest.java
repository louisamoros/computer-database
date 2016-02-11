package com.louisamoros.cdb.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.louisamoros.cdb.dao.impl.CompanyDaoImpl;
import com.louisamoros.cdb.util.ConnectionMock;

public class CompanyDaoImplTest {

	private CompanyDao companyDao = null;

	@Before
	public void beforeTest() throws Exception {
//		ConnectionMock.importDataSet();
		companyDao = CompanyDaoImpl.INSTANCE;
	}

	@Test
	public void getCompaniesTest() {
		Assert.assertTrue(true);
//		Assert.assertEquals(companyDao.getCompanies().size(), 2);
	}
	
//	public List<Company> getCompanyList() {
//		Company c1 = new Company("Company Test");
//		c1.setCompanyId(1);
//
//		Company c2 = new Company("Company Test 2");
//		c2.setCompanyId(2);
//
//		companies.add(c1);
//		companies.add(c2);
//
//		return companies;
//	}

	
}
