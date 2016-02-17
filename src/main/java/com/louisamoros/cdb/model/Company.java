package com.louisamoros.cdb.model;

/**
 * Company model.
 *
 * @author excilys
 */
public class Company {

	private int id;
	private String name;

	public static class Builder {

		// optional
		private int id;
		private String name;

		public Builder() {
			super();
		}

		public Builder cheese(boolean value) {
			cheese = value;
			return this;
		}

	}

	private Company(Builder builder) {
		id = builder.id;
		name = builder.;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + companyId;
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
		if (companyId != other.companyId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}