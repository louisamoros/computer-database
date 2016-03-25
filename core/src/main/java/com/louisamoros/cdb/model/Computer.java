package com.louisamoros.cdb.model;

import java.time.LocalDate;

/**
 * Computer model class.
 */
public final class Computer {

    private long id;
    private Company company;
    private String name;
    private LocalDate introduced;
    private LocalDate discontinued;

    /**
     * Computer class use builder pattern.
     *
     * @param builder the builder
     */
    private Computer(final Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.company = builder.company;
        this.discontinued = builder.discontinued;
        this.introduced = builder.introduced;
    }

    public long getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public String getName() {
        return name;
    }

    public LocalDate getIntroduced() {
        return introduced;
    }

    public LocalDate getDiscontinued() {
        return discontinued;
    }

    @Override
    public String toString() {
        return "Computer [id=" + id + ", company=" + company + ", name="
                + name + ", introduced=" + introduced + ", discontinued=" + discontinued
                + "]";
    }

    /**
     * The builder class for computer model.
     */
    public static class Builder {

        // require
        private String name;

        // optional
        private long id;
        private Company company;
        private LocalDate introduced;
        private LocalDate discontinued;

        /**
         * Building the name in the constructor as it is required parameter.
         *
         * @param name the name
         */
        public Builder(final String name) {
            this.name = name;
        }

        /**
         * Building the id.
         *
         * @param id the computer id
         * @return builder
         */
        public final Builder id(final long id) {
            this.id = id;
            return this;
        }

        /**
         * Building the company.
         *
         * @param company the company
         * @return builder
         */
        public final Builder company(final Company company) {
            this.company = company;
            return this;
        }

        /**
         * Building the introduced date.
         *
         * @param introduced the introduced date
         * @return builder
         */
        public final Builder introduced(final LocalDate introduced) {
            this.introduced = introduced;
            return this;
        }

        /**
         * Building the discontinued date.
         *
         * @param discontinued the discontinued date
         * @return builder
         */
        public final Builder discontinued(final LocalDate discontinued) {
            this.discontinued = discontinued;
            return this;
        }

        /**
         * Building the computer object.
         *
         * @return computer
         */
        protected final Computer build() {
            return new Computer(this);
        }

    }

}
