package com.louisamoros.cdb.dao;

import java.util.List;

import com.louisamoros.cdb.dao.exception.DaoException;
import com.louisamoros.cdb.model.Company;

/**
 * <CompanyDao> interface implemented by singleton enum <CompanyDaoImpl>. Use to
 * map the database with java object.
 * 
 * @author louis
 *
 */
public interface CompanyDao {

	/**
	 * Fetch all the companies of the database.
	 * 
	 * @return <List> of <Company>
	 */
	List<Company> getAll() throws DaoException;

}
