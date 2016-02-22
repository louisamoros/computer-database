package com.louisamoros.cdb.service.impl;

import java.util.List;

import com.louisamoros.cdb.controller.util.QueryParams;
import com.louisamoros.cdb.dao.ComputerDao;
import com.louisamoros.cdb.dao.impl.ComputerDaoImpl;
import com.louisamoros.cdb.model.Computer;
import com.louisamoros.cdb.service.ComputerService;
import com.louisamoros.cdb.service.validator.ComputerValidator;

/**
 * Computer Service used to CRUD computers and verify inputs.
 * 
 * @author louis
 *
 */
public enum ComputerServiceImpl implements ComputerService {

	INSTANCE;

	private ComputerDao computerDao;

	ComputerServiceImpl() {
		computerDao = ComputerDaoImpl.INSTANCE;
	}

	@Override
	public List<Computer> getAll() {
		return computerDao.getAll();
	}

	@Override
	public Computer get(int computerId) {
		return computerDao.get(computerId);
	}

	@Override
	public int create(Computer computer) {
		ComputerValidator.validate(computer);
		return computerDao.create(computer);
	}

	@Override
	public int update(Computer computer) {
		ComputerValidator.validate(computer);
		return computerDao.update(computer);
	}

	@Override
	public void delete(int computerId) {
		computerDao.delete(computerId);
	}

	@Override
	public List<Computer> get(QueryParams qp) {
		return computerDao.get(qp);
	}

	@Override
	public int count() {
		return computerDao.count();
	}

	public void setComputerDao(ComputerDao computerDao) {
		this.computerDao = computerDao;
	}

}
