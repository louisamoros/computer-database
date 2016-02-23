package com.louisamoros.cdb.service;

import com.louisamoros.cdb.controller.util.QueryParams;
import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.model.Computer;

import java.util.List;

/**
 * The Interface ComputerService.
 */
public interface ComputerService {

  /**
   * Count.
   *
   * @return the int
   */
  int count();

  List<Computer> getAll();

  /**
   * Get.
   *
   * @param qp the qp
   * @return the list
   */
  List<Computer> get(QueryParams qp);

  /**
   * Get.
   *
   * @param computerId the computer id
   * @return the computer
   */
  Computer get(int computerId);

  /**
   * Creates the.
   *
   * @param computer the computer
   * @return the int
   */
  int create(Computer computer);

  /**
   * Update.
   *
   * @param computer the computer
   * @return the int
   */
  int update(Computer computer);

  /**
   * Delete.
   *
   * @param computerId the computer id
   */
  void delete(int computerId);

  void setComputerDao(ComputerDao computerDao);

}