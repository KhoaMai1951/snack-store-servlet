package entities;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.ProductDAO;

public class OrderedProduct {
	int id;
	int quantity;
	int productID;
	int orderID;
	boolean isDeleted;
	
	public int getId() {
		return id; 
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	//Abstracting product in store quantity
	public static boolean checkInStoreQuantity(Product orderedProduct) throws ClassNotFoundException, SQLException
	{
		int inStoreQuantity = ProductDAO.getQuantity(orderedProduct.getId());
		int newInStoreQuantity = -1;
		if(inStoreQuantity > 0)
		{
			newInStoreQuantity = inStoreQuantity - orderedProduct.getOrderQuantity();
			if(newInStoreQuantity >= 0)
			{
				return true;
			}
		}
		return false;
	}
}
