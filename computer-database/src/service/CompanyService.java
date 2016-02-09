package service;

import java.util.List;

import model.Company;
import persistence.CompanyDaoImpl;
import persistence.DaoFactory;

/**
 * Company Service used to CRUD companies
 * @author excilys
 *
 */
public class CompanyService {

	CompanyDaoImpl companyDao = null;

	
	public CompanyService() {
		companyDao = DaoFactory.getCompanyDao();
	}
	
	/**
	 * Fetch all companies from the database.
	 * @return companies list
	 */
	public List<Company> getCompanies() {
		return companyDao.getCompanies();
	}

}
