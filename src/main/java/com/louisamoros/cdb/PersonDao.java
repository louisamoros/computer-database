package com.louisamoros.cdb;

import com.mysema.query.jpa.impl.JPAQuery;

import java.util.List;

/**
 * Person Dao class.
 */
public class PersonDao {

    /**
     * Find person by first name.
     * @param firstname the first name
     * @return list of person
     */
    public final List<Person> findPersonsByFirstnameQueryDSL(final String firstname) {
        JPAQuery query = new JPAQuery(em);
        QPerson person = QPerson.person;

        return query.from(person).where(person.firstname.eq(firstname)).list(person);
    }

}
