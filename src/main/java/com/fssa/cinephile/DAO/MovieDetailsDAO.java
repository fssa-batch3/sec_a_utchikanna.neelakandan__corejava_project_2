package com.fssa.cinephile.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.Movie;
import com.fssa.cinephile.model.MovieDetails;
import com.fssa.cinephile.util.ConnectionUtil;

/**
 * Data Access Object for interacting with MovieDetails entities in the
 * database.
 * 
 * @author UtchikannaNeelakandan
 */


public class MovieDetailsDAO {
	/**
	 * Adds new movie details to the database.
	 *
	 * @param movieDetails The MovieDetails object to be added.
	 * @return True if the operation was successful, false otherwise.
	 * @throws DAOException If a database access error occurs.
	 */
	public boolean addMovieDetails(MovieDetails movieDetails) throws DAOException {
		String insertQuery = "INSERT INTO movieDetails (story, release_date, award_name, award_wiki, movie_link, director_name, director_wiki, movie_id) VALUES (?, ?, ?, ?, ?, ?, ? , ?)";
		try (
	
				Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery);) {
			statement.setString(1, movieDetails.getStory());
			statement.setString(2, movieDetails.getReleaseDate());
			statement.setString(3, movieDetails.getAwardName());
			statement.setString(4, movieDetails.getAwardWiki());
			statement.setString(5, movieDetails.getMovieLink());
			statement.setString(6, movieDetails.getDirectorName());
			statement.setString(7, movieDetails.getDirectorWiki());
			statement.setInt(8, movieDetails.getMovie().getMovieId());

	
			int rows = statement.executeUpdate();
	
			return (rows > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Retrieves information about movie details by its ID from the database.
	 *
	 * @param movieId The ID of the movie details.
	 * @return The MovieDetails object if found, otherwise null.
	 * @throws DAOException If a database access error occurs.
	 */
	 public MovieDetails getAllMovieDetailsWithMovies(int movieId) throws DAOException {
		 MovieDetails movieDetailsList = new MovieDetails();
	        String query = "SELECT " +
	                "md.movie_details_id, md.story, md.release_date, md.award_name, md.award_wiki, md.movie_link, md.director_name, md.director_wiki," +
	                "m.movie_title, m.movie_image_url, m.movie_trailer, m.movie_type, m.movie_id " +
	                "FROM movieDetails md " +
	                "INNER JOIN movies m ON md.movie_id = m.movie_id WHERE md.movie_id = ?";

	        try (Connection connection = ConnectionUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query);
	             ) {
	        	preparedStatement.setInt(1, movieId);
	        	ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	                MovieDetails movieDetails = new MovieDetails();
	                movieDetails.setMovieDetailsId(rs.getInt("movie_details_id"));
	                movieDetails.setStory(rs.getString("story"));
	                movieDetails.setReleaseDate(rs.getString("release_date"));
	                movieDetails.setAwardName(rs.getString("award_name"));
	                movieDetails.setAwardWiki(rs.getString("award_wiki"));
	                movieDetails.setMovieLink(rs.getString("movie_link"));
	                movieDetails.setDirectorName(rs.getString("director_name"));
	                movieDetails.setDirectorWiki(rs.getString("director_wiki"));

	                Movie movie = new Movie();
	                movie.setMovieTitle(rs.getString("movie_title"));
	                movie.setMovieImgUrl(rs.getString("movie_image_url"));
	                movie.setMovieTrailer(rs.getString("movie_trailer"));
	                movie.setMovieType(rs.getString("movie_type"));
	                movie.setMovieId(rs.getInt("movie_id"));

	                movieDetails.setMovie(movie);
	                movieDetailsList = movieDetails;
	            }

	        } catch (SQLException e) {
	            throw new DAOException(e);
	        }
	        return movieDetailsList;
	}

	/**
	 * Updates information about movie details in the database.
	 *
	 * @param movieDetails The MovieDetails object with updated information.
	 * @return True if the update was successful, false otherwise.
	 * @throws DAOException If a database access error occurs.
	 */
	public boolean updateMovieDetails(MovieDetails movieDetails) throws DAOException {
		String updateQuery = "UPDATE movieDetails SET story = ?, release_date = ?, award_name = ?, award_wiki = ?, movie_link = ?, director_name = ?, director_wiki = ? WHERE movie_details_id = ?";
		try (
		
				Connection connection = ConnectionUtil.getConnection();
			
				PreparedStatement statement = connection.prepareStatement(updateQuery);) {
			statement.setString(1, movieDetails.getStory());
			statement.setString(2, movieDetails.getReleaseDate());
			statement.setString(3, movieDetails.getAwardName());
			statement.setString(4, movieDetails.getAwardWiki());
			statement.setString(5, movieDetails.getMovieLink());
			statement.setString(6, movieDetails.getDirectorName());
			statement.setString(7, movieDetails.getDirectorWiki());
			statement.setInt(8, movieDetails.getMovieDetailsId());

			
			int rows = statement.executeUpdate();
		
			return (rows > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Marks movie details as inactive in the database.
	 *
	 * @param movieDetailsId The ID of the movie details to be marked as inactive.
	 * @return True if the operation was successful, false otherwise.
	 * @throws DAOException If a database access error occurs.
	 */
	public boolean deleteMovieDetails(int movieDetailsId) throws DAOException {
		String query = "DELETE FROM movieDetails WHERE movie_details_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query);) {
			pst.setInt(1, movieDetailsId);
			int rowsAffected = pst.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
