package com.louisamoros.cdb.cli;

public class LauncherCDB {
	
	public static void main(String[] args) {
		
//		/*GET COMPANIES*/
//		CompanyService companyService = CompanyServiceImpl.INSTANCE;
//		List<Company> companies = companyService.getAll();
//		for(Company company:companies) {
//			System.out.println(company);
//		}
//		
//		/*GET COMPUTERS*/
//		ComputerService computerService = ComputerServiceImpl.INSTANCE;
//		List<Computer> computers = computerService.getAll();
//		for(Computer computer:computers) {
//			System.out.println(computer);
//		}
//		
//		/*GET COMPUTER*/
//		Computer computer = computerService.get(35);
//		System.out.println(computer);
//		
//		/*CREATE COMPUTER*/
//		computer = new Computer.Builder("launcher test")
//				.introduced(LocalDate.of(1994, 05, 24))
//				.discontinued(LocalDate.of(1995, 05, 24))
//				.build();
//		Computer computerCreated = computerService.create(computer);
//		System.out.println(computerCreated);
//
//		/*UPDATE COMPUTER*/
//		computer = new Computer.Builder("coucou computer")
//				.id(computerCreated.getId())
//				.company(companies.get(3))
//				.introduced(LocalDate.of(2015, 07, 16))
//				.discontinued(LocalDate.of(2016, 07, 16))
//				.build();
//		Computer computerUpdated = computerService.update(computer);
//		System.out.println(computerUpdated);
//
//		/*DELETE COMPUTER*/
//		computerService.delete(computerCreated.getId());
//		Computer deletedComputer = computerService.get(computerCreated.getId());
//		System.out.println(deletedComputer);
	}

}
