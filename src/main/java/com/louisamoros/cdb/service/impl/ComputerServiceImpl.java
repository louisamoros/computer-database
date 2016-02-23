package com.louisamoros.cdb.service.impl;

import com.louisamoros.cdb.controller.util.QueryParams;
import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.dao.impl.ComputerDaoImpl;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.ComputerService;
import com.louisamoros.cdb.service.validator.ComputerValidator;

import java.util.List;

/**
 * The Enum ComputerServiceImpl.
 */
public enum ComputerServiceImpl implements ComputerService {

  INSTANCE;

  private ComputerDao computerDao;

  /**
   * Instantiates a new computer service impl.
   */
  ComputerServiceImpl() {
    computerDao = ComputerDaoImpl.INSTANCE;
  }

  @Override
  public List<Computer> getAll() {
    return computerDao.getAll();
  }

  @Override
  public Computer get(int computerId) {
    return computerDao.get(computerId);
  }

  @Override
  public List<Computer> get(QueryParams qp) {
    return computerDao.get(qp);
  }

  @Override
  public int create(Computer computer) {
    ComputerValidator.validate(computer);
    return computerDao.create(computer);
  }

  @Override
  public int update(Computer computer) {
    ComputerValidator.validate(computer);
    return computerDao.update(computer);
  }

  @Override
  public void delete(int computerId) {
    computerDao.delete(computerId);
  }

  @Override
  public int count() {
    return computerDao.count();
  }

  @Override
  public void setComputerDao(ComputerDao computerDao) {
    this.computerDao = computerDao;
  }

}
