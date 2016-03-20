package com.louisamoros.cdb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Company model class.
 */
@Entity(name = "company")
public final class Company implements Serializable {

    private static final long serialVersionUID = -511703001460962761L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long companyId;

    @Column(name = "name")
    private String companyName;

    /**
     * Company class use builder pattern.
     *
     * @param builder the builder
     */
    private Company(final Builder builder) {
        this.companyId = builder.id;
        this.companyName = builder.companyName;
    }

    /**
     * Default private constructor to enable hibernate using reflection.
     */
    private Company() {
        super();
    }

    public long getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String toString() {
        return "Company [companyId=" + companyId + ", companyName=" + companyName + "]";
    }

    /**
     * The Builder Class for company model.
     * @author louis
     *
     */
    public static class Builder extends AbstractBuilder<Company> {

        // optional
        private long id;
        private String companyName;

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
         * @param companyName the company name
         * @return builder
         */
        public final Builder name(final String companyName) {
            this.companyName = companyName;
            return this;
        }

        /**
         * Building the company object.
         *
         * @return company
         */
        @Override
        public final Company buildInternal() {
            return new Company(this);
        }

    }

}
