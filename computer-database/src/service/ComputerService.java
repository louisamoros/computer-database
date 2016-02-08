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
