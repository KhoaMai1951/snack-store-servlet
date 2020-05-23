package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import ultilities.DBClose;
import ultilities.DBConn;

public class OrderDAO {
	//Add order
	public static void add(String sessionID)
	{
		DBConn dbConn = new DBConn();
		String query = "INSERT INTO cuahanganvat.order(customer_session_id, order_date)" + 
				"VALUES ('"+sessionID+"', CURDATE())";
		try {
			dbConn.update(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBClose.closeUpdate(dbConn);
		}
	}
	//Get order_id from customer_session_id
	public static int getOrderID(String customer_session_id)
	{
		DBConn dbConn = new DBConn();
		
		int order_id = -1;
		
		String query = "SELECT order_id FROM `order` WHERE customer_session_id = '"+customer_session_id+"'";
		
		ResultSet rs = null;
		
		try {
			rs = dbConn.query(query);
			while(rs.next())
			{
				order_id = rs.getInt("order_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBClose.closeQuery(dbConn, rs);
		}
		
		return order_id;
	}
}
