package model;

import java.sql.Timestamp;

public class Computer {

	private int computerId;
	private int companyId;
	private String name;
	private Timestamp introducedDate;
	private Timestamp discontinuedDate;

	public Computer(String name) {
		this.name = name;
	}
	
	public Computer(int computerId, int companyId, String name, Timestamp introducedDate, Timestamp discontinuedDate) {
		super();
		this.computerId = computerId;
		this.companyId = companyId;
		this.name = name;
		this.introducedDate = introducedDate;
		this.discontinuedDate = discontinuedDate;
	}

	public Computer(int companyId, String name, Timestamp introducedDate, Timestamp discontinuedDate) {
		super();
		this.companyId = companyId;
		this.name = name;
		this.introducedDate = introducedDate;
		this.discontinuedDate = discontinuedDate;
	}
	
	public int getComputerId() {
		return computerId;
	}

	public void setComputerId(int computerId) {
		this.computerId = computerId;
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

	public Timestamp getIntroducedDate() {
		return introducedDate;
	}

	public void setIntroducedDate(Timestamp introducedDate) {
		this.introducedDate = introducedDate;
	}

	public Timestamp getDiscontinuedDate() {
		return discontinuedDate;
	}

	public void setDiscontinuedDate(Timestamp discontinuedDate) {
		this.discontinuedDate = discontinuedDate;
	}
		
	@Override
	public String toString() {
		return "Computer [computerId=" + computerId + ", companyId=" + companyId + ", name=" + name
				+ ", introducedDate=" + introducedDate + ", discontinuedDate=" + discontinuedDate + "]";
	}

}
