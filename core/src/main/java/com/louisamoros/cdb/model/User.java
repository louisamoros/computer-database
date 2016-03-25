package com.louisamoros.cdb.model;

import java.util.HashSet;
import java.util.Set;

/**
 * User class model.
 */
public final class User {

    private long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Set<UserProfile> userProfiles = new HashSet<>();

    /**
     * User class use builder pattern.
     *
     * @param builder the builder
     */
    private User(final Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.password = builder.password;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.userProfiles = builder.userProfiles;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Set<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (id != user.id) {
            return false;
        }
        if (username != null ? !username.equals(user.username) : user.username != null) {
            return false;
        }
        if (password != null ? !password.equals(user.password) : user.password != null) {
            return false;
        }
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) {
            return false;
        }
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) {
            return false;
        }
        if (email != null ? !email.equals(user.email) : user.email != null) {
            return false;
        }
        return userProfiles != null ? userProfiles.equals(user.userProfiles) : user.userProfiles == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (userProfiles != null ? userProfiles.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username='" + username + ", password='" + password + ", firstName='"
                + firstName + ", lastName='" + lastName + ", email='" + email + ", userProfiles=" + userProfiles + ']';
    }

    /**
     * The builder class for computer model.
     */
    public static class Builder {

        private long id;
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private String email;
        private Set<UserProfile> userProfiles = new HashSet<>();

        /**
         * Building the id.
         *
         * @param id the user id
         * @return builder
         */
        public final Builder id(final long id) {
            this.id = id;
            return this;
        }

        /**
         * Building the username.
         *
         * @param username the username
         * @return builder
         */
        public final Builder username(final String username) {
            this.username = username;
            return this;
        }

        /**
         * Building the password.
         *
         * @param password the password.
         * @return builder
         */
        public final Builder password(final String password) {
            this.password = password;
            return this;
        }

        /**
         * Building the first name.
         *
         * @param firstName the first name
         * @return builder
         */
        public final Builder fistName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        /**
         * Building the last name.
         *
         * @param lastName the last name
         * @return builder
         */
        public final Builder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        /**
         * Building the email.
         *
         * @param email the email
         * @return builder
         */
        public final Builder email(final String email) {
            this.email = email;
            return this;
        }

        /**
         * Building the user profiles.
         *
         * @param userProfiles the user profiles
         * @return builder
         */
        public final Builder userProfiles(final Set<UserProfile> userProfiles) {
            this.userProfiles = userProfiles;
            return this;
        }

        /**
         * Building the user model.
         *
         * @return computer
         */
        protected final User build() {
            return new User(this);
        }

    }
}
