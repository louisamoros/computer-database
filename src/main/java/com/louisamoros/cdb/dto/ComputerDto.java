package com.louisamoros.cdb.dto;

/**
 * The Class ComputerDto.
 */

public class ComputerDto {

  private int computerId;
  private String computerName;
  private String discontinued;
  private String introduced;
  private String companyName;
  private int companyId;

  private ComputerDto(Builder builder) {
    this.computerId = builder.computerId;
    this.computerName = builder.computerName;
    this.discontinued = builder.discontinued;
    this.introduced = builder.introduced;
    this.companyName = builder.companyName;
    this.companyId = builder.companyId;
  }

  public ComputerDto() {
    super();
  }

  public void setComputerId(int computerId) {
    this.computerId = computerId;
  }

  public void setComputerName(String computerName) {
    this.computerName = computerName;
  }

  public void setDiscontinued(String discontinued) {
    this.discontinued = discontinued;
  }

  public void setIntroduced(String introduced) {
    this.introduced = introduced;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public void setCompanyId(int companyId) {
    this.companyId = companyId;
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
  public String toString() {
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

    public Builder(String computerName) {
      this.computerName = computerName;
    }

    public Builder discontinued(String discontinued) {
      this.discontinued = discontinued;
      return this;
    }

    public Builder introduced(String introduced) {
      this.introduced = introduced;
      return this;
    }

    public Builder companyName(String companyName) {
      this.companyName = companyName;
      return this;
    }

    public Builder companyId(int companyId) {
      this.companyId = companyId;
      return this;
    }

    public Builder computerId(int computerId) {
      this.computerId = computerId;
      return this;
    }

    public ComputerDto build() {
      return new ComputerDto(this);
    }

  }

}
