package com.louisamoros.cdb.service.impl;

import java.util.List;

import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.dao.impl.ComputerDaoImpl;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.ComputerService;

/**
 * Computer Service used to CRUD computers
 * @author excilys
 *
 */
public enum ComputerServiceImpl implements ComputerService {

	INSTANCE;
	
	private ComputerDao computerDao;
	
	private ComputerServiceImpl() {
		computerDao = ComputerDaoImpl.INSTANCE;
	}
	
	public List<Computer> getComputers() {
		return computerDao.getComputers();
	}
	
	public Computer getComputer(int computerId) {
		return computerDao.getComputer(computerId);
	}
	
	public Computer createComputer(Computer computer) {
		return computerDao.createComputer(computer);
	}
	
	public Computer updateComputer(int computerId, Computer computer) {
		return computerDao.updateComputer(computerId, computer);
	}
	
	public void deleteComputer(int computerId) {
		computerDao.deleteComputer(computerId);
	}
}
