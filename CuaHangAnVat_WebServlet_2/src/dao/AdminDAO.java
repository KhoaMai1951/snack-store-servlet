package dao;

import java.sql.SQLException;

import ultilities.DBClose;
import ultilities.DBConn;

public class AdminDAO
{
	//check if username and password correct
	public boolean checkUsernameAndPassword(String username, String password)
	{
		boolean flag = false;
		String query = "SELECT * FROM admin WHERE username = '"+username+"' AND password = '"+password+"' AND is_deleted = 0;";
		DBConn dbConn = new DBConn();
		try
		{
			dbConn.query(query);
			System.out.println(dbConn.resultSet);
			while(dbConn.resultSet.next())
			{
				flag = true;
				break;
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.closeUpdate(dbConn);
		}
		return flag;
	}
}
