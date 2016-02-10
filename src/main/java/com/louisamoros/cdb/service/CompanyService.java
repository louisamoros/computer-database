package com.louisamoros.cdb.service;

import java.util.List;

import com.louisamoros.cdb.dao.CompanyDao;
import com.louisamoros.cdb.dao.impl.CompanyDaoImpl;
import com.louisamoros.cdb.model.Company;

/**
 * Company Service used to CRUD companies and verify inputs.
 * @author excilys
 *
 */
public enum CompanyService {

	INSTANCE;
	
	private CompanyDao companyDao = null;

	private CompanyService() {
		companyDao = CompanyDaoImpl.INSTANCE;
	}
	
	/**
	 * Fetch all companies from the database.
	 * @return companies list
	 */
	public List<Company> getCompanies() {
		return companyDao.getCompanies();
	}

}
