package com.louisamoros.cdb.service.validator;

import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.service.exception.IntegrityException;

import java.util.List;

/**
 * Company model validator class.
 */
public final class CompanyValidator {

  /**
   * Company validator constructor.
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
      throw new IntegrityException("Company cannot be null validation says.");
    }
    if (company.getCompanyId() < 0) {
      throw new IntegrityException("Company id cannot be negative.");
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
