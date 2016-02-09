package launcher;

import java.util.Scanner;

import model.Company;
import model.Computer;
import service.CompanyService;
import service.ComputerService;

public class CDBcli {

	public static void main(String[] args) {
		
		final Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		ComputerService computerService = new ComputerService();
		CompanyService companyService = new CompanyService();
		
		while(!exit) {
			
			System.out.println("");
			System.out.println("###################");
			System.out.println("Computer database:");
			System.out.println("1- list companies");
			System.out.println("2- list computers");
			System.out.println("3- create computer");
			System.out.println("4- update computer");
			System.out.println("5- delete computer");
			System.out.println("6- get computer");
			System.out.println("7- exit");
			System.out.println("###################");
			
			switch(scanner.nextInt()) {
				case 1:
					for(Company company:companyService.getCompanies()) {
						System.out.println(company);
					}
					break;
				case 2:
					for(Computer computer:computerService.getComputers()) {
						System.out.println(computer);						
					}
					break;
				case 3:
					ComputerCli.create();
					break;
				case 4:
					ComputerCli.update();
					break;
				case 5:
					ComputerCli.delete();
					break;
				case 6:
					ComputerCli.read();
					break;
				case 7:
					System.exit(1);
					break;
				default:
					System.out.println("Invalid command.");
					break;
			}
		}
	}

}
