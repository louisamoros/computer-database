package com.louisamoros.cdb.service;

import com.louisamoros.cdb.dao.CompanyDao;
import com.louisamoros.cdb.model.Company;

import java.util.List;

public interface CompanyService {

  List<Company> getAll();

  void delete(int companyId);

  void setCompanyDao(CompanyDao companyDao);

}
