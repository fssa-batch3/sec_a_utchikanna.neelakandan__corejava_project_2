package com.fssa.cinephile.services;

import java.util.List;

import com.fssa.cinephile.DAO.WatchlistDAO;
import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.Movie;
import com.fssa.cinephile.model.Watchlist;
import com.fssa.cinephile.services.exceptions.ServiceException;

public class WatchlistService {
	
	private WatchlistDAO watchlistDAO = new WatchlistDAO();
	
	public boolean addwatchlist(Watchlist watchlist) throws ServiceException{
		
		try {
			if (watchlist == null) {
				throw new ServiceException("An error occurred while attempting to adding watchlist");
			}
			return watchlistDAO.AddWatchlist(watchlist);
		}catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	 public List<Movie> getMoviesInWatchlist(int userId) throws ServiceException {
	        try {
	            return watchlistDAO.getMoviesInUserWatchlist(userId);
	        } catch (DAOException e) {
	            throw new ServiceException(e.getMessage());
	        }
	    }
	 

	 public boolean removeWatchlist(int watchlistsId) throws ServiceException {
			try {
				System.out.println(watchlistsId);
				boolean watchlist = watchlistDAO.removeWatchlist(watchlistsId); 
				System.out.println(watchlist);
				if (!watchlist) {
					throw new ServiceException("An error occurred while attempting to delete watchlist");
				}
				return true;
			} catch (DAOException e) {
				throw new ServiceException(e.getMessage());
			}
		}
}
