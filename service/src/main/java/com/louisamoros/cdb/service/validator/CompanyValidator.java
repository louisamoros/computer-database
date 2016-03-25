package com.louisamoros.cdb.service.validator;

import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.service.exception.IntegrityException;

import java.util.List;

/**
 * CompanyDmo model validator class.
 */
public final class CompanyValidator {

  /**
   * CompanyDmo validator constructor.
   */
  private CompanyValidator() {
    super();
  }

  /**
   * Validation method of a company.
   * @param company the company
   */
  public static void validate(final Company company) {

    if (company == null) {
      throw new IntegrityException("CompanyDmo cannot be null validation says.");
    }
    if (company.getId() < 0) {
      throw new IntegrityException("CompanyDmo id cannot be negative.");
    }

  }

  /**
   * Validation method of a company list.
   *
   * @param companies the companies
   */
  public static void validate(final List<Company> companies) {

    companies.forEach(company -> validate(company));

  }

}
