package com.louisamoros.cdb.service.impl;

import java.util.List;

import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.dao.impl.ComputerDaoImpl;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.ComputerService;
import com.louisamoros.cdb.exception.InvalidComputerNameException;
import com.louisamoros.cdb.exception.InvalidDateOrderException;

/**
 * Computer Service used to CRUD computers
 * 
 * @author excilys
 *
 */
public enum ComputerServiceImpl implements ComputerService {

	INSTANCE;

	private ComputerDao computerDao;

	private ComputerServiceImpl() {
		computerDao = ComputerDaoImpl.INSTANCE;
	}
	
	@Override
	public List<Computer> getAllComputers() {
		return computerDao.getAllComputers();
	}

	@Override
	public Computer getComputer(int computerId) {
		return computerDao.getComputer(computerId);
	}

	@Override
	public Computer createComputer(Computer computer) throws InvalidDateOrderException {
		if (isValidComputer(computer)) {
			return computerDao.createComputer(computer);
		} else {
			return null;
		}
	}

	@Override
	public Computer updateComputer(Computer computer) throws InvalidDateOrderException {
		if (isValidComputer(computer)) {
			return computerDao.updateComputer(computer);
		} else {
			return null;
		}
	}

	@Override
	public void deleteComputer(int computerId) {
		computerDao.deleteComputer(computerId);
	}

	@Override
	public List<Computer> getComputers(int offset, int steps) {
		return computerDao.getComputers(offset, steps);
	}

	@Override
	public int getNumberOfComputers() {
		return computerDao.getNumberOfComputers();
	}
	
	private boolean isValidComputer(Computer computer) {
		boolean isValid = false;
		if(computer.getIntroducedDate() != null && computer.getDiscontinuedDate() != null && computer.getIntroducedDate().isAfter(computer.getDiscontinuedDate())) {
			throw new InvalidDateOrderException("Intoduced date should be before discontinued date.");
		} else if (computer.getName() == null || computer.getName().isEmpty()) {
			throw new InvalidComputerNameException("Computer name is required.");
		} else {
			isValid = true;
		}
		return isValid;
	}
	
	public void setComputerDao(ComputerDao computerDao) {
		this.computerDao = computerDao;
	}

}
