package dao;

import java.sql.ResultSet;
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
	//Get order_id from customer_session_id
	public static int getOrderID(String customer_session_id) throws ClassNotFoundException, SQLException
	{
		int order_id = -1;
		
		String query = "SELECT order_id FROM `order` WHERE customer_session_id = '"+customer_session_id+"'";
		
		ResultSet rs = DBConn.query(query);
		
		while(rs.next())
		{
			order_id = rs.getInt("order_id");
		}
		
		return order_id;
	}
}
