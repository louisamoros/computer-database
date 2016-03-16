package com.louisamoros.cdb.dao;

import com.louisamoros.cdb.model.Computer;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface CompanyDao.
 */
@Repository
public interface ComputerRepository
        extends CrudRepository<Computer, Long>, QueryDslPredicateExecutor<Computer> {

}
