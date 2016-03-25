package com.louisamoros.cdb.dmo;

import com.louisamoros.cdb.model.util.UserProfileType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * UserDmo profile class.
 */
@Entity(name = "user_profile")
public class UserProfileDmo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 15, unique = true, nullable = false)
    private String type = UserProfileType.USER.getUserProfileType();

    public final long getId() {
        return id;
    }

    public final String getType() {
        return type;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserProfileDmo that = (UserProfileDmo) o;

        if (id != that.id) {
            return false;
        }
        return type != null ? type.equals(that.type) : that.type == null;

    }

    @Override
    public final int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
