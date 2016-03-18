package com.louisamoros.cdb.dao;

import com.louisamoros.cdb.model.Computer;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Interface CompanyDao.
 */
@Repository
public interface ComputerDao extends QueryDslPredicateExecutor<Computer> {

}
