package com.fssa.cinephile.services;

import java.util.List;

import com.fssa.cinephile.DAO.MovieDAO;
import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.Movie;
import com.fssa.cinephile.services.exceptions.ServiceException;
import com.fssa.cinephile.validation.MovieValidation;
import com.fssa.cinephile.validation.exceptions.ValidationException;

public class MovieService {

	public boolean createMovie(Movie movie) throws ServiceException {
		MovieDAO movieDAO = new MovieDAO();
		try { 
			MovieValidation.validateMovie(movie);
			if (movieDAO.addMovie(movie)) {
				System.out.println(movie.getMovieId()+" added");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | ValidationException e) { 
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
	            return MovieDAO.readMovies();
	        } catch (DAOException e) {
	            throw new ServiceException(e);
	        }
	    }
	    
	    
	public boolean updateMovie(Movie movie) throws ServiceException {
		MovieDAO movieDAO = new MovieDAO();
		try { 
			MovieValidation.validateMovie(movie);
			if (movieDAO.addMovie(movie)) {
				System.out.println(movie.getMovieId()+" successfully updated");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | ValidationException e) { 
			throw new ServiceException(e);
		}

	}
	
	public boolean deleteMovie(Movie movie) throws ServiceException {
		MovieDAO movieDAO = new MovieDAO();
		try { 
			MovieValidation.validateMovie(movie);
			if (movieDAO.addMovie(movie)) {
				System.out.println(movie.getMovieId()+" deleted");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | ValidationException e) { 
			throw new ServiceException(e);
		}

	}
	
	public boolean readMovie(Movie movie) throws ServiceException {
		MovieDAO movieDAO = new MovieDAO();
		try { 
			MovieValidation.validateMovie(movie);
			if (movieDAO.addMovie(movie)) {
				System.out.println(movie.getMovieId()+" movies are read!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | ValidationException e) { 
			throw new ServiceException(e);
		}

	}

}
