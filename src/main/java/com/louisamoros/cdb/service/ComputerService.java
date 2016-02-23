package com.louisamoros.cdb.service;

import com.louisamoros.cdb.controller.util.QueryParams;
import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.model.Computer;

import java.util.List;

public interface ComputerService {

  int count();

  List<Computer> getAll();

  List<Computer> get(QueryParams qp);

  Computer get(int computerId);

  int create(Computer computer);

  int update(Computer computer);

  void delete(int computerId);

  void setComputerDao(ComputerDao computerDao);

}