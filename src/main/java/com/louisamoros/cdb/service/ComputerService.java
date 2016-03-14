package com.louisamoros.cdb.service;

import com.louisamoros.cdb.controller.util.Params;
import com.louisamoros.cdb.model.Computer;

import java.util.List;

/**
 * Computer service interface.
 */
public interface ComputerService {

    /**
     * Count number of computers.
     *
     * @param params the query params to count depending on the search
     * @return number of computers
     */
    int count(Params params);

    /**
     * Get all the computers.
     * @return list of computer
     */
    List<Computer> getAll();

    /**
     * Get filtered computers based on query.
     * @param params the query params
     * @return list of computer
     */
    List<Computer> get(final Params params);

    /**
     * Get computer based on id.
     * @param computerId the computer id
     * @return computer
     */
    Computer get(final int computerId);

    /**
     * Create computer.
     * @param computer the computer
     * @return computer created
     */
    Computer create(final Computer computer);

    /**
     * Update computer.
     * @param computer the computer
     * @return computer updated
     */
    Computer update(final Computer computer);

    /**
     * Delete computer based on id.
     * @param computerId the computer id
     */
    void delete(final int computerId);

}
