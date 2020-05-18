package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Category;
import ultilities.DBConn;
import ultilities.SQLStatement;

public class CategoryDAO {

	public static ArrayList<Category> getAll() throws ClassNotFoundException, SQLException {
		ArrayList<Category> categoriesList = new ArrayList<Category>();

		String query = SQLStatement.getAll("category");

		ResultSet rs = DBConn.query(query);

		while (rs.next()) {
			Category categories = new Category(rs.getInt("category_id"), rs.getString("name"));
			categoriesList.add(categories);
		}

		return categoriesList;
	}

	public static String getCategoryNameFromID(int id) throws SQLException, ClassNotFoundException {
		String result = "*";
		String table= "category";
		String condition = "category_id = " + id;
		String query = SQLStatement.getSomethingFromWhere(result, table, condition);

		ResultSet rs = DBConn.query(query);

		while (rs.next()) {
			return rs.getString("name");
		}
		
		return "";
	}
}
