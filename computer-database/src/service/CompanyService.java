package service;

import java.util.List;

import model.Company;
import persistence.CompanyDaoImpl;
import persistence.DaoFactory;

public class CompanyService {

	CompanyDaoImpl companyDao = null;

	public CompanyService() {
		companyDao = DaoFactory.getCompanyDao();
	}

	public List<Company> getCompanies() {
		return companyDao.getCompanies();
	}

}
