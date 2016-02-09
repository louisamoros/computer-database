package com.louisamoros.cdb.service;

import java.util.List;

import com.louisamoros.cdb.dao.ComputerDaoImpl;
import com.louisamoros.cdb.dao.DaoFactory;
import com.louisamoros.cdb.model.Computer;

/**
 * Computer Service used to CRUD computers
 * @author excilys
 *
 */
public class ComputerService {

	ComputerDaoImpl computerDao = null;
	
	public ComputerService() {
		computerDao = DaoFactory.getComputerDao();
	}
	
	/**
	 * Fetch all computers from the database.
	 * @return computers list
	 */
	public List<Computer> getComputers() {
		return computerDao.getComputers();
	}
	
	/**
	 * Fetch the computer from the database based on its Id.
	 * @param computerId
	 * @return computer based on its Id
	 */
	public Computer getComputer(int computerId) {
		return computerDao.getComputer(computerId);
	}
	
	/**
	 * Create a new computer in the database.
	 * @param computer
	 * @return created computer
	 */
	public Computer createComputer(Computer computer) {
		return computerDao.createComputer(computer);
	}
	
	/**
	 * Update an existing computer based on its Id.
	 * @param computerId
	 * @param computer
	 * @return updated computer
	 */
	public Computer updateComputer(int computerId, Computer computer) {
		return computerDao.updateComputer(computerId, computer);
	}
	
	/**
	 * Delete a specific computer based on its id.
	 * @param computerId
	 */
	public void deleteComputer(int computerId) {
		computerDao.deleteComputer(computerId);
	}
}
