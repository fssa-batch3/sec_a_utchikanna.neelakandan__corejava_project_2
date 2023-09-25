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

public class CastsDAO {
	
	
public boolean addCasts (Casts casts) throws DAOException{
		
		String query = "INSERT INTO casts (movie_id, actor_wiki, actor_img, actor_name) VALUES (?, ?, ?, ?)";
		try(
				Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);
				
				){
			       statement.setInt(1, casts.getMovieId());
			       statement.setString(2, casts.getActorLink());
					statement.setString(3, casts.getActorImage());
					statement.setString(4, casts.getActorName());	
					
					int rows = statement.executeUpdate();
					return (rows > 0);
				}catch (SQLException e) {
					throw new DAOException(e);
				}
	}


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


	
	
	public boolean updateCasts(Casts casts) throws DAOException {
		String updateQuery = "UPDATE casts SET actor_name = ?, actor_img = ?, actor_wiki = ?, movie_id = ? WHERE cast_id= ? ";
		try (
				// Get connection
				Connection connection = ConnectionUtil.getConnection();
				// Prepare SQL statement
				PreparedStatement statement = connection.prepareStatement(updateQuery);) {
			statement.setString(1, casts.getActorImage());
			statement.setInt(2, casts.getCastsId());
			statement.setString(3, casts.getActorLink());
			statement.setString(4, casts.getActorName());
			statement.setInt(5, casts.getMovieId());
			// Execute the query
			int rows = statement.executeUpdate();
			// Return successful or not

			return (rows > 0);

		} catch (SQLException | NullPointerException e) {
			throw new DAOException(e);
		}
	}

	
	public boolean deleteCasts(int castsId) throws DAOException {
		String query = "DELETE FROM casts WHERE cast_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(query);) {
			pst.setInt(1, castsId);
			int rowsAffected = pst.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}
