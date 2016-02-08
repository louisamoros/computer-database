package persistence;

import java.util.List;

import model.Computer;

public interface ComputerDao {

	public Computer getComputer(int computerId);

	public List<Computer> getComputers();

	public Computer createComputer();

	public Computer updateComputer(int computerId);

	public void deleteComputer(int computerId);

}
