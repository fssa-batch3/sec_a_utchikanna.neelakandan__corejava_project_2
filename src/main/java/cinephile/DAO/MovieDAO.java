package cinephile.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cinephile.DAO.exceptions.DAOException;
import cinephile.model.Movie;

public class MovieDAO {

	// Connect to database
		public static Connection getConnection() throws SQLException {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinephile", "root", "123456");
			return connection;
		}
		
		  public static Movie getMovieByTitle(String title) throws DAOException {
			  Movie movie = null;
		       
		        try {
		        	// Get connection
					Connection connection = getConnection();

					// Prepare SQL statement
                        String query = "SELECT * FROM movie WHERE movie_title = ? AND isActive = true ;";
;
					PreparedStatement statement = connection.prepareStatement(query);
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
		  
		  
		public boolean Movie(Movie movie) throws DAOException {

			try {
				// Get connection
				Connection connection = getConnection();

				// Prepare SQL statement
				String insertQuery = "Insert INTO Movie (movie_title,movie_id, movie_rating , movie_image_url) VALUES(?,?,?,?)";
				PreparedStatement statement = connection.prepareStatement(insertQuery);
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
		
		 public static List<Movie> getAllMovies() throws DAOException {
		        List<Movie> movieList = new ArrayList<>();
		       
		        try  {
		        	Connection connection = getConnection();
		        	 String query = "SELECT * FROM movie WHERE isActive = true;;";
					PreparedStatement statement = connection.prepareStatement(query);
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
		
		 public static  Movie updateMovie(Movie movie) throws DAOException {
		        StringBuilder queryBuilder = new StringBuilder("UPDATE movie SET ");
		        List<String> setColumns = new ArrayList<>();
		        List<Object> setValues = new ArrayList<>();

		        if (movie.getMovieTitle() != null) {
		            setColumns.add("movie_title = ?");
		            setValues.add(movie.getMovieTitle());
		        }
		        if (movie.getMovieImgUrl() != null) {
		            setColumns.add("movie_image_url = ?");
		            setValues.add(movie.getMovieImgUrl());
		        }
		        if (movie.getMovieId() != 0) {
		            setColumns.add("movie_id = ?");
		            setValues.add(movie.getMovieId());
		        }
		        if (movie.getMovieRating() != 0) {
		            setColumns.add("movie_rating = ?");
		            setValues.add(movie.getMovieRating());
		        }


		        if (setColumns.isEmpty()) {
		            return movie;
		        }
		        queryBuilder.append(String.join(", ", setColumns));
		        queryBuilder.append(" WHERE movie_id = ?;");
		        try (Connection connection = getConnection();
		             PreparedStatement pst = connection.prepareStatement(queryBuilder.toString())) {

		            int index = 1;
		            for (Object value : setValues) {
		                pst.setObject(index++, value);
		            }
		            pst.setInt(index, movie.getMovieId());

		            int rowsAffected = pst.executeUpdate();
		            if (rowsAffected > 0) {
		                return movie;
		            }
		        } catch (SQLException e) {
		            throw new DAOException(e);
		        }
				return movie;
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
