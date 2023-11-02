package com.fssa.cinephile.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.cinephile.model.Watchlist;
import com.fssa.cinephile.services.exceptions.ServiceException;

public class TestWatchlistService {
	
	private WatchlistService watchlisttService = new WatchlistService();

	
	@Test
    void testAddWatchlistSuccess() {
	   
		Watchlist Watchlist = new Watchlist(2,3);
        try {
            assertTrue(watchlisttService.addWatchlist(Watchlist));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testAddWatchlistNullDetails() {
        ServiceException exception = assertThrows(ServiceException.class, () -> watchlisttService.addWatchlist(null));
        assertEquals("An error occurred while attempting to adding watchlist", exception.getMessage());
    }

    @Test
    void testDeleteWatchlistSuccess() {
        int watchlistId = 4;
        try {
            assertTrue(watchlisttService.removeWatchlist(watchlistId));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testDeleteWatchlistInvalidComment() {
        int commentId = 999; 
        ServiceException exception = assertThrows(ServiceException.class, () -> watchlisttService.removeWatchlist(commentId));
        assertEquals("An error occurred while attempting to delete watchlist", exception.getMessage());
    }
    
    @Test
	void testValidGetAllWatchlistByUser() {
		int userId = 1;

		try {
			watchlisttService.getMoviesInWatchlist(userId);
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testInvalidGetAllWatchlistByUser() {
		ServiceException exception = assertThrows(ServiceException.class, () -> watchlisttService.getMoviesInWatchlist(0));
		assertEquals("Watchlist is null", exception.getMessage());
	}
	
	


}
