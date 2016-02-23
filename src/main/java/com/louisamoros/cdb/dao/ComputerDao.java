package com.louisamoros.cdb.dao;

import com.louisamoros.cdb.controller.util.QueryParams;
import com.louisamoros.cdb.dao.exception.DaoException;
import com.louisamoros.cdb.model.Computer;

import java.util.List;

/**
 * The Interface ComputerDao.
 */
public interface ComputerDao {

  /**
   * Count.
   *
   * @return the int
   * @throws DaoException the dao exception
   */
  int count() throws DaoException;

  /**
   * Get.
   *
   * @param computerId the computer id
   * @return the computer
   * @throws DaoException the dao exception
   */
  Computer get(int computerId) throws DaoException;

  /**
   * Fetch all computers from the database.
   * @return <List> of <Computer>
   * @throws DaoException
   */
  List<Computer> getAll() throws DaoException;

  /**
   * Get.
   *
   * @param qp the qp
   * @return the list
   * @throws DaoException the dao exception
   */
  List<Computer> get(QueryParams qp) throws DaoException;


  /**
   * Creates the.
   *
   * @param computer the computer
   * @return the int
   * @throws DaoException the dao exception
   */
  int create(Computer computer) throws DaoException;

  /**
   * Update.
   *
   * @param computer the computer
   * @return the int
   * @throws DaoException the dao exception
   */
  int update(Computer computer) throws DaoException;

  /**
   * Delete.
   *
   * @param computerId the computer id
   * @throws DaoException the dao exception
   */
  void delete(int computerId) throws DaoException;

}
