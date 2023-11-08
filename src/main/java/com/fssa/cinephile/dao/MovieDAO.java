package com.fssa.cinephile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.cinephile.dao.exception.DAOException;
import com.fssa.cinephile.model.Movie;
import com.fssa.cinephile.util.ConnectionUtil;

/**
 * Data Access Object for interacting with Movie entities in the database.
 * 
 * @author UtchikannaNeelakandan
 */
public class MovieDAO {
	
	private static final String MOVIE_TYPE = "movie_type";
	private static final String MOVIE_TRAILER = "movie_trailer";
	private static final String MOVIE_ID = "movie_id";
	private static final String MOVIE_IMAGE_URL = "movie_image_url";
	private static final String MOVIE_TITLE = "movie_title";


	/**
	 * Adds a new Movie to the database.
	 *
	 * @param movie The Movie object to be added.
	 * @return True if the operation was successful, false otherwise.
	 * @throws DAOException If a database access error occurs.
	 */
	public boolean addMovie(Movie movie) throws DAOException {
		String insertQuery = "INSERT INTO movies (movie_title, movie_image_url,movie_trailer,movie_type) VALUES (?, ?, ?, ?)";
		try (
				Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery);) {
		
			statement.setString(1, movie.getMovieTitle());
			statement.setString(2, movie.getMovieImgUrl());
			statement.setString(3, movie.getMovieTrailer());
			statement.setString(4, movie.getMovieType());


			int rows = statement.executeUpdate();
			return (rows > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Retrieves a list of all active movies from the database.
	 *
	 * @return A list of Movie objects representing all active movies in the
	 *         database.
	 * @throws DAOException If there is an issue while attempting to retrieve the
	 *                      movies from the database. This exception wraps any
	 *                      underlying {@link SQLException}.
	 */
	public List<Movie> getAllMovies() throws DAOException {
		List<Movie> movieList = new ArrayList<>();
		String query = "SELECT * FROM movies WHERE isActive = true";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet rs = preparedStatement.executeQuery()) {

			while (rs.next()) {
				Movie movie = new Movie();
				movie.setMovieTitle(rs.getString(MOVIE_TITLE));
				movie.setMovieImgUrl(rs.getString(MOVIE_IMAGE_URL));
				movie.setMovieId(rs.getInt(MOVIE_ID));
				movie.setMovieTrailer(rs.getString(MOVIE_TRAILER));
				movie.setMovieType(rs.getString(MOVIE_TYPE));

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
		String selectQuery = "SELECT * FROM movies WHERE movie_title = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery);) {
			statement.setString(1, movie.getMovieTitle());

			try (ResultSet resultSet = statement.executeQuery()) {
				return resultSet.next();
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
 
	public List<Movie> movieFilter(String movieType) throws DAOException {
	    List<Movie> movieList = new ArrayList<>();
	    String selectQuery = "SELECT movie_trailer, movie_title, movie_image_url, movie_id FROM movies WHERE movie_type = ?";
	    
	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement statement = connection.prepareStatement(selectQuery)) {
	        
	        statement.setString(1, movieType); 
	        
	        try (ResultSet rs = statement.executeQuery()) {
	            while (rs.next()) {
	                Movie movie = new Movie();
	                movie.setMovieTrailer(rs.getString(MOVIE_TRAILER));
	                movie.setMovieTitle(rs.getString(MOVIE_TITLE));
	                movie.setMovieImgUrl(rs.getString(MOVIE_IMAGE_URL));
	                movie.setMovieId(rs.getInt(MOVIE_ID));
	                movie.setMovieType(movieType); // Set the movieType here
	                
	                movieList.add(movie);
	            }
	        }
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	    
	    return movieList;
	}
 
	/**
	 * Updates information about a Movie in the database.
	 *
	 * @param movie The Movie object with updated information.
	 * @return True if the update was successful, false otherwise.
	 * @throws DAOException If a database access error occurs.
	 */
	public boolean updateMovie(Movie movie) throws DAOException {
		String updateQuery = "UPDATE movies SET movie_title = ?, movie_image_url = ? , movie_trailer = ? , movie_type = ? WHERE movie_id = ?";
		try (
		
				Connection connection = ConnectionUtil.getConnection();
			
				PreparedStatement statement = connection.prepareStatement(updateQuery);) {
			statement.setString(1, movie.getMovieTitle());
			statement.setString(2, movie.getMovieImgUrl());
			statement.setString(3, movie.getMovieTrailer());
			statement.setString(4, movie.getMovieType());
			statement.setInt(5, movie.getMovieId());
		
			int rows = statement.executeUpdate();
		
			return (rows > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Retrieves a movie by its ID.
	 *
	 * @param movieId The ID of the movie
	 * @return The Movie object if found, otherwise null
	 * @throws DAOException If an error occurs during database operation
	 */

	public Movie getMovieById(int movieId) throws DAOException {
		Movie movie = null;
		String query = "SELECT * FROM movies WHERE movie_id = ? AND isActive = TRUE";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setInt(1, movieId);

			try (ResultSet rs = preparedStatement.executeQuery()) {
				if (rs.next()) {
				Movie movie1 = new Movie();
				movie1.setMovieTitle(rs.getString(MOVIE_TITLE));
				movie1.setMovieImgUrl(rs.getString(MOVIE_IMAGE_URL));
				movie1.setMovieId(rs.getInt(MOVIE_ID));
				movie1.setMovieTrailer(rs.getString(MOVIE_TRAILER));
				movie1.setMovieType(rs.getString(MOVIE_TYPE));
				
				movie = movie1;
				}
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return movie;
	}

		
	/**
	 * Marks a Movie as inactive in the database.
	 *
	 * @param movie The Movie object to be marked as inactive.
	 * @return True if the operation was successful, false otherwise.
	 * @throws DAOException If a database access error occurs.
	 */
	public boolean deleteMovie(int movieId) throws DAOException {
		String query = "UPDATE movies SET isActive = false WHERE movie_id = ?;";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query);) {
			pst.setInt(1, movieId);
			int rowsAffected = pst.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
