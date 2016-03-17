package com.louisamoros.cdb;

import com.louisamoros.cdb.model.Company;

import java.util.List;

/**
 * Company service interface.
 */
public interface CompanyService {

  /**
   * Get all companies.
   *
   * @return list of company
   */
  List<Company> getAll();

  /**
   * Delete company and computer related.
   *
   * @param companyId the company id
   */
  void delete(final int companyId);

}
