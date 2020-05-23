package ultilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cuahanganvat?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String JDBC_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	private static final String JDBC_USERNAME = "root";
	private static final String JDBC_PASSWORD = "null";

	public Connection conn = null;
	public ResultSet resultSet = null;
	public java.sql.Statement statement = null;

	// Kết nối CSDL
	public static Connection connect() throws SQLException, ClassNotFoundException {
		Class.forName(JDBC_DRIVER_CLASS);
		Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
		return conn;
	}

//	// Query
//	public static ResultSet query(String query) throws SQLException {
//		Connection conn = null;
//		ResultSet resultSet = null;
//		java.sql.Statement statement = null;
//		try {
//			conn = DBConn.connect();
//
//			statement = conn.createStatement();
//
//			String sql = query;
//
//			resultSet = statement.executeQuery(sql);
//
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		return resultSet;
//	}

	// Query test
	public ResultSet query(String query) throws SQLException {
		try {
			conn = DBConn.connect();

			statement = conn.createStatement();

			String sql = query;

			resultSet = statement.executeQuery(sql);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	// Update
	public void update(String query) throws SQLException {
		try {
			conn = DBConn.connect();

			String sql = query;

			int test = statement.executeUpdate(sql);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
