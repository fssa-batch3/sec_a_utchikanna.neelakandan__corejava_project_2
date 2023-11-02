package com.fssa.cinephile.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.cinephile.model.Casts;
import com.fssa.cinephile.services.exceptions.ServiceException;

/**
 * Test class for the CastsService methods.
 * 
 * @author UtchikannaNeelakandan
 */
public class TestCastsService {

	private CastsService castsService = new CastsService();
	private Casts casts = new Casts();
	@Test
	void testAddCastsSuccess() {
		
		casts.setActorImage("https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		casts.setActorLink("https://www.youtube.com/embed/qN3wfuPYTI4?si=sTD-qk1ZBuOsUkUY");
		casts.setMovieId(7);
		casts.setActorName("Vijay");
		
		try {
			assertTrue(castsService.addCasts(casts));
		}catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	void testAddCastsNullDetails() {
		
		ServiceException exception = assertThrows(ServiceException.class, () -> castsService.addCasts(null));
		assertEquals("casts object cannot be null", exception.getMessage());
	}
	
	@Test
	void testUpdateCastsSuccess() {
		
		casts.setActorImage("https://pbs.twimg.com/media/FoDdg2WXEAomzQX?format=jpg&name=large");
		casts.setActorLink("https://www.youtube.com/embed/qN3wfuPYTI4?si=sTD-qk1ZBuOsUkUY");
		casts.setActorName("Vijay");
		casts.setMovieId(5);
		try {
			assertTrue(castsService.updateCasts(casts));
		}catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	void testUpdateCastsNullDetails() {
		
		ServiceException exception = assertThrows(ServiceException.class, () -> castsService.updateCasts(null));
		assertEquals("An error occurred while attempting to update casts", exception.getMessage());
	}
	
	@Test
	void testDeleteCastsSuccess() {
		try {
			boolean isDelete = castsService.deleteCasts(43);
			assertTrue(isDelete);
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testDeleteCastsNullDetails() {
	
		ServiceException exception = assertThrows(ServiceException.class, () -> castsService.deleteCasts(0));
		assertEquals("An error occurred while attempting to delete casts", exception.getMessage());
	}

@Test

void testValidGetCastsByMovieId() {

	try {
		List<Casts> retrievedCasts = castsService.getAllCastsByMovie(1);
		assertNotNull(retrievedCasts);
	} catch (ServiceException e) {
		e.printStackTrace();
		fail();
	}
}


	
}
