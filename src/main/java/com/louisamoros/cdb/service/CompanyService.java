package com.louisamoros.cdb.service;

import java.util.List;

import com.louisamoros.cdb.model.Company;

public interface CompanyService {

	/**
	 * Fetch all companies from dao company.
	 * @return companies list
	 */
	List<Company> getCompanies();
	
}
