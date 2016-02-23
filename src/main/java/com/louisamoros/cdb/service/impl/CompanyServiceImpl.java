package com.louisamoros.cdb.service.impl;

import com.louisamoros.cdb.dao.CompanyDao;
import com.louisamoros.cdb.dao.impl.CompanyDaoImpl;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.service.CompanyService;

import java.util.List;

/**
 * Company Service used to CRUD companies and verify inputs.
 * 
 * @author louis
 *
 */
public enum CompanyServiceImpl implements CompanyService {

  INSTANCE;

  private CompanyDao companyDao;

  private CompanyServiceImpl() {
    companyDao = CompanyDaoImpl.INSTANCE;
  }

  @Override
  public List<Company> getAll() {
    return companyDao.getAll();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.louisamoros.cdb.service.CompanyService#setCompanyDao(com.louisamoros.cdb.dao.CompanyDao)
   */
  @Override
  public void setCompanyDao(CompanyDao companyDao) {
    this.companyDao = companyDao;
  }

}
