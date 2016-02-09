package launcher;

import java.util.Date;
import java.sql.Timestamp;
import java.util.Scanner;

import model.Computer;
import service.ComputerService;

public class ComputerCli {
	
	static final Scanner scannerComputerCli = new Scanner(System.in);
	
	public static void create() {
			
		System.out.println("New Computer:");
		
		System.out.println("> Name (required):");
		String name = scannerComputerCli.nextLine();
		Computer computer = new Computer(name);
		
		System.out.println("> Company Id:");
		Integer companyId = scannerComputerCli.nextInt();
		computer.setCompanyId(companyId);
		
		System.out.println("> Introduced Date (MM/DD/AAAA):");
		String date = scannerComputerCli.next();
		computer.setIntroducedDate(new Timestamp(new Date(date).getTime()));
		
		System.out.println("> Discontinued Date (MM/DD/AAAA):");
		date = scannerComputerCli.next();
		computer.setDiscontinuedDate(new Timestamp(new Date(date).getTime()));

		Computer computerCreated = new ComputerService().createComputer(computer);
		System.out.println("Created Computer:");
		System.out.println(computerCreated);
		
	}
	
	public static void read() {
		
		System.out.println("Get Computer:");
		
		System.out.println("> ComputerID:");
		Integer computerId = scannerComputerCli.nextInt();
		
		System.out.println(new ComputerService().getComputer(computerId));
		
	}
	
	public static void update() {
		
		System.out.println("NOT IMPLEMENTED YET...");
		
	}
	
	public static void delete() {

		System.out.println("NOT IMPLEMENTED YET...");

		
	}
	
}
