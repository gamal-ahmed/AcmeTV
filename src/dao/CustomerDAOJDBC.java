package dao;

import static utils.DAOUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.exception.DAOException;
import dao.factory.DAOFactory;
import dao.model.Customer;

/**
 * This class represents a concrete JDBC implementation of the
 * {@link CustomerDAO} interface.
 *
 * @author Ahmed Gamal
 */
public class CustomerDAOJDBC implements CustomerDAO {

	// Constants
	// ----------------------------------------------------------------------------------

	private static final String SQL_FIND_BY_ID = "SELECT * FROM Customer WHERE customerId = ?";
	private static final String SQL_FIND_BY_EMAIL_AND_PASSWORD = "SELECT * WHERE email = ? ";
	private static final String SQL_LIST_ORDER_BY_ID = "SELECT * ORDER BY customerId";
	private static final String SQL_INSERT = "INSERT INTO Customer (email, name) VALUES (  ?, ?)";
	private static final String SQL_UPDATE = "UPDATE Customer SET email = ?, name = ? WHERE customerId = ?";
	private static final String SQL_DELETE = "DELETE FROM Customer WHERE customerId = ?";
	private static final String SQL_EXIST_EMAIL = "SELECT id FROM Customer WHERE email = ?";

	// Vars
	// ---------------------------------------------------------------------------------------

	private DAOFactory daoFactory;

	// Constructors
	// -------------------------------------------------------------------------------

	/**
	 * Construct an Customer DAO for the given DAOFactory. Package private so
	 * that it can be constructed inside the DAO package only.
	 * 
	 * @param daoFactory
	 *            The DAOFactory to construct this Customer DAO for.
	 */
	public CustomerDAOJDBC(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	// Actions
	// ------------------------------------------------------------------------------------

	@Override
	public Customer find(Long id) throws DAOException {
		return find(SQL_FIND_BY_ID, id);
	}

	@Override
	public Customer find(String email) throws DAOException {
		return find(SQL_FIND_BY_EMAIL_AND_PASSWORD, email);
	}

	/**
	 * Returns the Customer from the database matching the given SQL query with
	 * the given values.
	 * 
	 * @param sql
	 *            The SQL query to be executed in the database.
	 * @param values
	 *            The PreparedStatement values to be set.
	 * @return The Customer from the database matching the given SQL query with
	 *         the given values.
	 * @throws DAOException
	 *             If something fails at database level.
	 */
	private Customer find(String sql, Object... values) throws DAOException {
		Customer Customer = null;

		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, sql,
						false, values);
				ResultSet resultSet = statement.executeQuery();) {
			if (resultSet.next()) {
				Customer = map(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return Customer;
	}

	@Override
	public List<Customer> list() throws DAOException {
		List<Customer> Customers = new ArrayList<>();

		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = connection
						.prepareStatement(SQL_LIST_ORDER_BY_ID);
				ResultSet resultSet = statement.executeQuery();) {
			while (resultSet.next()) {
				Customers.add(map(resultSet));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return Customers;
	}

	@Override
	public void create(Customer Customer) throws IllegalArgumentException,
			DAOException {
		if (Customer.getCustomerId() != null) {
			throw new IllegalArgumentException(
					"Customer is already created, the Customer ID is not null.");
		}

		Object[] values = { Customer.getEmail(), Customer.getName() };

		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection,
						SQL_INSERT, true, values);) {
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new DAOException(
						"Creating Customer failed, no rows affected.");
			}

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					Customer.setCustomerId(generatedKeys.getLong(1));
				} else {
					throw new DAOException(
							"Creating Customer failed, no generated key obtained.");
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void update(Customer Customer) throws DAOException {
		if (Customer.getCustomerId() == null) {
			throw new IllegalArgumentException(
					"Customer is not created yet, the Customer ID is null.");
		}

		Object[] values = { Customer.getEmail(), Customer.getName() };

		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection,
						SQL_UPDATE, false, values);) {
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new DAOException(
						"Updating Customer failed, no rows affected.");
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void delete(Customer Customer) throws DAOException {
		Object[] values = { Customer.getCustomerId() };

		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection,
						SQL_DELETE, false, values);) {
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new DAOException(
						"Deleting Customer failed, no rows affected.");
			} else {
				Customer.setCustomerId(null);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public boolean existEmail(String email) throws DAOException {
		Object[] values = { email };

		boolean exist = false;

		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection,
						SQL_EXIST_EMAIL, false, values);
				ResultSet resultSet = statement.executeQuery();) {
			exist = resultSet.next();
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return exist;
	}

	// Helpers
	// ------------------------------------------------------------------------------------

	/**
	 * Map the current row of the given ResultSet to an Customer.
	 * 
	 * @param resultSet
	 *            The ResultSet of which the current row is to be mapped to an
	 *            Customer.
	 * @return The mapped Customer from the current row of the given ResultSet.
	 * @throws SQLException
	 *             If something fails at database level.
	 */
	private static Customer map(ResultSet resultSet) throws SQLException {
		Customer Customer = new Customer();
		Customer.setCustomerId(resultSet.getLong("customerId"));
		Customer.setEmail(resultSet.getString("email"));
		Customer.setName(resultSet.getString("name"));

		return Customer;
	}

}