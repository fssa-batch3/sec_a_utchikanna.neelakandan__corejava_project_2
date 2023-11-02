package com.fssa.cinephile.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.Casts;
import com.fssa.cinephile.util.ConnectionUtil;


/**
 * Data Access Object for interacting with Cast entities in the database.
 * 
 * @author UtchikannaNeelakandan
 */

public class CastsDAO {
	

	/**
	 * Adds cast information to the database.
	 *
	 * @param casts The Casts object to add.
	 * @return true if the insertion was successful, false otherwise.
	 * @throws DAOException If a database error occurs.
	 */
	public boolean addCasts(Casts casts) throws DAOException {
	    String query = "INSERT INTO casts (movie_id, actor_wiki, actor_img, actor_name) VALUES (?, ?, ?, ?)";
	    try (
	        Connection connection = ConnectionUtil.getConnection();
	        PreparedStatement statement = connection.prepareStatement(query);
	    ) {
	        statement.setInt(1, casts.getMovieId());
	        statement.setString(2, casts.getActorLink());
	        statement.setString(3, casts.getActorImage());
	        statement.setString(4, casts.getActorName());

	        int rows = statement.executeUpdate();
	        return (rows > 0);
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	}

	/**
	 * Retrieves a list of casts for a specific movie.
	 *
	 * @param movieId The ID of the movie to retrieve casts for.
	 * @return A list of Casts objects for the specified movie.
	 * @throws DAOException If a database error occurs.
	 */
	private static final String GET_CASTS_BY_MOVIE_QUERY =
			"SELECT actor_name, actor_wiki, actor_img, cast_id FROM casts WHERE movie_id = ?";
	public List<Casts> getCastsByMovie(int movieId) throws DAOException {
	    List<Casts> casts = new ArrayList<>();

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pst = connection.prepareStatement(GET_CASTS_BY_MOVIE_QUERY)) {

	        pst.setInt(1, movieId);
	        ResultSet resultSet = pst.executeQuery();

	        while (resultSet.next()) {
	            Casts cast = new Casts();
	            cast.setActorName(resultSet.getString("actor_name"));
	            cast.setActorLink(resultSet.getString("actor_wiki"));
	            cast.setActorImage(resultSet.getString("actor_img"));
	            cast.setCastsId(resultSet.getInt("cast_id"));
	            casts.add(cast);
	        }

	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }

	    return casts;
	}

	/**
	 * Updates cast information in the database.
	 *
	 * @param casts The Casts object with updated information.
	 * @return true if the update was successful, false otherwise.
	 * @throws DAOException If a database error occurs.
	 */
	public boolean updateCasts(Casts casts) throws DAOException {
	    String updateQuery = "UPDATE casts SET actor_name = ?, actor_img = ?, actor_wiki = ?, movie_id = ? WHERE cast_id= ? ";
	    try (
	        Connection connection = ConnectionUtil.getConnection();
	        PreparedStatement statement = connection.prepareStatement(updateQuery);
	    ) {
	        statement.setString(1, casts.getActorImage());
	        statement.setInt(2, casts.getCastsId());
	        statement.setString(3, casts.getActorLink());
	        statement.setString(4, casts.getActorName());
	        statement.setInt(5, casts.getMovieId());

	        int rows = statement.executeUpdate();
	        return (rows > 0);
	    } catch (SQLException | NullPointerException e) {
	        throw new DAOException(e);
	    }
	}

	/**
	 * Deletes cast information from the database.
	 *
	 * @param castsId The ID of the cast to delete.
	 * @return true if the deletion was successful, false otherwise.
	 * @throws DAOException If a database error occurs.
	 */
	public boolean deleteCasts(int castsId) throws DAOException {
	    String query = "DELETE FROM casts WHERE cast_id = ?";
	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pst = connection.prepareStatement(query);
	    ) {
	        pst.setInt(1, castsId);
	        int rowsAffected = pst.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	}
	
}
