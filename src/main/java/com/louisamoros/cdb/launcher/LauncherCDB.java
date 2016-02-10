package com.louisamoros.cdb.launcher;

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
		List<Computer> computers = computerService.getComputers();
		for(Computer computer:computers) {
			System.out.println(computer);
		}
		
		/*GET COMPUTER*/
		Computer computer = computerService.getComputer(35);
		System.out.println(computer);
		
		/*CREATE COMPUTER*/
		computer = new Computer(companies.get(2), "Loul amoros yoyoy", LocalDate.of(1994, 05, 24), LocalDate.of(1995, 05, 24));
		Computer computerCreated = computerService.createComputer(computer);
		System.out.println(computerCreated);

		/*UPDATE COMPUTER*/
		computer = new Computer(companies.get(3), "coucou computer", LocalDate.of(2015, 07, 16), LocalDate.of(2016, 07, 16));
		computer.setComputerId(computerCreated.getComputerId());
		Computer computerUpdated = computerService.updateComputer(computer.getComputerId(), computer);
		System.out.println(computerUpdated);

		/*DELETE COMPUTER*/
		computerService.deleteComputer(computerCreated.getComputerId());
		Computer deletedComputer = computerService.getComputer(computerCreated.getComputerId());
		System.out.println(deletedComputer);
	}

}
