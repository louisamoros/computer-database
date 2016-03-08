package com.louisamoros.cdb.dao;

import com.louisamoros.cdb.controller.util.QueryParams;
import com.louisamoros.cdb.model.Computer;

import java.util.List;

/**
 * Interface ComputerDao.
 */
public interface ComputerDao {

    /**
     * Count number of computers.
     *
     * @return number of computers.
     */
    int count();

    /**
     * Get computer based on its id.
     *
     * @param computerId
     * @return computer
     */
    Computer get(int computerId);

    /**
     * Get computers filtering by query params.
     *
     * @param queryParams
     * @return list of computers
     */
    List<Computer> get(QueryParams queryParams);

    /**
     * Get all computers.
     *
     * @return list of computers
     */
    List<Computer> getAll();

    /**
     * Create computer.
     *
     * @param computer
     * @return id of created computer
     */
    int create(Computer computer);

    /**
     * Update computer.
     *
     * @param computer
     * @return id of updated computer
     */
    int update(Computer computer);

    /**
     * Delete all computers related to the company id.
     *
     * @param companyId
     */
    void deleteByCompanyId(int companyId);

    /**
     * Delete computer based on its id.
     *
     * @param computerId
     */
    void delete(int computerId);

}
