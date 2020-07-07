package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.OrderStatus;
import ultilities.DBClose;
import ultilities.DBConn;

public class OrderStatusDAO
{
	public static List<OrderStatus> getAll()
	{
		List<OrderStatus> list = new ArrayList<OrderStatus>();
		String query = "SELECT * FROM order_status";
		
		DBConn dbConn = new DBConn();
		ResultSet rs = null;
		try
		{
			rs = dbConn.query(query);
			while (rs.next())
			{
				OrderStatus orderStatus = new OrderStatus();
				orderStatus.setId(rs.getInt("id"));
				orderStatus.setName(rs.getString("name"));
				list.add(orderStatus);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			DBClose.closeQuery(dbConn, rs);
		}
		return list;
	}
}
