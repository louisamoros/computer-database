package com.louisamoros.cdb.model;

import java.time.LocalDate;

/**
 * Computer model.
 * @author excilys
 *
 */
public class Computer {

	private int computerId;
	private Company company;
	private String name;
	private LocalDate introducedDate;
	private LocalDate discontinuedDate;

	public Computer(String name) {
		this.name = name;
	}
	
	public Computer(int computerId, Company company, String name, LocalDate introducedDate, LocalDate discontinuedDate) {
		super();
		this.computerId = computerId;
		this.company = company;
		this.name = name;
		this.introducedDate = introducedDate;
		this.discontinuedDate = discontinuedDate;
	}

	public Computer(Company company, String name, LocalDate introducedDate, LocalDate discontinuedDate) {
		super();
		this.company = company;
		this.name = name;
	}
	
	public int getComputerId() {
		return computerId;
	}

	public void setComputerId(int computerId) {
		this.computerId = computerId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getIntroducedDate() {
		return introducedDate;
	}

	public void setIntroducedDate(LocalDate introducedDate) {
		this.introducedDate = introducedDate;
	}

	public LocalDate getDiscontinuedDate() {
		return discontinuedDate;
	}

	public void setDiscontinuedDate(LocalDate discontinuedDate) {
		this.discontinuedDate = discontinuedDate;
	}
		
	@Override
	public String toString() {
		return "Computer [computerId=" + computerId + ", company=" + company + ", name=" + name
				+ ", introducedDate=" + introducedDate + ", discontinuedDate=" + discontinuedDate + "]";
	}
	
}
