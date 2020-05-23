package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Category;
import ultilities.DBConn;
import ultilities.SQLStatement;

public class CategoryDAO {

	public static ArrayList<Category> getAll() {
		DBConn dbConn = new DBConn();
		
		ArrayList<Category> categoriesList = new ArrayList<Category>();

		String query = SQLStatement.getAll("category");

		ResultSet rs;
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
			if(null != dbConn.conn)
			{
				try {
					dbConn.statement.close();
					dbConn.resultSet.close();
					dbConn.conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return categoriesList;
	}

	public static String getCategoryNameFromID(int id) {
		String result = "*";
		String table= "category";
		String condition = "category_id = " + id;
		String query = SQLStatement.getSomethingFromWhere(result, table, condition);

		
//		ResultSet rs = DBConn.query(query);
//
//		while (rs.next()) {
//			return rs.getString("name");
//		}
		
		DBConn dbConn = new DBConn();
		
		try {
			ResultSet rs = dbConn.query(query);
			while (rs.next()) {
				return rs.getString("name");
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
		
		return "";
	}
}
