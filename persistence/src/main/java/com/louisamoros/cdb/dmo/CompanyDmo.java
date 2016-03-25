package com.louisamoros.cdb.dmo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * CompanyDmo data model object class.
 */
@Entity(name = "company")
public final class CompanyDmo implements Serializable {

    private static final long serialVersionUID = -511703001460962761L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    /**
     * CompanyDmo class use builder pattern.
     *
     * @param builder the builder
     */
    private CompanyDmo(final Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    /**
     * Default private constructor to enable hibernate using reflection.
     */
    private CompanyDmo() {
        super();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CompanyDmo [id=" + id + ", name=" + name + "]";
    }

    /**
     * The Builder Class for company model.
     */
    public static class Builder extends AbstractBuilder<CompanyDmo> {

        // optional
        private long id;
        private String name;

        /**
         * Building the id.
         *
         * @param id the id
         * @return builder
         */
        public final Builder id(final long id) {
            this.id = id;
            return this;
        }

        /**
         * Building the name.
         *
         * @param name the company name
         * @return builder
         */
        public final Builder name(final String name) {
            this.name = name;
            return this;
        }

        /**
         * Building the company object.
         *
         * @return company data model object
         */
        @Override
        public final CompanyDmo buildInternal() {
            return new CompanyDmo(this);
        }

    }

}
