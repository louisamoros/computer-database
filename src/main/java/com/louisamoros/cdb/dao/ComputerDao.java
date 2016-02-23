package com.louisamoros.cdb.dao;

import com.louisamoros.cdb.controller.util.QueryParams;
import com.louisamoros.cdb.dao.exception.DaoException;
import com.louisamoros.cdb.model.Computer;

import java.util.List;

/**
 * The Interface ComputerDao.
 */
public interface ComputerDao {

  int count() throws DaoException;

  Computer get(int computerId);

  List<Computer> get(QueryParams qp);

  List<Computer> getAll();

  int create(Computer computer);

  int update(Computer computer);

  void deleteByCompanyId(int companyId);

  void delete(int computerId) throws DaoException;

}
