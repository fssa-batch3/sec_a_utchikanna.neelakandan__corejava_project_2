package com.fssa.cinephile.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.Movie;
import com.fssa.cinephile.model.Rating;
import com.fssa.cinephile.model.User;
import com.fssa.cinephile.util.ConnectionUtil;

/**
 * Data Access Object for interacting with Movie entities in the database.
 * 
 *   @author UtchikannaNeelakandan
 */
public class MovieDAO {

    /**
     * Adds a new Movie to the database.
     *
     * @param movie The Movie object to be added.
     * @return True if the operation was successful, false otherwise.
     * @throws DAOException If a database access error occurs.
     */
    public boolean addMovie(Movie movie) throws DAOException {
        String insertQuery = "INSERT INTO movie ( movie_rating,movie_title, movie_image_url) VALUES (?, ?, ?)";
        try (
            // Get connection
            Connection connection = ConnectionUtil.getConnection();
            // Prepare SQL statement
            PreparedStatement statement = connection.prepareStatement(insertQuery);
        ) {
            statement.setInt(1, movie.getMovieRating());
            statement.setString(2, movie.getMovieTitle());
            statement.setString(3, movie.getMovieImgUrl());

            // Execute the query
            int rows = statement.executeUpdate();
            // Return successful or not
            return (rows > 0);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    /**
     * Retrieves a list of all active movies from the database.
     *
     * @return A list of Movie objects representing all active movies in the database.
     * @throws DAOException If there is an issue while attempting to retrieve the movies from the database.
     *                     This exception wraps any underlying {@link SQLException}.
     */
    public List<Movie> getAllMovies() throws DAOException {
        List<Movie> movieList = new ArrayList<>();
        String query = "SELECT * FROM movie WHERE isActive = true";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet rs = preparedStatement.executeQuery()) {

            // Iterate through the result set and populate the movieList
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setMovieRating(rs.getInt("movie_rating"));
                movie.setMovieTitle(rs.getString("movie_title"));   
                movie.setMovieImgUrl(rs.getString("movie_image_url"));
                
                movieList.add(movie);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return movieList;
    }

    /**
     * Retrieves information about a Movie from the database.
     *
     * @param movie The Movie object to be retrieved.
     * @return True if the Movie exists in the database, false otherwise.
     * @throws DAOException If a database access error occurs.
     */
    public boolean readMovie(Movie movie) throws DAOException {
        String selectQuery = "SELECT * FROM movie WHERE movie_title = ?";
        try (
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(selectQuery);
        ) {
            statement.setString(1, movie.getMovieTitle());

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Updates information about a Movie in the database.
     *
     * @param movie The Movie object with updated information.
     * @return True if the update was successful, false otherwise.
     * @throws DAOException If a database access error occurs.
     */
    public boolean updateMovie(Movie movie) throws DAOException {
        String updateQuery = "UPDATE movie SET movie_title = ?, movie_rating = ?, movie_image_url = ? WHERE movie_id = ?";
        try (
            // Get connection
            Connection connection = ConnectionUtil.getConnection();
            // Prepare SQL statement
            PreparedStatement statement = connection.prepareStatement(updateQuery);
        ) {
            statement.setString(1, movie.getMovieTitle());
            statement.setInt(2, movie.getMovieRating());
            statement.setString(3, movie.getMovieImgUrl());
            statement.setInt(4, movie.getMovieId());

            // Execute the query
            int rows = statement.executeUpdate();
            // Return successful or not
            return (rows > 0);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Marks a Movie as inactive in the database.
     *
     * @param movie The Movie object to be marked as inactive.
     * @return True if the operation was successful, false otherwise.
     * @throws DAOException If a database access error occurs.
     */
    public static boolean deleteMovie(Movie movie) throws DAOException {
        String query = "UPDATE movie SET isActive = false WHERE movie_title = ?;";
        try (
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement pst = connection.prepareStatement(query);
        ) {
            pst.setString(1, movie.getMovieTitle());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
