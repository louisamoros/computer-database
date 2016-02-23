package com.louisamoros.cdb.model;

/**
 * The Class Company.
 */
public class Company {

  private int id;
  private String name;

  /**
   * Instantiates a new company.
   *
   * @param builder the builder
   */
  private Company(Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Company [id=" + id + ", name=" + name + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
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
    Company other = (Company) obj;
    if (id != other.id)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

  /**
   * The Class Builder.
   */
  public static class Builder {

    // optional
    private int id;
    private String name;

    /**
     * Id.
     *
     * @param id the id
     * @return the builder
     */
    public Builder id(int id) {
      this.id = id;
      return this;
    }

    /**
     * Name.
     *
     * @param name the name
     * @return the builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Builds the.
     *
     * @return the company
     */
    public Company build() {
      return new Company(this);
    }

  }

}