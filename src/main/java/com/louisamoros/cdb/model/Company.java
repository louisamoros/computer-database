package com.louisamoros.cdb.model;

/**
 * Company model class.
 */
public final class Company {

  private int companyId;
  private String companyName;

  /**
   * Company class use builder pattern.
   *
   * @param builder the builder
   */
  private Company(final Builder builder) {
    this.companyId = builder.id;
    this.companyName = builder.companyName;
  }

  public int getCompanyId() {
    return companyId;
  }

  public String getCompanyName() {
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

  /**
   * The Builder Class for company model.
   * @author louis
   *
   */
  public static class Builder {

    // optional
    private int id;
    private String companyName;

    /**
     * Building the id.
     *
     * @param id the id
     * @return builder
     */
    public final Builder id(final int id) {
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
      this.companyName = companyName;
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
