package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Order;
import ultilities.DBClose;
import ultilities.DBConn;

public class OrderDAO
{
	// Update where id
	public static void update(Date deliveredDate, int orderStatusId, int id)
	{
		String query = "UPDATE cuahanganvat.order\r\n" + 
				"SET delivered_date = '"+deliveredDate+"', order_status_id = "+orderStatusId+"\r\n" + 
				"WHERE order_id = "+id+"";
		DBConn dbConn = new DBConn();
		try
		{
			dbConn.update(query);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			DBClose.closeUpdate(dbConn);
		}
	}
	// Get all
	public static List<Order> getAll()
	{
		String query = "SELECT order_id, customer.name as customer_name, cuahanganvat.order.order_date, cuahanganvat.order.delivered_date, order_status.name as status_name FROM cuahanganvat.order \r\n"
				+ "INNER JOIN customer ON customer.session_id = cuahanganvat.order.customer_session_id\r\n"
				+ "INNER JOIN order_status ON cuahanganvat.order.order_status_id = order_status.id\r\n"
				+ "ORDER BY cuahanganvat.order.order_date DESC";
		List<Order> list = new ArrayList<Order>();
		DBConn dbConn = new DBConn();
		ResultSet rs = null;
		try
		{
			rs = dbConn.query(query);
			while (rs.next())
			{
				Order order = new Order();
				order.setOrderID(rs.getInt("order_id"));
				order.setCustomerName(rs.getString("customer_name"));
				order.setOrderDate(rs.getDate("order_date"));
				order.setDeliveredDate(rs.getDate("delivered_date"));
				order.setOrderStatus(rs.getString("status_name"));
				list.add(order);
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

	// Get by id
	public static Order getById(int id)
	{
		String query = "SELECT order_id, customer.name as customer_name, cuahanganvat.order.order_date, \r\n" + 
				"cuahanganvat.order.delivered_date, order_status.name as status_name,\r\n" + 
				"customer.address, customer.phone, customer.email\r\n" + 
				"FROM cuahanganvat.order \r\n" + 
				"INNER JOIN customer ON customer.session_id = cuahanganvat.order.customer_session_id\r\n" + 
				"INNER JOIN order_status ON cuahanganvat.order.order_status_id = order_status.id\r\n" + 
				"WHERE order_id = "+id+" ORDER BY cuahanganvat.order.order_date DESC";
		Order order = new Order();
		DBConn dbConn = new DBConn();
		ResultSet rs = null;
		try
		{
			rs = dbConn.query(query);
			while (rs.next())
			{
				order.setOrderID(rs.getInt("order_id"));
				order.setCustomerName(rs.getString("customer_name"));
				order.setOrderDate(rs.getDate("order_date"));
				order.setDeliveredDate(rs.getDate("delivered_date"));
				order.setOrderStatus(rs.getString("status_name"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				order.setEmail(rs.getString("email"));
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			DBClose.closeQuery(dbConn, rs);
		}
		return order;
	}

	// Add order
	public static void add(String sessionID)
	{
		DBConn dbConn = new DBConn();
		String query = "INSERT INTO cuahanganvat.order(customer_session_id, order_date)" + "VALUES ('" + sessionID
				+ "', CURDATE())";
		try
		{
			dbConn.update(query);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			DBClose.closeUpdate(dbConn);
		}
	}

	// Get order_id from customer_session_id
	public static int getOrderID(String customer_session_id)
	{
		DBConn dbConn = new DBConn();

		int order_id = -1;

		String query = "SELECT order_id FROM `order` WHERE customer_session_id = '" + customer_session_id + "'";

		ResultSet rs = null;

		try
		{
			rs = dbConn.query(query);
			while (rs.next())
			{
				order_id = rs.getInt("order_id");
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			DBClose.closeQuery(dbConn, rs);
		}

		return order_id;
	}
}
