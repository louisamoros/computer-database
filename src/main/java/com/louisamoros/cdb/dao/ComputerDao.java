package com.louisamoros.cdb.dao;

import com.louisamoros.cdb.controller.util.Params;
import com.louisamoros.cdb.model.Computer;

import java.util.List;

/**
 * Interface ComputerDao.
 */
public interface ComputerDao {

    /**
     * Count number of computers.
     *
     * @param params the query params to count depending on the search
     * @return number of computers.
     */
    int count(Params params);

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
     * @param params the query parameters object
     * @return list of computers
     */
    List<Computer> get(Params params);

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
    Computer create(Computer computer);

    /**
     * Update computer.
     *
     * @param computer the computer
     * @return id of updated computer
     */
    Computer update(Computer computer);

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
