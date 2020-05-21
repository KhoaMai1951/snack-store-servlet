package dao;

import java.sql.SQLException;

import entities.OrderedProduct;
import ultilities.DBConn;

public class OrderedProductDAO {
	public static void add(int quantity, int product_id, int order_id) throws ClassNotFoundException, SQLException
	{
		String query = "insert into ordered_product(quantity, product_id, order_id) values("+quantity+""
				+ ","+product_id+","+order_id+")";
		DBConn.update(query);
	}
	
	public static void add(OrderedProduct orderedProduct) throws ClassNotFoundException, SQLException
	{
		int quantity = orderedProduct.getQuantity();
		int product_id = orderedProduct.getProductID();
		int order_id = orderedProduct.getOrderID();
		String query = "insert into ordered_product(quantity, product_id, order_id) values("+quantity+""
				+ ","+product_id+","+order_id+")";
		DBConn.update(query);
	}
}
