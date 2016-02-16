package com.louisamoros.cdb.service;

import java.util.List;

import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.exception.InvalidDateOrderException;
import com.louisamoros.cdb.model.Computer;

public interface ComputerService {

	/**
	 * This method return the numbers of records of computers in the database via the dao.
	 * @return number of computers
	 */
	int getNumberOfComputers();
	
	/**
	 * Fetch all computers from computer dao.
	 * @return computers list
	 */
	List<Computer> getAllComputers();
	
	/**
	 * Fetch computers from computer dao page function of offset and steps params.
	 * @param offset
	 * @param steps
	 * @return computers list
	 */
	List<Computer> getComputers(int offset, int steps);
	
	/**
	 * Fetch the computer from dao based on its Id.
	 * @param computerId
	 * @return computer based on its Id
	 */
	Computer getComputer(int computerId);
	
	/**
	 * Create a new computer with dao method.
	 * @param computer
	 * @return created computer
	 */
	Computer createComputer(Computer computer) throws InvalidDateOrderException;
	
	/**
	 * Update an existing computer based on its Id.
	 * @param computerId
	 * @param computer
	 * @return updated computer
	 */
	Computer updateComputer(Computer computer) throws InvalidDateOrderException;
	
	/**
	 * Delete a specific computer based on its id.
	 * @param computerId
	 */
	void deleteComputer(int computerId);
	
	/**
	 * Setter computerDao (use for test to pass the mockComputerDao)
	 * @param computerDao
	 */
	void setComputerDao(ComputerDao computerDao);
	
}