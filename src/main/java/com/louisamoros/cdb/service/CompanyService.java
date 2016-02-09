package com.louisamoros.cdb.service;

import java.util.List;

import com.louisamoros.cdb.dao.CompanyDaoImpl;
import com.louisamoros.cdb.dao.DaoFactory;
import com.louisamoros.cdb.model.Company;

/**
 * Company Service used to CRUD companies
 * @author excilys
 *
 */
public class CompanyService {

	CompanyDaoImpl companyDao = null;

	
	public CompanyService() {
		companyDao = DaoFactory.getCompanyDao();
	}
	
	/**
	 * Fetch all companies from the database.
	 * @return companies list
	 */
	public List<Company> getCompanies() {
		return companyDao.getCompanies();
	}

}
