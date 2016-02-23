package com.louisamoros.cdb.service.validator;

import com.louisamoros.cdb.exception.IntegrityException;
import com.louisamoros.cdb.model.Company;

import java.util.List;

public class CompanyValidator {

  /**
   * Validate.
   *
   * @param company the company
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
