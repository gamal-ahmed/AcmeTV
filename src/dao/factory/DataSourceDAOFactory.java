package dao.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

//Default DAOFactory implementations -------------------------------------------------------------

/**
 * The DataSource based DAOFactory.
 */
class DataSourceDAOFactory extends DAOFactory {
	private DataSource dataSource;

	public DataSourceDAOFactory(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}