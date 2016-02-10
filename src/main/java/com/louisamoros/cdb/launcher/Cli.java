package com.louisamoros.cdb.launcher;

import java.util.Scanner;

import com.louisamoros.cdb.service.CompanyService;
import com.louisamoros.cdb.service.ComputerService;
import com.louisamoros.cdb.service.impl.CompanyServiceImpl;
import com.louisamoros.cdb.service.impl.ComputerServiceImpl;

public class Cli {

	public static void main(String[] args) {
		
		final Scanner scanner = new Scanner(System.in);
		ComputerService computerService = ComputerServiceImpl.INSTANCE;
		CompanyService companyService = CompanyServiceImpl.INSTANCE;
		
		while(!"exit".equals(scanner)) {
			
			System.out.println("");
			System.out.println("###############################");
			System.out.println("#  Computer Database");
			System.out.println("#");
			System.out.println("#  $ get companies");
			System.out.println("#  $ get computers");
			System.out.println("#  $ get computer <id>");
			System.out.println("#");
			System.out.println("#  $ create computer <name>(required) <company_id> <date_in>(DD/MM/YYYY) <date_out>(DD/MM/YYYY)");
			System.out.println("#");
			System.out.println("#  $ update computer <name>(required) <company_id> <date_in>(DD/MM/YYYY) <date_out>(DD/MM/YYYY)");
			System.out.println("#");
			System.out.println("#  $ delete computer <id>");
			System.out.println("#");
			System.out.println("#  $ exit");
			System.out.println("##############################");
			
			parse(scanner);
			scanner.useDelimiter(" ");
			
			
			switch(scanner.next()) {
				case "create":
					System.out.println("create");
					break;
				case "update":
					System.out.println("update");
					break;
				default:
					System.out.println("Invalid command.");
					break;
			}
		}
	}
	
	private static void parse(Scanner scanner) {
		scanner.useDelimiter(" ");
		while(scanner.hasNext()) {
			System.out.println(scanner.next());
		}
	}

}
