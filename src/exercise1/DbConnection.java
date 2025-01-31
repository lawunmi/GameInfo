package exercise1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection 
{
			//static String dbURL = "jdbc:oracle:thin:@ 199.212.26.208:1521:SQLD";
			static String dbURL = "jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD";
			static String username = "COMP228_W24_sy_24";
			static String password = "password";
			
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
