package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Product;
import ultilities.DBClose;
import ultilities.DBConn;
import ultilities.DBConnPoolTest;
import ultilities.SQLStatement;

public class ProductDAO
{
	// restore deleted product
	public static void restoreDeletedProductById(int id)
	{
		DBConn dbConn = new DBConn();
		String query = "UPDATE product SET is_deleted = 0 WHERE product_id = "+id+"";
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

	// get product by id
	public static Product getProductByID(int product_id)
	{
		DBConn dbConn = new DBConn();

		String query = "SELECT * FROM product WHERE product_id = " + product_id + "";

		ResultSet rs = null;

		Product product = new Product();

		try
		{
			rs = dbConn.query(query);

			while (rs.next())
			{
				String categoryName = CategoryDAO.getCategoryNameFromID(rs.getInt("category_id"));
				product = new Product(rs.getInt("product_id"), rs.getString("name"), rs.getString("img_name"),
						rs.getInt("quantity"), rs.getInt("price"), rs.getInt("category_id"), categoryName,
						rs.getString("description"));
				break;
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			DBClose.closeQuery(dbConn, rs);
		}

		return product;
	}

	// get all products
	public static ArrayList<Product> getAll()
	{
		ArrayList<Product> productList = new ArrayList<Product>();

		// DBConn dbConn = new DBConn();
		DBConnPoolTest dbConn = new DBConnPoolTest();
		String query = SQLStatement.getAll("product");

		ResultSet rs = null;
		try
		{
			rs = dbConn.query(query);

			while (rs.next())
			{
				String categoryName = CategoryDAO.getCategoryNameFromID(rs.getInt("category_id"));
				Product product = new Product(rs.getInt("product_id"), rs.getString("name"), rs.getString("img_name"),
						rs.getInt("quantity"), rs.getInt("price"), rs.getInt("category_id"), categoryName,
						rs.getString("description"));
				productList.add(product);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			// DBClose.closeQuery(dbConn, rs);
		}

		return productList;
	}

	// get all deleted products
	public static ArrayList<Product> getAllDeleted()
	{
		ArrayList<Product> productList = new ArrayList<Product>();

		// DBConn dbConn = new DBConn();
		DBConnPoolTest dbConn = new DBConnPoolTest();
		String query = SQLStatement.getAllDeleted("product");

		ResultSet rs = null;
		try
		{
			rs = dbConn.query(query);

			while (rs.next())
			{
				String categoryName = CategoryDAO.getCategoryNameFromID(rs.getInt("category_id"));
				Product product = new Product(rs.getInt("product_id"), rs.getString("name"), rs.getString("img_name"),
						rs.getInt("quantity"), rs.getInt("price"), rs.getInt("category_id"), categoryName,
						rs.getString("description"));
				productList.add(product);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			// DBClose.closeQuery(dbConn, rs);
		}

		return productList;
	}

	// get products by category
	public static ArrayList<Product> getProductsByCategory(int categoryID)
	{
		DBConn dbConn = new DBConn();

		ArrayList<Product> productList = new ArrayList<Product>();

		String query = "SELECT * FROM product WHERE category_id = " + categoryID + " AND is_deleted = 0";

		ResultSet rs = null;
		try
		{
			rs = dbConn.query(query);
			while (rs.next())
			{
				String categoryName = CategoryDAO.getCategoryNameFromID(rs.getInt("category_id"));
				Product product = new Product(rs.getInt("product_id"), rs.getString("name"), rs.getString("img_name"),
						rs.getInt("quantity"), rs.getInt("price"), rs.getInt("category_id"), categoryName,
						rs.getString("description"));
				productList.add(product);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			DBClose.closeQuery(dbConn, rs);
		}
		return productList;
	}

	// add new product
	public static void add(int category_id, String name, int quantity, String img_name, String description, int price)
	{
		DBConn dbConn = new DBConn();

		String query = "INSERT INTO product (category_id, name, quantity, img_name, description, price) " + "VALUES ("
				+ category_id + ", '" + name + "', " + quantity + ", '" + img_name + "', '" + description + "', "
				+ price + ")";

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

	// delete product
	public static void delete(String id)
	{
		DBConn dbConn = new DBConn();
		try
		{
			dbConn.update(SQLStatement.delete("product", "product_id", id));
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			DBClose.closeUpdate(dbConn);
		}
	}

	// get product by id
	public static Product getProduct(String id)
	{
		DBConn dbConn = new DBConn();

		Product product = new Product();
		String query = "SELECT * FROM product WHERE product_id = " + id;

		ResultSet rs = null;
		try
		{
			rs = dbConn.query(query);
			while (rs.next())
			{
				String categoryName = CategoryDAO.getCategoryNameFromID(rs.getInt("category_id"));
				product = new Product(rs.getInt("product_id"), rs.getString("name"), rs.getString("img_name"),
						rs.getInt("quantity"), rs.getInt("price"), rs.getInt("category_id"), categoryName,
						rs.getString("description"));
				break;
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			DBClose.closeQuery(dbConn, rs);
		}

		return product;
	}

	// update a product
	public static void updateProduct(int category_id, String name, int quantity, String description, int price,
			String img_name, int product_id)
	{
		String query = "UPDATE product SET category_id=" + category_id + "," + "name='" + name + "',quantity="
				+ quantity + "," + "description='" + description + "',price=" + price + ", img_name='" + img_name
				+ "' WHERE product_id = " + product_id;
		
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

	// get quantity
	public static int getQuantity(int product_id)
	{
		DBConn dbConn = new DBConn();

		String query = SQLStatement.getSomethingFromWhere("quantity", "product", "product_id=" + product_id);

		ResultSet rs = null;
		try
		{
			rs = dbConn.query(query);
			while (rs.next())
			{
				return rs.getInt("quantity");
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			DBClose.closeQuery(dbConn, rs);
		}

		return -1;
	}

	// set quantity
	public static void setQuantity(int product_id, int newQuantity)
	{
		DBConn dbConn = new DBConn();

		String query = SQLStatement.updateIntValue("product", "quantity", newQuantity, "product_id = " + product_id);
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
}
