package model;

import java.sql.Date;

public class Computer {
	
	private int computerId;
	private int companyId;
	private String name;
	private Date introducedDate;
	
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
	public Date getIntroducedDate() {
		return introducedDate;
	}
	public void setIntroducedDate(Date introducedDate) {
		this.introducedDate = introducedDate;
	}
	public Date getDiscontinuedDate() {
		return discontinuedDate;
	}
	public void setDiscontinuedDate(Date discontinuedDate) {
		this.discontinuedDate = discontinuedDate;
	}
	private Date discontinuedDate;
	
}
