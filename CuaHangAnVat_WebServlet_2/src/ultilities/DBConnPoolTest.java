package ultilities;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBConnPoolTest
{
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "null";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/cuahanganvat";
	private static final String DB_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

	private static ComboPooledDataSource dataSource;

	public Connection conn = null;
	public ResultSet resultSet = null;
	public java.sql.Statement statement = null;

	static
	{
		dataSource = new ComboPooledDataSource();
		try
		{
			dataSource.setDriverClass(DB_DRIVER_CLASS);
			dataSource.setJdbcUrl(DB_URL);
			dataSource.setUser(DB_USERNAME);
			dataSource.setPassword(DB_PASSWORD);

			dataSource.setMinPoolSize(100);
			dataSource.setMaxPoolSize(1000);
			dataSource.setAcquireIncrement(5);
		} catch (PropertyVetoException e)
		{
			e.printStackTrace();
		}

	}

	// Connect database
	public Connection connect() throws SQLException, ClassNotFoundException
	{
		Connection conn = dataSource.getConnection();
		return conn;
	}

	// Query
	public ResultSet query(String query) throws SQLException
	{
		try
		{
			conn = this.connect();

			statement = conn.createStatement();

			resultSet = statement.executeQuery(query);

		} catch (ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	// Update
	public void update(String query) throws SQLException
	{
		try
		{
			conn = this.connect();

			statement = conn.createStatement();

			String sql = query;

			statement.executeUpdate(sql);

		} catch (ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}