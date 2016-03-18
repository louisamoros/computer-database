package com.louisamoros.cdb.dao;

import com.louisamoros.cdb.model.Company;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface CompanyDao.
 */
public interface CompanyDao extends CrudRepository<Company, Long>, QueryDslPredicateExecutor<Company> {

}
