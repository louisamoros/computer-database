package com.louisamoros.cdb.service;

import com.louisamoros.cdb.model.User;

/**
 * UserDmo service class.
 */
public interface UserService {

    /**
     * Get user by username.
     * @param username the username
     * @return the corresponding user
     */
    User findByUsername(final String username);

}
