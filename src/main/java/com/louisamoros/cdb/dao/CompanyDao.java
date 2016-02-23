package com.louisamoros.cdb.dao;

import com.louisamoros.cdb.model.Company;

import java.util.List;

/**
 * The Interface CompanyDao.
 */
public interface CompanyDao {

  List<Company> getAll();

  void delete(int companyId);

}
