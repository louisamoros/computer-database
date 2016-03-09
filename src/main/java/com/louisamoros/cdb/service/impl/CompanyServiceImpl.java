package com.louisamoros.cdb.service.impl;

import com.louisamoros.cdb.dao.CompanyDao;
import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.service.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Spring service using transactional in some request.
 */
@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

  /**
   * Autowired spring injection of company dao.
   */
  @Autowired
  private CompanyDao companyDao;

  /**
   * Autowired spring injection of computer dao.
   */
  @Autowired
  private ComputerDao computerDao;

  @Override
  public final List<Company> getAll() {
    return companyDao.getAll();
  }

  @Override
  @Transactional
  public final void delete(final int companyId) {
    computerDao.deleteByCompanyId(companyId);
    companyDao.delete(companyId);
  }

}
