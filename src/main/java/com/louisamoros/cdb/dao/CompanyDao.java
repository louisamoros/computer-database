package com.louisamoros.cdb.dao;

import java.util.List;

import com.louisamoros.cdb.dao.exception.DAOException;
import com.louisamoros.cdb.model.Company;

/**
 * CompanyDao interface implemented by singleton enum CompanyDaoImpl. Use to Map
 * the database with java object.
 * 
 * @author louis
 *
 */
public interface CompanyDao {

	/**
	 * Fetch all the companies of the database.
	 * 
	 * @return companies list
	 */
	List<Company> getAll() throws DAOException;

}
