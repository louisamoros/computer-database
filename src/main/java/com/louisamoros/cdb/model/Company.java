package com.louisamoros.cdb.model;

public class Company {

  private int companyId;
  private String companyName;

  private Company(Builder builder) {
    this.companyId = builder.id;
    this.companyName = builder.companyName;
  }

  public int getId() {
    return companyId;
  }

  public String getName() {
    return companyName;
  }

  @Override
  public String toString() {
    return "Company [companyId=" + companyId + ", companyName=" + companyName + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + companyId;
    result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
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
    Company other = (Company) obj;
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
    return true;
  }

  public static class Builder {

    // optional
    private int id;
    private String companyName;

    public Builder id(int id) {
      this.id = id;
      return this;
    }

    public Builder name(String companyName) {
      this.companyName = companyName;
      return this;
    }

    public Company build() {
      return new Company(this);
    }

  }

}