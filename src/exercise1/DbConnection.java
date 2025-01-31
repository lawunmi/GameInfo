package exercise1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection 
{
			static String dbURL = "";
			static String username = "";
			static String password = "";
			
			public static Connection getDBConnection() {
				Connection conn = null;
				try {
					conn = DriverManager.getConnection(dbURL, username, password);
					System.out.println("Database connected");
				} catch(SQLException e) {
					e.printStackTrace();
				}
				return conn;
			}
			
}
