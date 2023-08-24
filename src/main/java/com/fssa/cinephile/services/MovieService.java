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
	            return movieDAO.readMovie(movie);

	        } catch (DAOException | ValidationException e) {
	            throw new ServiceException(e);
	        }
	    }
	    
	public boolean updateMovie(Movie movie) throws ServiceException {
		MovieDAO movieDAO = new MovieDAO();
		try { 
			MovieValidation.validateMovie(movie);
			if (movieDAO.updateMovie(movie)) {
				return true;
			} else {
				return false;
			}

		} catch (DAOException | ValidationException e) { 
			throw new ServiceException(e);
		}

	}
	
	public boolean deleteMovie(Movie movie) throws ServiceException {
		try { 
			MovieValidation.validateMovie(movie);
			if (MovieDAO.deleteMovie(movie)) {
				return true;
			} else {
				return false;
			}

		} catch (DAOException | ValidationException e) { 
			throw new ServiceException(e);
		}

	}
	
	

}
