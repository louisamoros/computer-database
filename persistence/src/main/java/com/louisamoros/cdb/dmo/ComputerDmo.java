package com.louisamoros.cdb.dmo;

import com.louisamoros.cdb.dmo.validator.DateOrder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * ComputerDmo model class.
 */
@DateOrder
@Entity(name = "computer")
public final class ComputerDmo implements Serializable {

    private static final long serialVersionUID = -1468059361405464223L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyDmo companyDmo;

    @Size(min = 1, max = 80)
    @NotNull
    @Column(nullable = false)
    private String name;

    @Column
    private LocalDate introduced;

    @Column
    private LocalDate discontinued;

    /**
     * ComputerDmo class use builder pattern.
     *
     * @param builder the builder
     */
    private ComputerDmo(final Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.companyDmo = builder.companyDmo;
        this.discontinued = builder.discontinued;
        this.introduced = builder.introduced;
    }

    /**
     * Default private constructor to enable hibernate using reflection.
     */
    private ComputerDmo() {
        super();
    }

    public long getId() {
        return id;
    }

    public CompanyDmo getCompanyDmo() {
        return companyDmo;
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
        return "ComputerDmo [id=" + id + ", companyDmo=" + companyDmo + ", name="
                + name + ", introduced=" + introduced + ", discontinued=" + discontinued
                + "]";
    }

    /**
     * The builder class for computer model.
     */
    public static class Builder extends AbstractBuilder<ComputerDmo> {

        // require
        private String name;

        // optional
        private long id;
        private CompanyDmo companyDmo;
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
         * Building the companyDmo.
         *
         * @param companyDmo the companyDmo
         * @return builder
         */
        public final Builder company(final CompanyDmo companyDmo) {
            this.companyDmo = companyDmo;
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
        @Override
        protected final ComputerDmo buildInternal() {
            return new ComputerDmo(this);
        }

    }

}
