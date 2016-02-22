package com.louisamoros.cdb.service;

import java.util.List;

import com.louisamoros.cdb.controller.util.QueryParams;
import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.model.Computer;

public interface ComputerService {

	/**
	 * This method return the numbers of records of computers in the database via the dao.
	 * @return number of computers
	 */
	int count();
	
	/**
	 * Fetch all computers from computer dao.
	 * @return computers list
	 */
	List<Computer> getAll();
	
	/**
	 * Fetch computers from computer dao page function of query params.
	 * @param queryParams
	 * @return computers list
	 */
	List<Computer> get(QueryParams qp);
	
	/**
	 * Fetch the computer from dao based on its Id.
	 * @param computerId
	 * @return computer based on its Id
	 */
	Computer get(int computerId);
	
	/**
	 * Create a new computer with dao method.
	 * @param computer
	 * @return created computer
	 */
	int create(Computer computer);
	
	/**
	 * Update an existing computer based on its Id.
	 * @param computerId
	 * @param computerCreatedId
	 * @return updated computer
	 */
	int update(Computer computer);
	
	/**
	 * Delete a specific computer based on its id.
	 * @param computerId
	 */
	void delete(int computerId);
	
	/**
	 * Setter computerDao (use for test to pass the mockComputerDao)
	 * @param computerDao
	 */
	void setComputerDao(ComputerDao computerDao);
	
}