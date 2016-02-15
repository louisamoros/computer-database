package com.louisamoros.cdb.dao;

import java.util.List;

import com.louisamoros.cdb.model.Computer;

/**
 * ComputerDao interface implemented by ComputerDaoImpl. Use to Map the database with java object.
 * @author excilys
 *
 */
public interface ComputerDao {

	/**
	 * This method return the number of records of computers in the database
	 * @return number of computer in database
	 * @throws DAOException
	 */
	int getNumberOfComputers() throws DAOException;
	
	/**
	 * Fetch the computer from the database based on its Id.
	 * @param computerId
	 * @return computer
	 * @throws DAOException
	 */
	Computer getComputer(int computerId) throws DAOException;

	/**
	 * Fetch all computers from the database.
	 * @return
	 * @throws DAOException
	 */
	List<Computer> getAllComputers() throws DAOException;

	/**
	 * Fetch computers from the database function of page and perPage params.
	 * @param page
	 * @param perPage
	 * @return 
	 * @throws DAOException
	 */
	List<Computer> getComputers(int page, int perPage) throws DAOException;
	
	/**
	 * Create a new computer in the database.
	 * @param computer
	 * @return created computer
	 * @throws DAOException
	 */
	Computer createComputer(Computer computer) throws DAOException;

	/**
	 * Update an existing computer based on its Id
	 * @param computerId
	 * @return updated computer
	 * @throws DAOException
	 */
	Computer updateComputer(Computer computer) throws DAOException;

	/**
	 * Delete a specific computer based on its id.
	 * @param computerId
	 * @throws DAOException
	 */
	public void deleteComputer(int computerId) throws DAOException;

}
