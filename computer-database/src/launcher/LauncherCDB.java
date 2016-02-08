package launcher;

import java.util.List;

import model.Company;
import service.CompanyService;

public class LauncherCDB {

	public static void main(String[] args) {
		CompanyService companyService = new CompanyService();
		List<Company> companies = companyService.getCompanies();
		for(Company company:companies) {
			System.out.println(company);
		}
	}

}
