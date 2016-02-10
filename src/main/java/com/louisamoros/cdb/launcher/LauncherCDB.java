package com.louisamoros.cdb.launcher;

import java.util.List;

import com.louisamoros.cdb.model.Company;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.CompanyService;
import com.louisamoros.cdb.service.ComputerService;

public class LauncherCDB {

	public static void main(String[] args) {
		
		/*GET COMPANIES*/
		CompanyService companyService = CompanyService.INSTANCE;
		List<Company> companies = companyService.getCompanies();
		for(Company company:companies) {
			System.out.println(company);
		}
		
		/*GET COMPUTERS*/
		ComputerService computerService = ComputerService.INSTANCE;
		List<Computer> computers = computerService.getComputers();
		for(Computer computer:computers) {
			System.out.println(computer);
		}
		
		/*GET COMPUTER*/
//		ComputerService computerService = ComputerService.INSTANCE;
		Computer computer = computerService.getComputer(35);
		System.out.println(computer);
		
		/*CREATE COMPUTER*/
//		ComputerService computerService = ComputerService.INSTANCE;
//		Long time = new Date().getTime();
//		Timestamp ts = new Timestamp(time);
//		Computer computer = new Computer(35, "Loul computer", ts, ts);
//		Computer computerCreated = computerService.createComputer(computer);
//		System.out.println(computerCreated);

		/*UPDATE COMPUTER*/
//		ComputerService computerService = new ComputerService();
//		Long time = new Date().getTime();
//		Timestamp ts = new Timestamp(time);
//		Computer computer = new Computer(35, "coucou computer", ts, ts);
//		computer.setComputerId(585);
//		Computer computerUpdated = computerService.updateComputer(computer.getComputerId(), computer);
//		System.out.println(computerUpdated);

		/*UPDATE COMPUTER*/
//		ComputerService computerService = new ComputerService();
//		computerService.deleteComputer(585);
		
	}

}
