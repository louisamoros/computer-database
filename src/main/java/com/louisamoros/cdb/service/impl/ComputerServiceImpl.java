package com.louisamoros.cdb.service.impl;

import com.louisamoros.cdb.controller.util.QueryParams;
import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.ComputerService;
import com.louisamoros.cdb.service.validator.ComputerValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ComputerServiceImpl implements ComputerService {

  @Autowired
  private ComputerDao computerDao;

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
