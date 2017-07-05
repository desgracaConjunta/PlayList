package sqlServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Coneccao {
	public static Connection getConnection() {
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=PlayList", "sa", "qwerty");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public static String cleanQuery(String query){
		query = query.replace("'", "");
		 
		 return query;
	}
}
