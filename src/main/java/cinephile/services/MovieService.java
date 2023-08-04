package cinephile.services;

import cinephile.DAO.MovieDAO;
import cinephile.DAO.exceptions.DAOException;
import cinephile.model.Movie;
import cinephile.services.exceptions.ServiceException;
import cinephile.validation.MovieValidation;
import cinephile.validation.exceptions.InvalidUserException;

public class MovieService {

	public boolean Movie(Movie movie) throws ServiceException {
		MovieDAO movieDAO = new MovieDAO();
		try { 
			MovieValidation.validateMovie(movie);
			if (movieDAO.Movie(movie)) {
				System.out.println(movie.getMovieId());
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) { 
			throw new ServiceException(e);
		}

	}

}
