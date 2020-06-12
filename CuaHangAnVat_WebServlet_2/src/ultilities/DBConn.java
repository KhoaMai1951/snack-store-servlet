package ultilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cuahanganvat?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String JDBC_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	private static final String JDBC_USERNAME = "root";
	private static final String JDBC_PASSWORD = "null";

	public Connection conn = null;
	public ResultSet resultSet = null;
	public java.sql.Statement statement = null;

	// Kết nối CSDL
	public Connection connect() throws SQLException, ClassNotFoundException {
		Class.forName(JDBC_DRIVER_CLASS);
		Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
		return conn;
	}


	// Query 
	public ResultSet query(String query) throws SQLException {
		try {
			conn = connect();

			statement = conn.createStatement();

			resultSet = statement.executeQuery(query);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
	
	// Update
	public void update(String query) throws SQLException {
		try {
			conn = connect();
			
			statement = conn.createStatement();

			String sql = query;

			statement.executeUpdate(sql);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
