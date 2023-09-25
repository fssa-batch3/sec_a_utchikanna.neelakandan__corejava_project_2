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
    void testAddWatchlisttSuccess() {
	   
		Watchlist Watchlist = new Watchlist(1,2);
        try {
            assertTrue(watchlisttService.addwatchlist(Watchlist));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testAddCommentNullDetails() {
        ServiceException exception = assertThrows(ServiceException.class, () -> watchlisttService.addwatchlist(null));
        assertEquals("An error occurred while attempting to adding watchlist", exception.getMessage());
    }

    @Test
    void testDeleteCommentSuccess() {
        int watchlistId = 1;
        try {
            assertTrue(watchlisttService.removeWatchlist(watchlistId));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testDeleteCommentInvalidComment() {
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
		assertEquals("Rating object is null", exception.getMessage());
	}
	
	


}
