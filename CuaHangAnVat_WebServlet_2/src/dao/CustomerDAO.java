package dao;

import java.sql.SQLException;

import ultilities.DBConn;

public class CustomerDAO {
	//add customer 
	public static void add(String customerName, String customerEmail,
			String customerAddress, String customerPhone, String sessionID) throws ClassNotFoundException, SQLException
	{
		String query = "INSERT INTO customer (name, email, address, phone, session_id)"
				+ "VALUES ('"+customerName+"','"+customerEmail+"','"+customerAddress+"'"
						+ ",'"+customerPhone+"','"+sessionID+"')";
		DBConn.update(query);
	}
}
