package com.louisamoros.cdb.service.impl;

import com.louisamoros.cdb.dao.UserDao;
import com.louisamoros.cdb.model.QUser;
import com.louisamoros.cdb.model.User;
import com.louisamoros.cdb.service.UserService;
import com.mysema.query.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of user service interface.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public final User findByUsername(final String username) {
        Predicate hasUsername = QUser.user.username.eq(username);
        User user = userDao.findOne(hasUsername);
        return user;
    }

}
