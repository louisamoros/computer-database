package launcher;

import java.util.List;

import model.Company;
import model.Computer;
import service.ComputerService;

public class LauncherCDB {

	public static void main(String[] args) {
		
		/*GET COMPANIES*/
//		CompanyService companyService = new CompanyService();
//		List<Company> companies = companyService.getCompanies();
//		for(Company company:companies) {
//			System.out.println(company);
//		}
		
		/*GET COMPUTERS*/
		ComputerService computerService = new ComputerService();
		List<Computer> computers = computerService.getComputers();
		for(Computer computer:computers) {
			System.out.println(computer);
		}
	}

}
