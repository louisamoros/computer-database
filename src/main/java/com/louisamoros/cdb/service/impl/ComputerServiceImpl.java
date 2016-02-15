package com.louisamoros.cdb.service.impl;

import java.util.List;

import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.dao.impl.ComputerDaoImpl;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.ComputerService;
import com.louisamoros.cdb.service.InvalidDateException;

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
	public Computer createComputer(Computer computer) throws InvalidDateException {
		if (computer.getIntroducedDate().isBefore(computer.getDiscontinuedDate())) {
			return computerDao.createComputer(computer);
		} else {
			throw new InvalidDateException("Can't create computer with dates in the wrong order.");
		}
	}

	@Override
	public Computer updateComputer(Computer computer) throws InvalidDateException {
		if (computer.getIntroducedDate().isBefore(computer.getDiscontinuedDate())) {
			return computerDao.updateComputer(computer);
		} else {
			throw new InvalidDateException("Can't create computer with dates in the wrong order.");
		}
	}

	@Override
	public void deleteComputer(int computerId) {
		computerDao.deleteComputer(computerId);
	}

	@Override
	public List<Computer> getComputers(int page, int perPage) {
		return computerDao.getComputers(page, perPage);
	}

	@Override
	public int getNumberOfComputers() {
		return computerDao.getNumberOfComputers();
	}
}
