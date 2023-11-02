package com.fssa.cinephile.services;

import java.util.List;

import com.fssa.cinephile.DAO.WatchlistDAO;
import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.Movie;
import com.fssa.cinephile.model.Watchlist;
import com.fssa.cinephile.services.exceptions.ServiceException;

public class WatchlistService {
	
	
	private WatchlistDAO watchlistDAO = new WatchlistDAO();
	
	public boolean addWatchlist(Watchlist watchlist) throws ServiceException{
		
		try {
			if (watchlist == null) {
				throw new ServiceException("An error occurred while attempting to adding watchlist");
			}
			return watchlistDAO.addWatchlist(watchlist);
		}catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	 public List<Movie> getMoviesInWatchlist(int userId) throws ServiceException {
	        try {
	        	List<Movie> watchlist = watchlistDAO.getMoviesInUserWatchlist(userId);
	             if(watchlist == null) {
	            	 throw new ServiceException("Watchlist is null");
	            }else {
	            	return watchlist;
	            }
	        } catch (DAOException e) {
	            throw new ServiceException(e.getMessage());
	        }
	    }
	 

	 public boolean removeWatchlist(int watchlistsId) throws ServiceException {
			try {
		
				boolean watchlist = watchlistDAO.removeWatchlist(watchlistsId); 
		
				if (!watchlist) {
					throw new ServiceException("An error occurred while attempting to delete watchlist");
				}
				return true;
			} catch (DAOException e) {
				throw new ServiceException(e.getMessage());
			}
		}
}
