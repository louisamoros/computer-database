package com.louisamoros.cdb.model;

/**
 * Company model class.
 */
public final class Company {

    private long id;
    private String name;

    /**
     * Constructor using builder pattern.
     * @param builder the builder
     */
    private Company(final Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Company company = (Company) o;

        if (id != company.id) {
            return false;
        }
        return name != null ? name.equals(company.name) : company.name == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Company [id=" + id + ", name=" + name + "]";
    }

    /**
     * The Builder Class for company model.
     */
    public static class Builder {

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
         * @param companyName the company name
         * @return builder
         */
        public final Builder name(final String companyName) {
            this.name = companyName;
            return this;
        }

        /**
         * Building the company object.
         *
         * @return company
         */
        public final Company build() {
            return new Company(this);
        }

    }

}
