package com.louisamoros.cdb.dao;

import com.louisamoros.cdb.model.Company;

import java.util.List;

/**
 * Interface CompanyDao.
 */
public interface CompanyDao {

    /**
     * Get all companies.
     *
     * @return list of companies
     */
    List<Company> getAll();

    /**
     * Delete a company based on its id.
     *
     * @param companyId the company id
     */
    void delete(int companyId);

}
