package dao;

import java.sql.SQLException;

import entities.OrderedProduct;
import ultilities.DBClose;
import ultilities.DBConn;

public class OrderedProductDAO {
	public static void add(int quantity, int product_id, int order_id) 
	{
		DBConn dbConn = new DBConn();
		String query = "insert into ordered_product(quantity, product_id, order_id) values("+quantity+""
				+ ","+product_id+","+order_id+")";
		try {
			dbConn.update(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.closeUpdate(dbConn);
		}
	}
	
	public static void add(OrderedProduct orderedProduct)
	{
		DBConn dbConn = new DBConn();
		
		int quantity = orderedProduct.getQuantity();
		int product_id = orderedProduct.getProductID();
		int order_id = orderedProduct.getOrderID();
		String query = "insert into ordered_product(quantity, product_id, order_id) values("+quantity+""
				+ ","+product_id+","+order_id+")";
		
		try {
			dbConn.update(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.closeUpdate(dbConn);
		}
	}
}
