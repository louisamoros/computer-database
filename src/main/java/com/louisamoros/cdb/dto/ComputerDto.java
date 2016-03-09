package com.louisamoros.cdb.dto;

import com.louisamoros.cdb.dto.validator.Date;
import com.louisamoros.cdb.dto.validator.DateOrder;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * The Class ComputerDto.
 */
@DateOrder
public class ComputerDto {

  @NotNull
  @NotEmpty
  private String computerName;

  @Date
  private String discontinued;

  @Date
  private String introduced;

  private int computerId;
  private String companyName;
  private int companyId;

  /**
   * ComputerDto class use builder pattern.
   *
   * @param builder the builder
   */
  private ComputerDto(final Builder builder) {
    this.computerId = builder.computerId;
    this.computerName = builder.computerName;
    this.discontinued = builder.discontinued;
    this.introduced = builder.introduced;
    this.companyName = builder.companyName;
    this.companyId = builder.companyId;
  }

  /**
   * The computer dto constructor. Used by spring mvc in servlet.
   * Not good as it breaks the builder pattern way of thinking.
   * Need to find better solution...
   */
  public ComputerDto() {

  }

  public final int getComputerId() {
    return computerId;
  }

  public final void setComputerId(final int computerId) {
    this.computerId = computerId;
  }

  public final String getComputerName() {
    return computerName;
  }

  public final void setComputerName(final String computerName) {
    this.computerName = computerName;
  }

  public final String getDiscontinued() {
    return discontinued;
  }

  public final void setDiscontinued(final String discontinued) {
    this.discontinued = discontinued;
  }

  public final String getIntroduced() {
    return introduced;
  }

  public final void setIntroduced(final String introduced) {
    this.introduced = introduced;
  }

  public final String getCompanyName() {
    return companyName;
  }

  public final int getCompanyId() {
    return companyId;
  }

  public final void setCompanyId(final int companyId) {
    this.companyId = companyId;
  }

  @Override
  public final int hashCode() {
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
  public final boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    ComputerDto other = (ComputerDto) obj;
    if (companyId != other.companyId) {
      return false;
    }
    if (companyName == null) {
      if (other.companyName != null) {
        return false;
      }
    } else if (!companyName.equals(other.companyName)) {
      return false;
    }
    if (computerId != other.computerId) {
      return false;
    }
    if (discontinued == null) {
      if (other.discontinued != null) {
        return false;
      }
    } else if (!discontinued.equals(other.discontinued)) {
      return false;
    }
    if (introduced == null) {
      if (other.introduced != null) {
        return false;
      }
    } else if (!introduced.equals(other.introduced)) {
      return false;
    }
    if (computerName == null) {
      if (other.computerName != null) {
        return false;
      }
    } else if (!computerName.equals(other.computerName)) {
      return false;
    }
    return true;
  }

  @Override
  public final String toString() {
    return "ComputerDto [computerId=" + computerId + ", computerName=" + computerName
        + ", discontinued=" + discontinued + ", introduced=" + introduced + ", companyName="
        + companyName + ", companyId=" + companyId + "]";
  }

  /**
   * The Class Builder.
   */
  public static class Builder {

    // require
    private String computerName;

    // optional
    private int computerId;
    private String discontinued;
    private String introduced;
    private String companyName;
    private int companyId;

    /**
     * Builder constructor which requires computer name.
     *
     * @param computerName the computer name
     */
    public Builder(final String computerName) {
      this.computerName = computerName;
    }

    /**
     * Building the discontinued date.
     *
     * @param discontinued the discontinued date
     * @return builder
     */
    public final Builder discontinued(final String discontinued) {
      this.discontinued = discontinued;
      return this;
    }

    /**
     * Building the introduced date.
     *
     * @param introduced the introduced date
     * @return builder
     */
    public final Builder introduced(final String introduced) {
      this.introduced = introduced;
      return this;
    }

    /**
     * Building the company name.
     *
     * @param companyName the company name
     * @return builder
     */
    public final Builder companyName(final String companyName) {
      this.companyName = companyName;
      return this;
    }

    /**
     * Building the company id.
     *
     * @param companyId the company id
     * @return builder
     */
    public final Builder companyId(final int companyId) {
      this.companyId = companyId;
      return this;
    }

    /**
     * Building the computer id.
     *
     * @param computerId the computer id
     * @return builder
     */
    public final Builder computerId(final int computerId) {
      this.computerId = computerId;
      return this;
    }

    /**
     * Building the computer dto object.
     *
     * @return computer dto
     */
    public final ComputerDto build() {
      return new ComputerDto(this);
    }

  }

}
