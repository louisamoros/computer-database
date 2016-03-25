package com.louisamoros.cdb.dao;

import com.louisamoros.cdb.dmo.ComputerDmo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Interface CompanyDao.
 */
public interface ComputerDao {

    /**
     * Get all computers.
     * @return list of computers
     */
    List<ComputerDmo> findAll();

    /**
     * Create computer.
     * @param computerDmo the computer
     * @return created computer
     */
    ComputerDmo create(final ComputerDmo computerDmo);

    /**
     * Delete computer.
     * @param id the computer id
     */
    void delete(final long id);

    /**
     * Get computer.
     * @param id the computer id
     * @return computer
     */
    ComputerDmo findOne(final long id);

    /**
     * Get computers based on search and page params.
     * @param search the search filter
     * @param pageRequest the page requested
     * @return page of computers
     */
    Page<ComputerDmo> findAll(final String search, Pageable pageRequest);

}
