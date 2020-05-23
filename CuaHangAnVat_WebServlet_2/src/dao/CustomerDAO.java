package dao;

import java.sql.SQLException;

import ultilities.DBConn;
import ultilities.SQLStatement;

public class CustomerDAO {
	//add customer 
	public static void add(String customerName, String customerEmail,
			String customerAddress, String customerPhone, String sessionID)
	{
		DBConn dbConn = new DBConn();
		
		String colList = "name, email, address, phone, session_id";
		String valueList = "'"+customerName+"','"+customerEmail+"','"+customerAddress+"'" + ",'"+customerPhone+"','"+sessionID+"'";
		String query = SQLStatement.add("customer", colList, valueList);
		
		try {
			dbConn.update(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(null != dbConn.conn)
			{
				try {
					dbConn.statement.close();
					dbConn.conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
