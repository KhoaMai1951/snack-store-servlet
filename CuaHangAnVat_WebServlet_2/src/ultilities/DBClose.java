package ultilities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBClose
{
	// clean up resources (in resultSet, statement) after processing
	// close connection (conn)
	public static void closeQuery(DBConn dbConn, ResultSet currentRs)
	{
		if (null != dbConn.conn)
		{
			try
			{
				// clean up resources (in resultSet, statement) after processing
				dbConn.resultSet.close();
				dbConn.statement.close();
				// close connection (conn)
				dbConn.conn.close();
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (currentRs != null)
		{
			try
			{
				currentRs.close();
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// close connection (conn)
	public static void closeQuery(DBConnPoolTest dbConn, ResultSet currentRs)
	{
		if (null != dbConn.conn)
		{
			try
			{
				// clean up resources (in resultSet, statement) after processing
				dbConn.resultSet.close();
				dbConn.statement.close();
				// close connection (conn)
				dbConn.conn.close();
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (currentRs != null)
		{
			try
			{
				currentRs.close();
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// close connection (conn)
	public static void closeUpdate(DBConn dbConn)
	{
		if (null != dbConn.conn)
		{
			try
			{
				dbConn.statement.close();
				dbConn.conn.close();
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
