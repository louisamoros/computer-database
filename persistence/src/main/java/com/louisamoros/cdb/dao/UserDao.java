package com.louisamoros.cdb.dao;

import com.louisamoros.cdb.model.User;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface CompanyDao.
 */
public interface UserDao extends CrudRepository<User, Long>, QueryDslPredicateExecutor<User> {

}
