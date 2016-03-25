package com.louisamoros.cdb.dmo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * UserDmo class model.
 */
@Entity(name = "user")
public class UserDmo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(unique = true, nullable = false)
    private String username;

    @NotNull
    @Column(nullable = false)
    private String password;

    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Column(nullable = false)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_user_profile",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_profile_id")})
    private Set<UserProfileDmo> userProfileDmos = new HashSet<>();

    public final long getId() {
        return id;
    }

    public final String getUsername() {
        return username;
    }

    public final String getPassword() {
        return password;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final String getEmail() {
        return email;
    }

    public final Set<UserProfileDmo> getUserProfileDmos() {
        return userProfileDmos;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserDmo userDmo = (UserDmo) o;

        if (id != userDmo.id) {
            return false;
        }
        if (username != null ? !username.equals(userDmo.username) : userDmo.username != null) {
            return false;
        }
        if (password != null ? !password.equals(userDmo.password) : userDmo.password != null) {
            return false;
        }
        if (firstName != null ? !firstName.equals(userDmo.firstName) : userDmo.firstName != null) {
            return false;
        }
        if (lastName != null ? !lastName.equals(userDmo.lastName) : userDmo.lastName != null) {
            return false;
        }
        if (email != null ? !email.equals(userDmo.email) : userDmo.email != null) {
            return false;
        }
        return userProfileDmos != null ? userProfileDmos.equals(userDmo.userProfileDmos) : userDmo.userProfileDmos == null;

    }

    @Override
    public final int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (userProfileDmos != null ? userProfileDmos.hashCode() : 0);
        return result;
    }
}
