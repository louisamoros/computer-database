package com.louisamoros.cdb.model;

import com.louisamoros.cdb.model.util.UserProfileType;

/**
 * User profile model class.
 */
public final class UserProfile {

    private long id;
    private String type = UserProfileType.USER.getUserProfileType();

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserProfile that = (UserProfile) o;

        if (id != that.id) {
            return false;
        }
        return type != null ? type.equals(that.type) : that.type == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserProfile [id=" + id + ", type='" + type + ']';
    }
}
