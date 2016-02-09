package model;

public class Company {

	private int companyId;
	private String name;

	public Company(String name) {
		this.name = name;
	}

	public Company(int companyId, String name) {
		super();
		this.companyId = companyId;
		this.name = name;
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

}