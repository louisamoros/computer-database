package com.louisamoros.cdb.model;

import java.time.LocalDate;

/**
 * Computer model class.
 */
public final class Computer {

  private int computerId;
  private Company company;
  private String computerName;
  private LocalDate introduced;
  private LocalDate discontinued;

  /**
   * Computer class use builder pattern.
   *
   * @param builder the builder
   */
  private Computer(final Builder builder) {
    this.computerId = builder.computerId;
    this.computerName = builder.computerName;
    this.company = builder.company;
    this.discontinued = builder.discontinued;
    this.introduced = builder.introduced;
  }

  public int getComputerId() {
    return computerId;
  }

  public Company getCompany() {
    return company;
  }

  public String getComputerName() {
    return computerName;
  }

  public LocalDate getIntroduced() {
    return introduced;
  }

  public LocalDate getDiscontinued() {
    return discontinued;
  }

  @Override
  public String toString() {
    return "Computer [computerId=" + computerId + ", company=" + company + ", computerName="
        + computerName + ", introduced=" + introduced + ", discontinued=" + discontinued + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((company == null) ? 0 : company.hashCode());
    result = prime * result + computerId;
    result = prime * result + ((discontinued == null) ? 0 : discontinued.hashCode());
    result = prime * result + ((introduced == null) ? 0 : introduced.hashCode());
    result = prime * result + ((computerName == null) ? 0 : computerName.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Computer other = (Computer) obj;
    if (company == null) {
      if (other.company != null) {
        return false;
      }
    } else if (!company.equals(other.company)) {
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

  /**
   * The builder class for computer model.
   */
  public static class Builder {

    // require
    private String computerName;

    // optional
    private int computerId;
    private Company company;
    private LocalDate introduced;
    private LocalDate discontinued;

    /**
     * Building the name in the constructor as it is required parameter.
     *
     * @param name the name
     */
    public Builder(final String name) {
      this.computerName = name;
    }

    /**
     * Building the id.
     *
     * @param computerId the computer id
     * @return builder
     */
    public final Builder id(final int computerId) {
      this.computerId = computerId;
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
    public final Computer build() {
      return new Computer(this);
    }

  }

}
