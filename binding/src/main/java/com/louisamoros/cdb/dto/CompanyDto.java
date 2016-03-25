package com.louisamoros.cdb.dto;

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
