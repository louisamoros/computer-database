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

  Computer get(int computerId) throws DaoException;

  List<Computer> get(QueryParams qp) throws DaoException;

  List<Computer> getAll() throws DaoException;

  int create(Computer computer) throws DaoException;

  int update(Computer computer) throws DaoException;

  void delete(int computerId) throws DaoException;

}
