package com.louisamoros.cdb.dto;

/**
 * The Class ComputerDto.
 */
public class ComputerDto {

	/** The computer id. */
    private int computerId;
    
	/** The computer name. */
    private String computerName;
    
    /** The discontinued. */
	private String discontinued;
    
    /** The introduced. */
    private String introduced;
    
    /** The company name. */
    private String companyName;
    
    /** The company id. */
    private int companyId;

    /**
     * Instantiates a new computer dto.
     *
     * @param builder the builder
     */
    private ComputerDto(Builder builder) {
        this.computerId = builder.computerId;
        this.computerName = builder.computerName;
        this.discontinued = builder.discontinued;
        this.introduced = builder.introduced;
        this.companyName = builder.companyName;
        this.companyId = builder.companyId;
    }

    public int getComputerId() {
        return computerId;
    }

    public String getComputerName() {
        return computerName;
    }

    public String getDiscontinued() {
        return discontinued;
    }

    public String getIntroduced() {
        return introduced;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getCompanyId() {
        return companyId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + companyId;
        result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
        result = prime * result + computerId;
        result = prime * result + ((discontinued == null) ? 0 : discontinued.hashCode());
        result = prime * result + ((introduced == null) ? 0 : introduced.hashCode());
        result = prime * result + ((computerName == null) ? 0 : computerName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ComputerDto other = (ComputerDto) obj;
        if (companyId != other.companyId)
            return false;
        if (companyName == null) {
            if (other.companyName != null)
                return false;
        } else if (!companyName.equals(other.companyName))
            return false;
        if (computerId != other.computerId)
            return false;
        if (discontinued == null) {
            if (other.discontinued != null)
                return false;
        } else if (!discontinued.equals(other.discontinued))
            return false;
        if (introduced == null) {
            if (other.introduced != null)
                return false;
        } else if (!introduced.equals(other.introduced))
            return false;
        if (computerName == null) {
            if (other.computerName != null)
                return false;
        } else if (!computerName.equals(other.computerName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ComputerDto [computerId=" + computerId + ", computerName=" + computerName + ", discontinued=" + discontinued
                + ", introduced=" + introduced + ", companyName=" + companyName + ", companyId=" + companyId
                + "]";
    }

    /**
     * The Class Builder.
     */
    public static class Builder {

    	// require
        /** The computer name. */
        private String computerName;

        // optional
        /** The computer id. */
        private int computerId;
        
        /** The discontinued. */
        private String discontinued;
        
        /** The introduced. */
        private String introduced;
        
        /** The company name. */
        private String companyName;
        
        /** The company id. */
        private int companyId;

        /**
         * Instantiates a new builder.
         *
         * @param computerName the computer name
         */
        public Builder(String computerName) {
            this.computerName = computerName;
        }

        /**
         * Discontinued.
         *
         * @param discontinued the discontinued
         * @return the builder
         */
        public Builder discontinued(String discontinued) {
            this.discontinued = discontinued;
            return this;
        }

        /**
         * Introduced.
         *
         * @param introduced the introduced
         * @return the builder
         */
        public Builder introduced(String introduced) {
            this.introduced = introduced;
            return this;
        }

        /**
         * Company name.
         *
         * @param companyName the company name
         * @return the builder
         */
        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        /**
         * Company id.
         *
         * @param companyId the company id
         * @return the builder
         */
        public Builder companyId(int companyId) {
            this.companyId = companyId;
            return this;
        }
        
        public Builder computerId(int computerId) {
        	this.computerId = computerId;
        	return this;
        }

        /**
         * Builds the.
         *
         * @return the computer dto
         */
        public ComputerDto build() {
            return new ComputerDto(this);
        }

    }

}
