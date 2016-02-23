package com.louisamoros.cdb.service.impl;

import com.louisamoros.cdb.dao.CompanyDao;
import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.dao.impl.CompanyDaoImpl;
import com.louisamoros.cdb.dao.impl.ComputerDaoImpl;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.service.CompanyService;
import com.louisamoros.cdb.service.util.TransactionManagerImpl;

import java.util.List;

public enum CompanyServiceImpl implements CompanyService {

  INSTANCE;

  private CompanyDao companyDao;
  private TransactionManagerImpl transactionManager;
  private ComputerDao computerDao;

  private CompanyServiceImpl() {
    companyDao = CompanyDaoImpl.INSTANCE;
    transactionManager = TransactionManagerImpl.INSTANCE;
    computerDao = ComputerDaoImpl.INSTANCE;
  }

  @Override
  public List<Company> getAll() {
    return companyDao.getAll();
  }

  @Override
  public void delete(int companyId) {

    transactionManager.startTransaction();

    // delete related computers
    computerDao.deleteByCompanyId(companyId);

    // delete company
    companyDao.delete(companyId);

    transactionManager.commitTransaction();
    transactionManager.endTransaction();

  }

  @Override
  public void setCompanyDao(CompanyDao companyDao) {
    this.companyDao = companyDao;
  }

}
