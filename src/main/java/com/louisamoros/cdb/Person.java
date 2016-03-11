package com.louisamoros.cdb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Person class.
 */
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstname;

    @Column
    private String surname;

    /**
     * Public constructor.
     * @param firstname the first name
     * @param surname the surname
     */
    public Person(final String firstname, final String surname) {
        this.firstname = firstname;
        this.surname = surname;
    }

    public final Long getId() {
        return id;
    }

    public final void setId(final Long id) {
        this.id = id;
    }

    public final String getFirstname() {
        return firstname;
    }

    public final void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    public final String getSurname() {
        return surname;
    }

    public final void setSurname(final String surname) {
        this.surname = surname;
    }

}
