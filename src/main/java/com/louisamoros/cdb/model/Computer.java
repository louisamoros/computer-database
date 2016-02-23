package com.louisamoros.cdb.model;

import java.time.LocalDate;

public class Computer {

  private int id;
  private Company company;
  private String name;
  private LocalDate introduced;
  private LocalDate discontinued;

  private Computer(Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.company = builder.company;
    this.discontinued = builder.discontinued;
    this.introduced = builder.introduced;
  }

  public int getId() {
    return id;
  }

  public Company getCompany() {
    return company;
  }

  public String getName() {
    return name;
  }

  public LocalDate getIntroduced() {
    return introduced;
  }

  public LocalDate getDiscontinued() {
    return discontinued;
  }

  @Override
  public String toString() {
    return "Computer [id=" + id + ", company=" + company + ", name=" + name + ", introduced="
        + introduced + ", discontinued=" + discontinued + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((company == null) ? 0 : company.hashCode());
    result = prime * result + id;
    result = prime * result + ((discontinued == null) ? 0 : discontinued.hashCode());
    result = prime * result + ((introduced == null) ? 0 : introduced.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
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
    if (id != other.id) {
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
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    return true;
  }

  public static class Builder {

    // require
    private String name;

    // optional
    private int id;
    private Company company;
    private LocalDate introduced;
    private LocalDate discontinued;

    public Builder(String name) {
      this.name = name;
    }

    public Builder id(int id) {
      this.id = id;
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
