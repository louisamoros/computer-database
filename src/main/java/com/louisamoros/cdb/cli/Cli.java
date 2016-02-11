package com.louisamoros.cdb.cli;

import java.util.ArrayList;
import java.util.List;
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
			
		    ArrayList<Integer> list = new ArrayList<Integer>();
		    System.out.print("Enter integers please ");
		    System.out.println("(EOF or non-integer to terminate): ");

		    while(scanner.hasNextInt()){
		         list.add(scanner.nextInt());
		    }

		    Integer [] nums = list.toArray(new Integer[0]);
		    for(int i = 0; i < nums.length; i++){
		       System.out.println(nums[i]);
		    }
			
			ArrayList<String> parseCommand = parse(scanner);
			for(String yo:parseCommand) {
				System.out.println("yoyo");
				System.out.println(yo);
			}
			
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
	
	private static ArrayList<String> parse(Scanner scanner) {
		ArrayList<String> parseCommand = new ArrayList<>();
		scanner.useDelimiter(" ");
		boolean end = true;
		while(end) {
			parseCommand.add(scanner.next());
		}
		System.out.println("2ici");
		System.out.println(parseCommand.size());
		System.out.println("ici");
		for(String yo:parseCommand) {
			System.out.println(yo);
		}
		
		return parseCommand;
	}

}
