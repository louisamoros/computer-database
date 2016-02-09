package persistence;

import java.util.List;

import model.Company;

/**
 * CompanyDao interface implemented by CompanyDaoImpl. Use to Map the database with java object.
 * @author excilys
 *
 */
public interface CompanyDao {

	/**
	 * Fetch all the companies of the database.
	 * @return companies list
	 */
	public List<Company> getCompanies();

}
