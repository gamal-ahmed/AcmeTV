package dao;

import java.util.List;

import dao.exception.DAOException;
import dao.model.Invoice;

/**
 * This interface represents a contract for a DAO for the {@link Invoice} model.
 * Note that all methods which returns the {@link Invoice} from the DB, will not
 * fill the model with the password, due to security reasons.
 *
 * @author Ahmed Gamal
 */
public interface InvoiceDAO {

	// Actions
	// ------------------------------------------------------------------------------------

	/**
	 * Returns the Invoice from the database matching the given ID, otherwise
	 * null.
	 * 
	 * @param id
	 *            The ID of the Invoice to be returned.
	 * @return The Invoice from the database matching the given ID, otherwise
	 *         null.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	public Invoice find(Long id) throws DAOException;

	/**
	 * Returns a list of all Invoices from the database ordered by Invoice ID.
	 * that it's start date equal the given start date and for specific
	 * cutomerid
	 * 
	 * @return A list of all Invoices from the database ordered by Invoice ID.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	public List<Invoice> getInvoicesOfCustomersOfMonth(Long customerID,
			int invoiceDate) throws DAOException;

	/**
	 * Returns a list of Shope Invoices from the database ordered by Invoice ID.
	 * that it's start date equal the given start date and for specific
	 * cutomerid
	 * 
	 * @return A list of all Invoices from the database ordered by Invoice ID.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	public List<Invoice> getShopInvoicesOfCustomersPerMonth(Long customerID,
			int invoiceDate, String invoiceType) throws DAOException;

	/**
	 * Returns a list of Invoices history per address from the database ordered
	 * by Invoice ID. for specific cutomerid
	 * 
	 * @return A list of all Invoices per address from the database ordered by
	 *         Invoice ID.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	public List<Invoice> getShopInvoicesOfPerAddress(Long customerID,
			String addressID) throws DAOException;

	/**
	 * Returns a list of Invoices history per Customer from the database ordered
	 * by Invoice ID. for specific cutomerid
	 * 
	 * @return A list of all Invoices of cutomer from the database ordered by
	 *         Invoice ID.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	public List<Invoice> getInvoicesOfCustomer(Long customerId)
			throws DAOException;

	/**
	 * Returns a list of all Invoices from the database ordered by Invoice ID.
	 * The list is never null and is empty when the database does not contain
	 * any Invoice.
	 * 
	 * @return A list of all Invoices from the database ordered by Invoice ID.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	public List<Invoice> list() throws DAOException;

	/**
	 * Create the given Invoice in the database. The Invoice ID must be null,
	 * otherwise it will throw IllegalArgumentException. After creating, the DAO
	 * will set the obtained ID in the given Invoice.
	 * 
	 * @param Invoice
	 *            The Invoice to be created in the database.
	 * @throws IllegalArgumentException
	 *             If the Invoice ID is not null.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	public void create(Invoice Invoice) throws IllegalArgumentException,
			DAOException;

	/**
	 * Update the given Invoice in the database. The Invoice ID must not be
	 * null, otherwise it will throw IllegalArgumentException. Note: the
	 * password will NOT be updated. Use changePassword() instead.
	 * 
	 * @param Invoice
	 *            The Invoice to be updated in the database.
	 * @throws IllegalArgumentException
	 *             If the Invoice ID is null.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	public void update(Invoice Invoice) throws IllegalArgumentException,
			DAOException;

	/**
	 * Delete the given Invoice from the database. After deleting, the DAO will
	 * set the ID of the given Invoice to null.
	 * 
	 * @param Invoice
	 *            The Invoice to be deleted from the database.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	public void delete(Invoice Invoice) throws DAOException;

}