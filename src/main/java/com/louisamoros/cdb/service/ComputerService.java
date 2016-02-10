package com.louisamoros.cdb.service;

import java.util.List;

import com.louisamoros.cdb.model.Computer;

public interface ComputerService {

	/**
	 * Fetch all computers from computer dao.
	 * @return computers list
	 */
	List<Computer> getComputers();
	
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
	Computer createComputer(Computer computer) throws InvalidDateException;
	
	/**
	 * Update an existing computer based on its Id.
	 * @param computerId
	 * @param computer
	 * @return updated computer
	 */
	Computer updateComputer(Computer computer) throws InvalidDateException;
	
	/**
	 * Delete a specific computer based on its id.
	 * @param computerId
	 */
	void deleteComputer(int computerId);
	
}
