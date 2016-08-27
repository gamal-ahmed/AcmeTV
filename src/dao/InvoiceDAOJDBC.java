package dao;

import static utils.DAOUtil.prepareStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.exception.DAOException;
import dao.factory.DAOFactory;
import dao.model.Invoice;

/**
 * This class represents a concrete JDBC implementation of the
 * {@link InvoiceDAO} interface.
 *
 * @author Ahmed Gamal
 */
public class InvoiceDAOJDBC implements InvoiceDAO {

	// Constants
	// ----------------------------------------------------------------------------------

	private static final String SELECT_INVOICES_OF_CUSTOMER_PER_MONTH = "select * from invoice where monthname(startDate)=? and  customerId= ? ";
	private static final String FILTER_BY_IVOICE_TYPE = SELECT_INVOICES_OF_CUSTOMER_PER_MONTH
			+ "and invoiceType like ?";
	private static final String SQL_DELETE = "DELETE FROM Invoice WHERE invoiceId like ?";
	private static final String INVOICES_PER_ADDRESS = "select * from invoice  where addressId=? and customerId = ? ";
	private static final String INVOICES_HISTORY = "select * from invoice  where  customerId = ? ";

	// Vars
	// ---------------------------------------------------------------------------------------

	private DAOFactory daoFactory;

	// Constructors
	// -------------------------------------------------------------------------------

	/**
	 * Construct an Invoice DAO for the given DAOFactory. Package private so
	 * that it can be constructed inside the DAO package only.
	 * 
	 * @param daoFactory
	 *            The DAOFactory to construct this Invoice DAO for.
	 */
	public InvoiceDAOJDBC(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	// Actions
	// ------------------------------------------------------------------------------------

	/**
	 * Returns the Invoice from the database matching the given SQL query with
	 * the given values.
	 * 
	 * @param sql
	 *            The SQL query to be executed in the database.
	 * @param values
	 *            The PreparedStatement values to be set.
	 * @return The Invoice from the database matching the given SQL query with
	 *         the given values.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	private Invoice find(String sql, Object... values) throws DAOException {
		Invoice Invoice = null;

		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, sql,
						false, values);
				ResultSet resultSet = statement.executeQuery();) {
			if (resultSet.next()) {
				Invoice = map(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return Invoice;
	}

	private List<Invoice> findInvoicesByfilter(String sql, Object... values)
			throws DAOException {

		List<Invoice> Invoices = new ArrayList<>();

		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, sql,
						false, values);
				ResultSet resultSet = statement.executeQuery();) {
			while (resultSet.next()) {
				Invoices.add(map(resultSet));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return Invoices;
	}

	@Override
	public List<Invoice> getShopInvoicesOfCustomersPerMonth(Long customerID,
			int invoiceDate, String invoiceType) throws DAOException {
		Object[] values = { utils.DateUtils.getMonth(invoiceDate), customerID,
				"%" + invoiceType + "%" };
		return findInvoicesByfilter(FILTER_BY_IVOICE_TYPE, values);
	}

	@Override
	public List<Invoice> getShopInvoicesOfPerAddress(Long customerID,
			String addressID) throws DAOException {
		Object[] values = { addressID, customerID };

		return findInvoicesByfilter(INVOICES_PER_ADDRESS, values);
	}

	@Override
	public List<Invoice> getInvoicesOfCustomer(Long customerId)
			throws DAOException {
		Object[] values = { customerId };

		return findInvoicesByfilter(INVOICES_HISTORY, values);
	}

	@Override
	public List<Invoice> getInvoicesOfCustomersOfMonth(Long customerID,
			int invoiceDate) throws DAOException {

		Object[] values = { utils.DateUtils.getMonth(invoiceDate), customerID };

		return findInvoicesByfilter(SELECT_INVOICES_OF_CUSTOMER_PER_MONTH,
				values);
	}

	@Override
	public void create(Invoice Invoice) throws IllegalArgumentException,
			DAOException {
		// create invoice
	}

	@Override
	public void update(Invoice Invoice) throws DAOException {
		// update invoice
	}

	@Override
	public void delete(Invoice Invoice) throws DAOException {
		Object[] values = { Invoice.getInvoiceId() };

		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection,
						SQL_DELETE, false, values);) {
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new DAOException(
						"Deleting Invoice failed, no rows affected.");
			} else {
				Invoice.setInvoiceId(null);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	// Helpers
	// ------------------------------------------------------------------------------------

	/**
	 * Map the current row of the given ResultSet to an Invoice.
	 * 
	 * @param resultSet
	 *            The ResultSet of which the current row is to be mapped to an
	 *            Invoice.
	 * @return The mapped Invoice from the current row of the given ResultSet.
	 * @throws SQLException
	 *             If something fails at database level.
	 */
	private static Invoice map(ResultSet resultSet) throws SQLException {
		Invoice invoice = new Invoice();

		invoice.setInvoiceId(resultSet.getLong("invoiceId"));
		invoice.setAddressId(resultSet.getLong("addressId"));
		invoice.setAmount(resultSet.getLong("amount"));
		invoice.setStartDate(resultSet.getDate("startDate"));
		invoice.setEndDate(resultSet.getDate("endDate"));
		invoice.setPaymentDueDate(resultSet.getDate("paymentDueDate"));
		invoice.setPeriodDescription(resultSet.getString("periodDescription"));
		invoice.setVatAmount(resultSet.getLong("vatAmount"));

		return invoice;
	}

	@Override
	public Invoice find(Long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Invoice> list() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}