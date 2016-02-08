package service;

import java.util.List;

import model.Computer;
import persistence.ComputerDaoImpl;
import persistence.DaoFactory;

public class ComputerService {

	ComputerDaoImpl computerDao = null;
	
	public ComputerService() {
		computerDao = DaoFactory.getComputerDao();
	}
	
	public List<Computer> getComputers() {
		return computerDao.getComputers();
	}
	
}
