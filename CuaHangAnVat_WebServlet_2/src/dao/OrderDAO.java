package dao;

import java.sql.SQLException;

import ultilities.DBConn;

public class OrderDAO {
	//Add order
	public static void add(String sessionID) throws ClassNotFoundException, SQLException
	{
		String query = "INSERT INTO cuahanganvat.order(customer_session_id, order_date)" + 
				"VALUES ('"+sessionID+"', CURDATE())";
		DBConn.update(query);
	}
}
