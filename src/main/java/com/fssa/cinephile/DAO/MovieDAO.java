package com.fssa.cinephile.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.Movie;

import io.github.cdimascio.dotenv.Dotenv;

public class MovieDAO {

public static Connection getConnection() throws SQLException {
		
		String DB_URL;
		String DB_USER;
		String DB_PASSWORD;
		Connection connection = null;
		if (System.getenv("CI") != null) {
			DB_URL = System.getenv("DB_URL");
			DB_USER = System.getenv("DB_USER");
			DB_PASSWORD = System.getenv("DB_PASSWORD");
		} else {
			Dotenv env = Dotenv.load();
			DB_URL = env.get("DB_URL");
			DB_USER = env.get("DB_USER");
			DB_PASSWORD = env.get("DB_PASSWORD");
		}
		try {
	  connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to connect");
		}
		return connection;

	}
		
		  public static Movie getMovieByTitle(String title) throws DAOException {
			  Movie movie = null;
			  String query = "SELECT * FROM movie WHERE movie_title = ? AND isActive = true ;";
			  ;
		        try (
		        	// Get connection
					Connection connection = getConnection();

					// Prepare SQL statement
                        
					PreparedStatement statement = connection.prepareStatement(query);
					){
		        	statement.setString(1, title);
		            try (ResultSet rs = statement.executeQuery()) {
		                if (rs.next()) {
		                     movie = new Movie();
			            	movie.setMovieTitle(rs.getString("movie_title"));
			            	movie.setMovieImgUrl(rs.getString("movie_image_url"));
			            	movie.setMovieRating(rs.getInt("movie_rating"));
			            	movie.setMovieId(rs.getInt("movie_id"));
		                    
		                }
		            }

		        } catch (SQLException e) {
		            throw new DAOException(e);
		        }
		        return movie;
		    }
		  
		  
		public boolean addMovie(Movie movie) throws DAOException {
			String insertQuery = "Insert INTO movie (movie_title,movie_id, movie_rating , movie_image_url) VALUES(?,?,?,?)";
			try (
				// Get connection
				Connection connection = getConnection();
				// Prepare SQL statement
				PreparedStatement statement = connection.prepareStatement(insertQuery);){
				
				statement.setString(1, movie.getMovieTitle());
				statement.setInt(2, movie.getMovieId());
				statement.setInt(3, movie.getMovieRating());
				statement.setString(4, movie.getMovieImgUrl());
				

				// Execute the query
				int rows = statement.executeUpdate();
				// Return successful or not
				return (rows == 1);
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		
		 public static List<Movie> readMovies() throws DAOException {
		        List<Movie> movieList = new ArrayList<>();
		        String query = "SELECT * FROM movie WHERE isActive = true;;";
		        try  (
		        	Connection connection = getConnection();
		        	
					PreparedStatement statement = connection.prepareStatement(query);){
					 ResultSet rs = statement.executeQuery();
		            while (rs.next()) {
		            	Movie movie = new Movie();
		            	movie.setMovieTitle(rs.getString("movie_title"));
		            	movie.setMovieImgUrl(rs.getString("movie_image_url"));
		            	movie.setMovieRating(rs.getInt("movie_rating"));
		            	movie.setMovieId(rs.getInt("movie_id"));
		                
		            	movieList.add(movie);
		            }
		        } catch (SQLException e) {
		            throw new DAOException(e);
		        }
		        return movieList;
		    }
		
		 public boolean updateMovie(Movie movie) throws DAOException {
			    String updateQuery = "UPDATE Movie SET movie_title = ?, movie_rating = ?, movie_image_url = ? WHERE movie_id = ?";
			    try (
			        // Get connection
			        Connection connection = getConnection();
			        // Prepare SQL statement
			        PreparedStatement statement = connection.prepareStatement(updateQuery);
			    ){
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


		    public static boolean deleteMovie(String title) throws DAOException {
		        String query = "UPDATE movie SET isActive = false WHERE title = ?;";
		        try (Connection connection = getConnection();
		             PreparedStatement pst = connection.prepareStatement(query)) {

		            pst.setString(1, title);

		            int rowsAffected = pst.executeUpdate();
		            return rowsAffected > 0;
		        } catch (SQLException e) {
		            throw new DAOException(e);
		        }
		    }

			

}
