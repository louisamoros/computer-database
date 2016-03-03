package com.louisamoros.cdb.dao;

import com.louisamoros.cdb.model.Company;

import java.util.List;

public interface CompanyDao {

  List<Company> getAll();

  void delete(int companyId);

}
