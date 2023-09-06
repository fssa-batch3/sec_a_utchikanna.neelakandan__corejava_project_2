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
 * Data Access Object (DAO) for managing movie ratings in the database.
 * 
 * @author UtchikannaNeelakanda
 */
public class RatingDAO {

	/**
	 * Adds a movie rating to the database.
	 *
	 * @param rating The Rating object containing information about the rating to be
	 *               added.
	 * @return {@code true} if the rating was successfully added, {@code false}
	 *         otherwise.
	 * @throws DAOException If there is an issue while attempting to add the rating.
	 *                      This exception encapsulates any underlying
	 *                      {@link SQLException}.
	 */
	public boolean addRating(Rating rating) throws DAOException {
		String insertQuery = "INSERT INTO rating (rating, movie_id, user_id) VALUES (?, ?, ?)";
		try (
				// Get connection
				Connection connection = ConnectionUtil.getConnection();
				// Prepare SQL statement
				PreparedStatement statement = connection.prepareStatement(insertQuery);) {
			statement.setInt(1, rating.getRating());
			statement.setInt(2, rating.getMovie().getMovieId());
			statement.setInt(3, rating.getUser().getUserId());

			// Execute the query
			int rows = statement.executeUpdate();
			// Return successful or not
			return (rows > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Retrieves a list of all ratings from the database.
	 *
	 * @return A list of Rating objects representing all the ratings in the
	 *         database.
	 * @throws DAOException If there is an issue while attempting to retrieve the
	 *                      ratings. This exception encapsulates any underlying
	 *                      {@link SQLException}.
	 */
	public static List<Rating> getAllRatings() throws DAOException {
		List<Rating> ratingList = new ArrayList<>();
		String query = "SELECT * FROM rating";
		try (Connection connection = ConnectionUtil.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query);) {
			while (resultSet.next()) {
				int ratingValue = resultSet.getInt("rating");
				int movieId = resultSet.getInt("movie_id");
				int userId = resultSet.getInt("user_id");

				Movie movie = new Movie();
				movie.setMovieId(movieId);
				User user = new User();
				user.setUserId(userId);

				Rating rating = new Rating(ratingValue, movie, user);
				ratingList.add(rating);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return ratingList;
	}

	/**
	 * Checks if a rating with the specified ID exists in the database.
	 *
	 * @param rating The Rating object containing the ID of the rating to be
	 *               checked.
	 * @return {@code true} if the rating exists in the database, {@code false}
	 *         otherwise.
	 * @throws DAOException If there is an issue while attempting to check the
	 *                      rating's existence. This exception encapsulates any
	 *                      underlying {@link SQLException}.
	 */
	public boolean readRating(Rating rating) throws DAOException {
		String selectQuery = "SELECT * FROM rating WHERE rating_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery);) {
			statement.setInt(1, rating.getRatingId());

			try (ResultSet resultSet = statement.executeQuery()) {
				return resultSet.next();
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Updates a movie rating in the database.
	 *
	 * @param rating The Rating object containing updated rating information.
	 * @return {@code true} if the rating was successfully updated, {@code false}
	 *         otherwise.
	 * @throws DAOException If there is an issue while attempting to update the
	 *                      rating. This exception encapsulates any underlying
	 *                      {@link SQLException}.
	 */
	public boolean updateRating(Rating rating) throws DAOException {
		String updateQuery = "UPDATE rating SET rating = ? WHERE movie_id = ? AND user_id = ?";
		try (
				// Get connection
				Connection connection = ConnectionUtil.getConnection();
				// Prepare SQL statement
				PreparedStatement statement = connection.prepareStatement(updateQuery);) {
			statement.setInt(1, rating.getRating());
			statement.setInt(2, rating.getMovie().getMovieId());
			statement.setInt(3, rating.getUser().getUserId());

			// Execute the query
			int rows = statement.executeUpdate();
			// Return successful or not

			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
