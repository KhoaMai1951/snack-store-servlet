package ultilities;

public class SQLStatement {
	public static String getAll(String table)
	{
		return "SELECT * FROM " + table + " WHERE is_deleted = 0 ";
	}
	public static String add(String table, String colList, String valueList)
	{
		return "INSERT INTO "+table+"("+colList+") VALUES ("+valueList+")";
	}
	public static String getSomethingFromWhere(String result, String table, String condition)
	{
		return "SELECT "+result+" FROM "+table+" WHERE "+condition+"";
	}
	public static String delete(String table, String table_id, String id)
	{
		return "UPDATE "+table+" SET is_deleted = true WHERE "+table_id+" = "+id;
	}
}
