package com.louisamoros.cdb.service.impl;

import com.louisamoros.cdb.dao.CompanyDao;
import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.service.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

  @Autowired
  private CompanyDao companyDao;

  @Autowired
  private ComputerDao computerDao;

  @Override
  public List<Company> getAll() {
    return companyDao.getAll();
  }

  @Override
  public void delete(int companyId) {
    computerDao.deleteByCompanyId(companyId);
    companyDao.delete(companyId);
  }

  @Override
  public void setCompanyDao(CompanyDao companyDao) {
    this.companyDao = companyDao;
  }

}
