package persistence;

import java.util.List;

import model.Computer;

/**
 * ComputerDao interface implemented by ComputerDaoImpl. Use to Map the database with java object.
 * @author excilys
 *
 */
public interface ComputerDao {

	/**
	 * Fetch the computer from the database based on its Id.
	 * @param computerId
	 * @return
	 */
	public Computer getComputer(int computerId);

	/**
	 * Fetch all computers from the database.
	 * @return
	 */
	public List<Computer> getComputers();

	/**
	 * Create a new computer in the database.
	 * @param computer
	 * @return created computer
	 */
	public Computer createComputer(Computer computer);

	/**
	 * Update an existing computer based on its Id
	 * @param computerId
	 * @param computer
	 * @return updated computer
	 */
	public Computer updateComputer(int computerId, Computer computer);

	/**
	 * Delete a specific computer based on its id.
	 * @param computerId
	 */
	public void deleteComputer(int computerId);

}
