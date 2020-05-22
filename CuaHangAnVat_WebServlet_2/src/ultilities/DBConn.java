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

	// Kết nối CSDL
	public static Connection connect() throws SQLException, ClassNotFoundException {
		Class.forName(JDBC_DRIVER_CLASS);
		Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
		return conn;
	}

	// Query
	public static ResultSet query(String query) throws ClassNotFoundException, SQLException {
		Connection conn = null;

		conn = DBConn.connect();

		java.sql.Statement statement = null;

		statement = conn.createStatement();

		String sql = query;
		ResultSet resultSet = null;

		resultSet = statement.executeQuery(sql);

		return resultSet;
	}

	// Update
	public static void update(String query) throws ClassNotFoundException, SQLException {
		Connection conn = null;

		conn = DBConn.connect();

		java.sql.Statement statement = null;

		statement = ((java.sql.Connection) conn).createStatement();

		String sql = query;

		int test = statement.executeUpdate(sql);

		if (conn != null) {
			conn.close();
		}
	}
}
