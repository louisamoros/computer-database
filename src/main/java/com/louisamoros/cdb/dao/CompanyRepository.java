package com.louisamoros.cdb.dao;

import com.louisamoros.cdb.model.Company;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface CompanyDao.
 */
@Repository
public interface CompanyRepository
        extends CrudRepository<Company, Long>, QueryDslPredicateExecutor<Company> {

}
