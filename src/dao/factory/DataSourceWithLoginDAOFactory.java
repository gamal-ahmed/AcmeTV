package dao.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * The DataSource-with-Login based DAOFactory.
 */
class DataSourceWithLoginDAOFactory extends DAOFactory {
	private DataSource dataSource;
	private String username;
	private String password;

	public DataSourceWithLoginDAOFactory(DataSource dataSource, String username,
			String password) {
		this.dataSource = dataSource;
		this.username = username;
		this.password = password;
	}

	@Override
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection(username, password);
	}
}
