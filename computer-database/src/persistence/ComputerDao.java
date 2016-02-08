package persistence;

import java.util.List;

import model.Computer;

public interface ComputerDao {

	public Computer getComputer(int computerId);

	public List<Computer> getComputers();

	public Computer createComputer(Computer computer);

	public Computer updateComputer(int computerId, Computer computer);

	public void deleteComputer(int computerId);

}
