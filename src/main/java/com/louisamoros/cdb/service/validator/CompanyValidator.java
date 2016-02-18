package com.louisamoros.cdb.service.validator;

import java.util.List;

import com.louisamoros.cdb.exception.IntegrityException;
import com.louisamoros.cdb.model.Company;

/**
 * Verication class for a company or a list of company.
 * 
 * @author louis
 *
 */
public class CompanyValidator {

	/**
	 * Verify company object and throw runtime exception if anything wrong.
	 * 
	 * @param <Company>
	 */
	public static void validate(Company company) {

		if (company == null) {
			throw new IntegrityException("Company cannot be null validation says.");
		}
		if (company.getId() < 0) {
			throw new IntegrityException("Company id cannot be negative.");
		}

	}

	/**
	 * Validate.
	 *
	 * @param companies the companies
	 */
	public static void validate(List<Company> companies) {

		for (Company company : companies) {
			validate(company);
		}

	}

}
