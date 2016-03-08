package com.louisamoros.cdb.service;

import com.louisamoros.cdb.controller.util.QueryParams;
import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.model.Computer;

import java.util.List;

/**
 * Computer service interface.
 */
public interface ComputerService {

    /**
     * Count number of computers.
     *
     * @return number of computers
     */
    int count();

    /**
     * Get all the computers.
     * @return list of computer
     */
    List<Computer> getAll();

    /**
     * Get filtered computers based on query.
     * @param qp
     * @return list of computer
     */
    List<Computer> get(final QueryParams qp);

    /**
     * Get computer based on id.
     * @param computerId
     * @return computer
     */
    Computer get(final int computerId);

    /**
     * Create computer.
     * @param computer
     * @return computer created id
     */
    int create(final Computer computer);

    /**
     * Update computer.
     * @param computer
     * @return computer update id
     */
    int update(final Computer computer);

    /**
     * Delete computer based on id.
     * @param computerId
     */
    void delete(final int computerId);

}