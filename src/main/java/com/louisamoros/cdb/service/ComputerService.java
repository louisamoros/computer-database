package com.louisamoros.cdb.service;

import com.louisamoros.cdb.controller.util.Params;
import com.louisamoros.cdb.model.Computer;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Computer service interface.
 */
public interface ComputerService {

    /**
     * Get all the computers.
     * @return list of computer
     */
    List<Computer> findAll();

    /**
     * Get filtered computers based on query.
     * @param params the query params
     * @return list of computer
     */
    Page<Computer> findAll(final Params params);

    /**
     * Get computer based on id.
     * @param computerId the computer id
     * @return computer
     */
    Computer findOne(final long computerId);

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
    void delete(final long computerId);

}
