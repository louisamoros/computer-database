package com.louisamoros.cdb.service;

import com.louisamoros.cdb.controller.util.QueryParams;
import com.louisamoros.cdb.model.Computer;

import java.util.List;

/**
 * Computer service interface.
 */
public interface ComputerService {

    /**
     * Count number of computers.
     *
     * @param queryParams the query params to count depending on the search
     * @return number of computers
     */
    int count(QueryParams queryParams);

    /**
     * Get all the computers.
     * @return list of computer
     */
    List<Computer> getAll();

    /**
     * Get filtered computers based on query.
     * @param qp the query params
     * @return list of computer
     */
    List<Computer> get(final QueryParams qp);

    /**
     * Get computer based on id.
     * @param computerId the computer id
     * @return computer
     */
    Computer get(final int computerId);

    /**
     * Create computer.
     * @param computer the computer
     * @return computer created id
     */
    int create(final Computer computer);

    /**
     * Update computer.
     * @param computer the computer
     * @return computer update id
     */
    int update(final Computer computer);

    /**
     * Delete computer based on id.
     * @param computerId the computer id
     */
    void delete(final int computerId);

}
