package com.louisamoros.cdb.dao;

import java.util.List;

import com.louisamoros.cdb.controller.util.QueryParams;
import com.louisamoros.cdb.dao.exception.DaoException;
import com.louisamoros.cdb.model.Computer;

/**
 * ComputerDao interface implemented by ComputerDaoImpl. Use to Map the database with java object.
 * @author louis
 *
 */
public interface ComputerDao {

	/**
	 * This method return the number of records of computers in the database.
	 * @return number of computer in database
	 * @throws DaoException
	 */
	int count() throws DaoException;
	
	/**
	 * Fetch the computer from the database based on its Id.
	 * @param computerId
	 * @return <Computer>
	 * @throws DaoException
	 */
	Computer get(int computerId) throws DaoException;

	/**
	 * Fetch all computers from the database.
	 * @return <List> of <Computer>
	 * @throws DaoException
	 */
	List<Computer> getAll() throws DaoException;

	/**
	 * Fetch computers from the database function of query params.
	 * @param queryParams
	 * @return <List> of <Computer>
	 * @throws DaoException
	 */
	List<Computer> get(QueryParams qp) throws DaoException;
	
	/**
	 * Create a new computer in the database.
	 * @param <Computer> to create
	 * @return <Computer> created
	 * @throws DaoException
	 */
	int create(Computer computer) throws DaoException;

	/**
	 * Update an existing computer based on its Id
	 * @param computerId
	 * @return computerUpdatedId
	 * @throws DaoException
	 */
	int update(Computer computer) throws DaoException;

	/**
	 * Delete a specific computer based on its id.
	 * @param computerId
	 * @throws DaoException
	 */
	void delete(int computerId) throws DaoException;

}
