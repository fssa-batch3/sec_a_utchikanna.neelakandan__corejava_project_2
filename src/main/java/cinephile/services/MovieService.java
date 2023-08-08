package cinephile.services;

import java.util.List;

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
				System.out.println(movie.getMovieId()+" added");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) { 
			throw new ServiceException(e);
		}

	}
	
	  public Movie getMovieByName(String title) throws ServiceException {
	        try {
	        	Movie movie = MovieDAO.getMovieByTitle(title);
	            if (movie == null) {
	                throw new ServiceException(title);
	            }
	            return movie;
	        } catch (DAOException e) {
	            throw new ServiceException(e);
	        }
	    }

	  
	    public List<Movie> getAllMovies() throws ServiceException {
	        try {
	            return MovieDAO.getAllMovies();
	        } catch (DAOException e) {
	            throw new ServiceException(e);
	        }
	    }
	    
	    
	public boolean updateMovie(Movie movie) throws ServiceException {
		MovieDAO movieDAO = new MovieDAO();
		try { 
			MovieValidation.validateMovie(movie);
			if (movieDAO.Movie(movie)) {
				System.out.println(movie.getMovieId()+" successfully updated");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) { 
			throw new ServiceException(e);
		}

	}
	
	public boolean deleteMovie(Movie movie) throws ServiceException {
		MovieDAO movieDAO = new MovieDAO();
		try { 
			MovieValidation.validateMovie(movie);
			if (movieDAO.Movie(movie)) {
				System.out.println(movie.getMovieId()+" deleted");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) { 
			throw new ServiceException(e);
		}

	}
	
	public boolean readMovie(Movie movie) throws ServiceException {
		MovieDAO movieDAO = new MovieDAO();
		try { 
			MovieValidation.validateMovie(movie);
			if (movieDAO.Movie(movie)) {
				System.out.println(movie.getMovieId()+" movies are read!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) { 
			throw new ServiceException(e);
		}

	}

}
