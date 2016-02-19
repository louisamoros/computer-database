package com.louisamoros.cdb.dao;

import java.util.List;

import com.louisamoros.cdb.dao.exception.DAOException;
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
	 * @throws DAOException
	 */
	int count() throws DAOException;
	
	/**
	 * Fetch the computer from the database based on its Id.
	 * @param computerId
	 * @return <Computer>
	 * @throws DAOException
	 */
	Computer get(int computerId) throws DAOException;

	/**
	 * Fetch all computers from the database.
	 * @return <List> of <Computer>
	 * @throws DAOException
	 */
	List<Computer> getAll() throws DAOException;

	/**
	 * Fetch computers from the database function of offset and steps params.
	 * @param offset
	 * @param steps
	 * @return <List> of <Computer>
	 * @throws DAOException
	 */
	List<Computer> get(int offset, int steps) throws DAOException;
	
	/**
	 * Create a new computer in the database.
	 * @param <Computer> to create
	 * @return <Computer> created
	 * @throws DAOException
	 */
	int create(Computer computer) throws DAOException;

	/**
	 * Update an existing computer based on its Id
	 * @param computerId
	 * @return <Computer> updated
	 * @throws DAOException
	 */
	Computer update(Computer computer) throws DAOException;

	/**
	 * Delete a specific computer based on its id.
	 * @param computerId
	 * @throws DAOException
	 */
	void delete(int computerId) throws DAOException;

}
