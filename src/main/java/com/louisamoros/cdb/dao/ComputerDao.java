package com.louisamoros.cdb.dao;

import com.louisamoros.cdb.model.Computer;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface CompanyDao.
 */
@Repository
public interface ComputerDao
        extends PagingAndSortingRepository<Computer, Long>, QueryDslPredicateExecutor<Computer> {

}
