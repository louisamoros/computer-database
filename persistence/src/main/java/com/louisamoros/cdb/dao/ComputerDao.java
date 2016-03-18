package com.louisamoros.cdb.dao;

import com.louisamoros.cdb.model.Computer;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface CompanyDao.
 */
public interface ComputerDao extends CrudRepository<Computer, Long>, QueryDslPredicateExecutor<Computer> {

}
