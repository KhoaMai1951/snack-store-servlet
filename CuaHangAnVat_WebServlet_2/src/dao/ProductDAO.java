package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Product;
import ultilities.DBConn;
import ultilities.SQLStatement;

public class ProductDAO {
	//get product by id
	public static Product getProductByID(int product_id) throws ClassNotFoundException, SQLException
	{
		String query = "SELECT * FROM product WHERE product_id = "+product_id+"";
		ResultSet rs = DBConn.query(query);
		
		Product product = new Product();
		while(rs.next())
		{
			String categoryName = CategoryDAO.getCategoryNameFromID(rs.getInt("category_id"));
			product = new Product(rs.getInt("product_id"), rs.getString("name"), 
					rs.getString("img_name"), rs.getInt("quantity"), 
					rs.getInt("price"), rs.getInt("category_id"),
					categoryName, rs.getString("description"));
			break;
		}
		return product;
	}
	//get all products
	public static ArrayList<Product> getAll() 
			throws ClassNotFoundException, SQLException {
		ArrayList<Product> productList = new ArrayList<Product>();

		String query = SQLStatement.getAll("product");
		ResultSet rs = DBConn.query(query);

		while (rs.next()) {
			String categoryName = CategoryDAO.getCategoryNameFromID(rs.getInt("category_id"));
			Product product = new Product(rs.getInt("product_id"), rs.getString("name"), rs.getString("img_name"),
					rs.getInt("quantity"), rs.getInt("price"), rs.getInt("category_id"),categoryName, rs.getString("description"));
			productList.add(product);
		}
		return productList;
	}
	
	//get products by category
	public static ArrayList<Product> getProductsByCategory(int categoryID) throws ClassNotFoundException, SQLException
	{
		ArrayList<Product> productList = new ArrayList<Product>();
		
//		String result = "*";
//		String table = "product";
//		String condition = "category_id = " + categoryID;
		
		//String query = SQLStatement.getSomethingFromWhere(result, table, condition);
		String query = "SELECT * FROM product WHERE category_id = "+categoryID +" AND is_deleted = 0";
		ResultSet rs = DBConn.query(query);

		while (rs.next()) {
			String categoryName = CategoryDAO.getCategoryNameFromID(rs.getInt("category_id"));
			Product product = new Product(rs.getInt("product_id"), rs.getString("name"), rs.getString("img_name"),
					rs.getInt("quantity"), rs.getInt("price"), 
					rs.getInt("category_id"),categoryName, rs.getString("description"));
			productList.add(product);
		}
		return productList;
	}

	//add new product
	public static void add(int category_id, String name, int quantity,
			String img_name, String description, int price) 
					throws ClassNotFoundException, SQLException 
	{
		String query = "INSERT INTO product (category_id, name, quantity, img_name, description, price) "
				+ "VALUES ("+category_id+", '"+name+"', "+quantity+", '"+img_name+"', '"+description+"', "+price+")";
				
		DBConn.update(query);
	}
	
	//delete product
	public static void delete(String id) throws ClassNotFoundException, SQLException
	{
		DBConn.update(SQLStatement.delete("product", "product_id", id));
	}
	
	//get specific product
	public static Product getProduct(String id) throws ClassNotFoundException, SQLException
	{
		Product product = new Product();
		String query = "SELECT * FROM product WHERE product_id = " + id;
		
		ResultSet rs = DBConn.query(query);

		while (rs.next()) {
			String categoryName = CategoryDAO.getCategoryNameFromID(rs.getInt("category_id"));
			product = new Product(rs.getInt("product_id"), rs.getString("name"), rs.getString("img_name"),
					rs.getInt("quantity"), rs.getInt("price"), 
					rs.getInt("category_id"),categoryName, rs.getString("description"));
			break;
		}
		return product;
	}
	
	//update a product
	public static void updateProduct(int category_id, String name, int quantity, String description, int price, String img_name, int product_id) throws ClassNotFoundException, SQLException
	{
		String query = "UPDATE product SET category_id="+category_id+","
				+ "name='"+name+"',quantity="+quantity+","
				+ "description='"+description+"',price="+price+", img_name='"+img_name+"' WHERE product_id = "+product_id+";";
		DBConn.update(query);
	}
}
