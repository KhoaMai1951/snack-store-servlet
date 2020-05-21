package dao;

import java.sql.SQLException;

import ultilities.DBConn;
import ultilities.SQLStatement;

public class CustomerDAO {
	//add customer 
	public static void add(String customerName, String customerEmail,
			String customerAddress, String customerPhone, String sessionID) throws ClassNotFoundException, SQLException
	{
		String colList = "name, email, address, phone, session_id";
		String valueList = "'"+customerName+"','"+customerEmail+"','"+customerAddress+"'" + ",'"+customerPhone+"','"+sessionID+"'";
		String query = SQLStatement.add("customer", colList, valueList);
		DBConn.update(query);
	}
}
