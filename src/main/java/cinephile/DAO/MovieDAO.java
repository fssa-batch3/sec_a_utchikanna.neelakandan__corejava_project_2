package cinephile.DAO;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		
		public boolean Movie(Movie movie) throws DAOException {

			try {
				// Get connection
				Connection connection = getConnection();

				// Prepare SQL statement
				String insertQuery = "Insert INTO Movie (movie_title,movie_id, movie_rating , movie_image) VALUES(?,?,?,?)";
				PreparedStatement statement = connection.prepareStatement(insertQuery);
				statement.setString(1, movie.getMovieTitle());
				statement.setInt(2, movie.getMovieId());
				statement.setInt(3, movie.getMovieRating());
				statement.setString(4, movie.getMovieImg());
				

				// Execute the query
				int rows = statement.executeUpdate();
				// Return successful or not
				return (rows == 1);
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		
		 public static  Movie updateMovie(Movie movie) throws DAOException {
		        StringBuilder queryBuilder = new StringBuilder("UPDATE books SET ");
		        List<String> setColumns = new ArrayList<>();
		        List<Object> setValues = new ArrayList<>();

		        if (movie.getMovieTitle() != null) {
		            setColumns.add("movie_title = ?");
		            setValues.add(movie.getMovieTitle());
		        }
		        if (movie.getMovieImg() != null) {
		            setColumns.add("movie_image_url = ?");
		            setValues.add(movie.getMovieImg());
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
		        String query = "UPDATE addmovie SET isActive = false WHERE title = ?;";
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
