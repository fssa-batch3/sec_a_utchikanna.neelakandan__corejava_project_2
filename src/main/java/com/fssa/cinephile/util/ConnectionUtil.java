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
    public static Connection getConnection() throws SQLException {
        // Database URL and credentials
        final String dbUrl;
        final String dbUser;
        final String dbPassword;

      
            dbUrl = System.getenv("DB_URL");
            dbUser = System.getenv("DB_USER");
            dbPassword = System.getenv("DB_PASSWORD");
       
          
            return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
       
    }
}
