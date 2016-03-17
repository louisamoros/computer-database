package com.louisamoros.cdb;

/**
 * The Class CompanyDto.
 */
public final class CompanyDto {

  private long id;
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

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    CompanyDto that = (CompanyDto) o;

    if (id != that.id) {
      return false;
    }
    return name != null ? name.equals(that.name) : that.name == null;

  }

  @Override
  public int hashCode() {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "CompanyDto [id=" + id + ", name=" + name + "]";
  }

  /**
   * The builder class for company dto.
   */
  public static class Builder {

    // optional
    private long id;
    private String name;

    /**
     * Building the id.
     *
     * @param id the id
     * @return builder
     */
    public final Builder id(final long id) {
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
