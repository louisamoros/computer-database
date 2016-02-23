package com.louisamoros.cdb.service;

import com.louisamoros.cdb.dao.CompanyDao;
import com.louisamoros.cdb.model.Company;

import java.util.List;

/**
 * The Interface CompanyService.
 */
public interface CompanyService {

  List<Company> getAll();

  void setCompanyDao(CompanyDao companyDao);

}
