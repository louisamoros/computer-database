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
	 * Fetch the computer from the database based on its Id.
	 * @param computerId
	 * @return
	 */
	Computer getComputer(int computerId) throws DAOException;

	/**
	 * Fetch all computers from the database.
	 * @return
	 */
	List<Computer> getComputers() throws DAOException;

	/**
	 * Create a new computer in the database.
	 * @param computer
	 * @return created computer
	 */
	Computer createComputer(Computer computer) throws DAOException;

	/**
	 * Update an existing computer based on its Id
	 * @param computerId
	 * @param computer
	 * @return updated computer
	 */
	Computer updateComputer(Computer computer) throws DAOException;

	/**
	 * Delete a specific computer based on its id.
	 * @param computerId
	 */
	public void deleteComputer(int computerId) throws DAOException;

}
