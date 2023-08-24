package com.fssa.cinephile.util;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for managing database connections.
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

        if (System.getenv("CI") != null) {
            dbUrl = System.getenv("DB_URL");
            dbUser = System.getenv("DB_USER");
            dbPassword = System.getenv("DB_PASSWORD");
        } else {
            Dotenv env = Dotenv.load();
            dbUrl = env.get("DB_URL");
            dbUser = env.get("DB_USER");
            dbPassword = env.get("DB_PASSWORD");
        }

        if (dbUrl != null) {
            return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        }
        return null;
    }
}
