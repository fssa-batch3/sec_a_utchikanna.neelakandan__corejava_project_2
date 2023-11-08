
package com.fssa.cinephile.services;

import java.util.List;

import com.fssa.cinephile.dao.CastsDAO;
import com.fssa.cinephile.dao.exception.DAOException;
import com.fssa.cinephile.model.Casts;
import com.fssa.cinephile.services.exceptions.ServiceException;
import com.fssa.cinephile.validation.CastsValidation;
import com.fssa.cinephile.validation.exceptions.ValidationException;


public class CastsService {
	private CastsDAO castsDAO = new CastsDAO();
	private CastsValidation castsValidation = new CastsValidation();
	
	public boolean addCasts(Casts casts) throws ServiceException{
		
		try {
			if(casts == null) {
				throw new ServiceException("casts object cannot be null");
			}
			castsValidation.validateCasts(casts);
			if(!castsDAO.addCasts(casts)) {
				return false;
			}
			return true;
			
		}catch (DAOException | ValidationException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	 public List<Casts> getAllCastsByMovie(int movieId) throws ServiceException {
	        try {
	            return castsDAO.getCastsByMovie(movieId);
	        } catch (DAOException e) {
	            throw new ServiceException(e.getMessage());
	        }
	    }
	 
	 public boolean updateCasts(Casts casts) throws ServiceException {
			
			try {
				if (casts == null) {
					throw new ServiceException("An error occurred while attempting to update casts");
				}
				castsValidation.validateCasts(casts);
				castsDAO.updateCasts(casts);
				return true;

			} catch (DAOException | ValidationException e) {
				throw new ServiceException(e.getMessage());
			}

		}
	 
	 public boolean deleteCasts(int castsId) throws ServiceException {
			try {
				
				boolean casts = castsDAO.deleteCasts(castsId); 
				if (!casts) {
					throw new ServiceException("An error occurred while attempting to delete casts");
				}
				return true;
			} catch (DAOException e) {
				throw new ServiceException(e.getMessage());
			}
		}

}
