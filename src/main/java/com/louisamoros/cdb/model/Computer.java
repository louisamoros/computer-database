package com.louisamoros.cdb.model;

import java.time.LocalDate;

public class Computer {

  private int computerId;
  private Company company;
  private String computerName;
  private LocalDate introduced;
  private LocalDate discontinued;

  private Computer(Builder builder) {
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
  public boolean equals(Object obj) {
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

  public static class Builder {

    // require
    private String computerName;

    // optional
    private int computerId;
    private Company company;
    private LocalDate introduced;
    private LocalDate discontinued;

    public Builder(String name) {
      this.computerName = name;
    }

    public Builder id(int computerId) {
      this.computerId = computerId;
      return this;
    }

    public Builder company(Company company) {
      this.company = company;
      return this;
    }

    public Builder introduced(LocalDate introduced) {
      this.introduced = introduced;
      return this;
    }

    public Builder discontinued(LocalDate discontinued) {
      this.discontinued = discontinued;
      return this;
    }

    public Computer build() {
      return new Computer(this);
    }

  }

}
