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
     * @param queryParams the query params to count depending on the search
     * @return number of computers.
     */
    int count(QueryParams queryParams);

    /**
     * Get computer based on its id.
     *
     * @param computerId the computer id
     * @return computer
     */
    Computer get(int computerId);

    /**
     * Get computers filtering by query params.
     *
     * @param queryParams the query parameters object
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
     * @param computer the computer
     * @return id of created computer
     */
    int create(Computer computer);

    /**
     * Update computer.
     *
     * @param computer the computer
     * @return id of updated computer
     */
    int update(Computer computer);

    /**
     * Delete all computers related to the company id.
     *
     * @param companyId the company id
     */
    void deleteByCompanyId(int companyId);

    /**
     * Delete computer based on its id.
     *
     * @param computerId the computer id
     */
    void delete(int computerId);

}
