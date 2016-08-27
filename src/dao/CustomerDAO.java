package dao;

import java.util.List;

import dao.exception.DAOException;
import dao.model.Customer;

/**
 * This interface represents a contract for a DAO for the {@link Customer} model.
 * Note that all methods which returns the {@link Customer} from the DB, will not
 * fill the model with the password, due to security reasons.
 *
 * @author Ahmed Gamal
 */
public interface CustomerDAO {

	// Actions
	// ------------------------------------------------------------------------------------

	/**
	 * Returns the Cutomer from the database matching the given ID, otherwise null.
	 * 
	 * @param id
	 *            The ID of the Cutomer to be returned.
	 * @return The Cutomer from the database matching the given ID, otherwise null.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	public Customer find(Long id) throws DAOException;

	/**
	 * Returns the Cutomer from the database matching the given email and password,
	 * otherwise null.
	 * 
	 * @param email
	 *            The email of the Cutomer to be returned.
	 * @param password
	 *            The password of the Cutomer to be returned.
	 * @return The Cutomer from the database matching the given email and password,
	 *         otherwise null.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	public Customer find(String email) throws DAOException;

	/**
	 * Returns a list of all Cutomers from the database ordered by Cutomer ID. The
	 * list is never null and is empty when the database does not contain any
	 * Cutomer.
	 * 
	 * @return A list of all Cutomers from the database ordered by Cutomer ID.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	public List<Customer> list() throws DAOException;

	/**
	 * Create the given Cutomer in the database. The Cutomer ID must be null,
	 * otherwise it will throw IllegalArgumentException. After creating, the DAO
	 * will set the obtained ID in the given Cutomer.
	 * 
	 * @param Cutomer
	 *            The Cutomer to be created in the database.
	 * @throws IllegalArgumentException
	 *             If the Cutomer ID is not null.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	public void create(Customer Cutomer) throws IllegalArgumentException, DAOException;

	/**
	 * Update the given Cutomer in the database. The Cutomer ID must not be null,
	 * otherwise it will throw IllegalArgumentException. Note: the password will
	 * NOT be updated. Use changePassword() instead.
	 * 
	 * @param Cutomer
	 *            The Cutomer to be updated in the database.
	 * @throws IllegalArgumentException
	 *             If the Cutomer ID is null.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	public void update(Customer Cutomer) throws IllegalArgumentException, DAOException;

	/**
	 * Delete the given Cutomer from the database. After deleting, the DAO will set
	 * the ID of the given Cutomer to null.
	 * 
	 * @param Cutomer
	 *            The Cutomer to be deleted from the database.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	public void delete(Customer Cutomer) throws DAOException;

	/**
	 * Returns true if the given email address exist in the database.
	 * 
	 * @param email
	 *            The email address which is to be checked in the database.
	 * @return True if the given email address exist in the database.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	public boolean existEmail(String email) throws DAOException;


}