package com.fssa.cinephile.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for managing database connections.
 * 
 * @author UtchikannaNeelakanda
 */
public class ConnectionUtil {

    // Private constructor to prevent instantiation
    private ConnectionUtil() {
        // Do nothing (empty constructor)
    }

    /**
     * Establishes a connection to the database.
     *
     * @return A database connection.
     * @throws SQLException If a database access error occurs.
     */
    public static Connection getConnection(){
        // Database URL and credentials
        final String dbUrl;
        final String dbUser;
        final String dbPassword;

//      Cloud DB
        
            dbUrl = System.getenv("DB_URL");
            dbUser = System.getenv("DB_USER");
            dbPassword = System.getenv("DB_PASSWORD");
            
//            Local Host
            
//            dbUrl = "jdbc:mysql://localhost:3306/cinephile";
//            dbUser = "root";
//            dbPassword = "123456";
            
       
          
            try {
            	Class.forName("com.mysql.cj.jdbc.Driver");
				return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Unable to connect data base",e);
			}
            catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("data base Driver class not found",e);
			}
       
    }
}
