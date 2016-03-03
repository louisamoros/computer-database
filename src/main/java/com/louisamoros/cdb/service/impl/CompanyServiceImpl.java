package com.louisamoros.cdb.service.impl;

import com.louisamoros.cdb.dao.CompanyDao;
import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.service.CompanyService;
import com.louisamoros.cdb.service.util.TransactionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

  @Autowired
  private CompanyDao companyDao;

  @Autowired
  private TransactionManager transactionManager;

  @Autowired
  private ComputerDao computerDao;

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
