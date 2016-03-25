package com.louisamoros.cdb.model.util;

/**
 * User profile type enum class.
 */
public enum UserProfileType {
    USER("USER"),
    ADMIN("ADMIN");

    private String userProfileType;

    /**
     * Private constructor class.
     * @param userProfileType the user profile type
     */
    UserProfileType(final String userProfileType) {
        this.userProfileType = userProfileType;
    }

    public String getUserProfileType() {
        return userProfileType;
    }

}
