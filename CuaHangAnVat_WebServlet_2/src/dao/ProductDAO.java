package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Product;
import ultilities.DBConn;
import ultilities.SQLStatement;

public class ProductDAO {
	//get product by id
	public static Product getProductByID(int product_id)
	{
		DBConn dbConn = new DBConn();
		
		String query = "SELECT * FROM product WHERE product_id = "+product_id+"";
		ResultSet rs;
		
		Product product = new Product();
		try {
			rs = dbConn.query(query);
			
			while(rs.next())
			{
				String categoryName = CategoryDAO.getCategoryNameFromID(rs.getInt("category_id"));
				product = new Product(rs.getInt("product_id"), rs.getString("name"), 
						rs.getString("img_name"), rs.getInt("quantity"), 
						rs.getInt("price"), rs.getInt("category_id"),
						categoryName, rs.getString("description"));
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return product;
	}
	//get all products
	public static ArrayList<Product> getAll() {
		ArrayList<Product> productList = new ArrayList<Product>();

//		String query = SQLStatement.getAll("product");
//		ResultSet rs = DBConn.query(query);
//
//		while (rs.next()) {
//			String categoryName = CategoryDAO.getCategoryNameFromID(rs.getInt("category_id"));
//			Product product = new Product(rs.getInt("product_id"), rs.getString("name"), rs.getString("img_name"),
//					rs.getInt("quantity"), rs.getInt("price"), rs.getInt("category_id"),categoryName, rs.getString("description"));
//			productList.add(product);
//		}
		
		DBConn dbConn = new DBConn();
		String query = SQLStatement.getAll("product");
		
		try {
			ResultSet rs = dbConn.query(query);
			
			while (rs.next()) {
				String categoryName = CategoryDAO.getCategoryNameFromID(rs.getInt("category_id"));
				Product product = new Product(rs.getInt("product_id"), rs.getString("name"), rs.getString("img_name"),
						rs.getInt("quantity"), rs.getInt("price"), rs.getInt("category_id"),categoryName, rs.getString("description"));
				productList.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(null != dbConn.conn)
			{
				try {
					dbConn.resultSet.close();
					dbConn.statement.close();
					dbConn.conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return productList;
	}
	
	//get products by category
	public static ArrayList<Product> getProductsByCategory(int categoryID) 
	{
		DBConn dbConn = new DBConn();
		
		ArrayList<Product> productList = new ArrayList<Product>();

		String query = "SELECT * FROM product WHERE category_id = "+categoryID +" AND is_deleted = 0";
		
		ResultSet rs;
		try {
			rs = dbConn.query(query);
			while (rs.next()) {
				String categoryName = CategoryDAO.getCategoryNameFromID(rs.getInt("category_id"));
				Product product = new Product(rs.getInt("product_id"), rs.getString("name"), rs.getString("img_name"),
						rs.getInt("quantity"), rs.getInt("price"), 
						rs.getInt("category_id"),categoryName, rs.getString("description"));
				productList.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(null != dbConn.conn)
			{
				try {
					dbConn.resultSet.close();
					dbConn.statement.close();
					dbConn.conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return productList;
	}

	//add new product
	public static void add(int category_id, String name, int quantity,
			String img_name, String description, int price) 
	{
		DBConn dbConn = new DBConn();
		
		String query = "INSERT INTO product (category_id, name, quantity, img_name, description, price) "
				+ "VALUES ("+category_id+", '"+name+"', "+quantity+", '"+img_name+"', '"+description+"', "+price+")";
				
		try {
			dbConn.update(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
	
	//delete product
	public static void delete(String id)
	{
		DBConn dbConn = new DBConn();
		try {
			dbConn.update(SQLStatement.delete("product", "product_id", id));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
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
	
	//get product by id
	public static Product getProduct(String id) 
	{
		DBConn dbConn = new DBConn();
		
		Product product = new Product();
		String query = "SELECT * FROM product WHERE product_id = " + id;
		
		ResultSet rs;
		try {
			rs = dbConn.query(query);
			while (rs.next()) {
				String categoryName = CategoryDAO.getCategoryNameFromID(rs.getInt("category_id"));
				product = new Product(rs.getInt("product_id"), rs.getString("name"), rs.getString("img_name"),
						rs.getInt("quantity"), rs.getInt("price"), 
						rs.getInt("category_id"),categoryName, rs.getString("description"));
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(null != dbConn.conn)
			{
				try {
					dbConn.resultSet.close();
					dbConn.statement.close();
					dbConn.conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return product;
	}
	
	//update a product
	public static void updateProduct(int category_id, String name, 
			int quantity, String description, int price, String img_name, int product_id)
	{
		DBConn dbConn = new DBConn();
		
		String query = "UPDATE product SET category_id="+category_id+","
				+ "name='"+name+"',quantity="+quantity+","
				+ "description='"+description+"',price="+price+", img_name='"+img_name+"' WHERE product_id = "+product_id+";";
		try {
			dbConn.update(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
	
	//get quantity
	public static int getQuantity(int product_id) 
	{
		DBConn dbConn = new DBConn();
		
		String query = SQLStatement.getSomethingFromWhere("quantity", "product", "product_id="+product_id);
		
		ResultSet rs;
		try {
			rs = dbConn.query(query);
			while(rs.next())
			{
				return rs.getInt("quantity");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(null != dbConn.conn)
			{
				try {
					dbConn.resultSet.close();
					dbConn.statement.close();
					dbConn.conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return -1;
	}
	
	//set quantity
	public static void setQuantity(int product_id, int newQuantity)
	{
		DBConn dbConn = new DBConn();
		
		String query = SQLStatement.updateIntValue("product", "quantity", 
				newQuantity, "product_id = "+product_id);
		try {
			dbConn.update(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
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
