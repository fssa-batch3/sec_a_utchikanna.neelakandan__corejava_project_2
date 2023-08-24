package com.fssa.cinephile.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.User;
import com.fssa.cinephile.util.ConnectionUtil;

/**
 * Data Access Object for interacting with User entities in the database.
 * 
 *   @author UtchikannaNeelakandan
 */
public class UserDAO {

    // Connect to database

    /**
     * Checks if a user with the given email and password exists in the database.
     *
     * @param email    The email of the user to be checked.
     * @param password The password of the user to be checked.
     * @return True if the user exists and the provided password is correct, false otherwise.
     * @throws DAOException If a database access error occurs.
     */
    public boolean checkUserLogin(String email, String password) throws DAOException {
        try {
            // Get connection
            Connection connection = ConnectionUtil.getConnection();

            // Prepare SQL statement
            String selectQuery = "SELECT * FROM user WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(selectQuery);
            statement.setString(1, email);

            ResultSet rs = statement.executeQuery();

            boolean userExists = rs.next();
            if (userExists) {
                System.out.println("User is there.");
                String storedPassword = rs.getString("password");
                System.out.println(storedPassword);

                if (storedPassword.equals(password)) {
                    System.out.println("Log in successfully");
                } else {
                    System.out.println("Bad credentials");
                }
            } else {
                System.out.println("User credentials are not there");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return true;
    }

    /**
     * Creates a new user in the database.
     *
     * @param user The User object representing the user to be created.
     * @return True if the user creation was successful, false otherwise.
     * @throws DAOException If a database access error occurs.
     */
    public boolean createUser(User user) throws DAOException {
        try {
            // Get connection
            Connection connection = ConnectionUtil.getConnection();

            // Prepare SQL statement
            String insertQuery = "INSERT INTO user (email, password, first_name, last_name, phone_no) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setInt(5, user.getPhoneNo());

            // Execute the query
            int rows = statement.executeUpdate();

            // Return successful or not
            return (rows == 1);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
