package com.louisamoros.cdb.security;

import com.louisamoros.cdb.controller.ComputerController;
import com.louisamoros.cdb.model.User;
import com.louisamoros.cdb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    /**
     * Logger for the class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ComputerController.class);


    @Autowired
    private UserService userService;

    /**
     * Load user by username checking db.
     * @param username the username
     * @return UserDetails the user details
     * @throws UsernameNotFoundException the username not found exception
     */
    @Transactional(readOnly = true)
    public final UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        LOGGER.info("USER: " + user);
        if (user == null) {
            LOGGER.info("UserDmo not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));
    }


    /**
     * Get granted authorities list for specific user.
     * @param user the user
     * @return list of granted authority
     */
    private List<GrantedAuthority> getGrantedAuthorities(final User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getUserProfiles().forEach(userProfile -> authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType())));
        LOGGER.info("AUTHORITIES :" + authorities);
        return authorities;
    }

}
