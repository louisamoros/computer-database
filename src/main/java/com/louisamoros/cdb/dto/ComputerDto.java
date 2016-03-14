package com.louisamoros.cdb.dto;

import com.louisamoros.cdb.dto.validator.Date;
import com.louisamoros.cdb.dto.validator.DateOrder;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * The Class ComputerDto.
 */
@DateOrder(message = "Introduced date should be before discontinued date.")
public class ComputerDto {

  @NotNull(message = "Computer name can't be null.")
  @NotEmpty(message = "Computer name can't be empty.")
  private String computerName;

  @Date(message = "Discontinued date format is wrong.")
  private String discontinued;

  @Date(message = "Introduced date format is wrong.")
  private String introduced;

  private long computerId;
  private String companyName;
  private long companyId;

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

  public final long getComputerId() {
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

  public final long getCompanyId() {
    return companyId;
  }

  public final void setCompanyId(final int companyId) {
    this.companyId = companyId;
  }

  @Override
  public final boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ComputerDto that = (ComputerDto) o;

    if (computerId != that.computerId) {
      return false;
    }
    if (companyId != that.companyId) {
      return false;
    }
    if (!computerName.equals(that.computerName)) {
      return false;
    }
    if (discontinued != null ? !discontinued.equals(that.discontinued) : that.discontinued != null) {
      return false;
    }
    if (introduced != null ? !introduced.equals(that.introduced) : that.introduced != null) {
      return false;
    }
    return companyName != null ? companyName.equals(that.companyName) : that.companyName == null;

  }

  @Override
  public final int hashCode() {
    int result = computerName.hashCode();
    result = 31 * result + (discontinued != null ? discontinued.hashCode() : 0);
    result = 31 * result + (introduced != null ? introduced.hashCode() : 0);
    result = 31 * result + (int) (computerId ^ (computerId >>> 32));
    result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
    result = 31 * result + (int) (companyId ^ (companyId >>> 32));
    return result;
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
    private long computerId;
    private String discontinued;
    private String introduced;
    private String companyName;
    private long companyId;

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
    public final Builder companyId(final long companyId) {
      this.companyId = companyId;
      return this;
    }

    /**
     * Building the computer id.
     *
     * @param computerId the computer id
     * @return builder
     */
    public final Builder computerId(final long computerId) {
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
