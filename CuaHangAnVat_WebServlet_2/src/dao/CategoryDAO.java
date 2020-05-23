package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Category;
import ultilities.DBClose;
import ultilities.DBConn;
import ultilities.SQLStatement;

public class CategoryDAO {

	public static ArrayList<Category> getAll() {
		DBConn dbConn = new DBConn();
		
		ArrayList<Category> categoriesList = new ArrayList<Category>();

		String query = SQLStatement.getAll("category");

		ResultSet rs = null;
		try {
			rs = dbConn.query(query);
			while (rs.next()) {
				Category categories = new Category(rs.getInt("category_id"), rs.getString("name"));
				categoriesList.add(categories);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.closeQuery(dbConn, rs);
		}

		return categoriesList;
	}

	public static String getCategoryNameFromID(int id) {
		String result = "*";
		String table= "category";
		String condition = "category_id = " + id;
		String query = SQLStatement.getSomethingFromWhere(result, table, condition);

		DBConn dbConn = new DBConn();
		
		ResultSet rs = null;
		
		try {
			rs = dbConn.query(query);
			while (rs.next()) {
				return rs.getString("name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBClose.closeQuery(dbConn, rs);
		}
		
		return "";
	}
}
