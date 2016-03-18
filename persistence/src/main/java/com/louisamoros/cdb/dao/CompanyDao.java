package com.louisamoros.cdb.dao;

import com.louisamoros.cdb.model.Company;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Interface CompanyDao.
 */
@Repository
public interface CompanyDao extends QueryDslPredicateExecutor<Company> {

}
