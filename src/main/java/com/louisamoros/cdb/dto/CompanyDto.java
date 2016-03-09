package com.louisamoros.cdb.dto;

/**
 * The Class CompanyDto.
 */
public final class CompanyDto {

  private int id;
  private String name;

  /**
   * CompanyDto class use builder pattern.
   *
   * @param builder the builder
   */
  private CompanyDto(final Builder builder) {
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
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
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
    CompanyDto other = (CompanyDto) obj;
    if (id != other.id) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "CompanyDto [id=" + id + ", name=" + name + "]";
  }

  public static class Builder {

    // optional
    private int id;
    private String name;

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
     * @param name the name
     * @return builder
     */
    public final Builder name(final String name) {
      this.name = name;
      return this;
    }

    /**
     * Building the company dto object.
     *
     * @return the company dto
     */
    public final CompanyDto build() {
      return new CompanyDto(this);
    }

  }

}
