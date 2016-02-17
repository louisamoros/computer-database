package com.louisamoros.cdb.cli;

import java.time.LocalDate;
import java.util.List;

import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.CompanyService;
import com.louisamoros.cdb.service.ComputerService;
import com.louisamoros.cdb.service.impl.CompanyServiceImpl;
import com.louisamoros.cdb.service.impl.ComputerServiceImpl;


public class LauncherCDB {
	
	public static void main(String[] args) {
		
		/*GET COMPANIES*/
		CompanyService companyService = CompanyServiceImpl.INSTANCE;
		List<Company> companies = companyService.getCompanies();
		for(Company company:companies) {
			System.out.println(company);
		}
		
		/*GET COMPUTERS*/
		ComputerService computerService = ComputerServiceImpl.INSTANCE;
		List<Computer> computers = computerService.getAllComputers();
		for(Computer computer:computers) {
			System.out.println(computer);
		}
		
		/*GET COMPUTER*/
		Computer computer = computerService.getComputer(35);
		System.out.println(computer);
		
		/*CREATE COMPUTER*/
		computer = new Computer.Builder("launcher test")
				.introduced(LocalDate.of(1994, 05, 24))
				.discontinued(LocalDate.of(1995, 05, 24))
				.build();
		Computer computerCreated = computerService.createComputer(computer);
		System.out.println(computerCreated);

		/*UPDATE COMPUTER*/
		computer = new Computer.Builder("coucou computer")
				.id(computerCreated.getId())
				.company(companies.get(3))
				.introduced(LocalDate.of(2015, 07, 16))
				.discontinued(LocalDate.of(2016, 07, 16))
				.build();
		Computer computerUpdated = computerService.updateComputer(computer);
		System.out.println(computerUpdated);

		/*DELETE COMPUTER*/
		computerService.deleteComputer(computerCreated.getId());
		Computer deletedComputer = computerService.getComputer(computerCreated.getId());
		System.out.println(deletedComputer);
	}

}
