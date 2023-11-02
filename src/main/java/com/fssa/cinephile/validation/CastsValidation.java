package com.fssa.cinephile.validation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.cinephile.model.Casts;
import com.fssa.cinephile.validation.exceptions.ValidationException;

public class CastsValidation {

	public void validateCasts(Casts casts) throws ValidationException {
		if (validateActorImage(casts.getActorImage()) && validateActorLink(casts.getActorLink())) {
			validateActorName(casts.getActorName());
		}
	}
	
	public boolean validateActorName(String actorName) throws ValidationException {
		boolean match = false;

		if (actorName == null)
			throw new ValidationException("The actor name cannot be empty");

		String regex = "^[a-zA-Z\\s]{3,49}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(actorName);
		match = m.matches();
		if (!match) {
			throw new ValidationException("The actor name is not valid");
		} 
		return match;
	}
	
	public boolean validateActorLink(String actorLink) throws ValidationException {
		try {
			URL val = new URL(actorLink);
			return true;
		} catch (MalformedURLException e) {
			throw new ValidationException("actor link is not found");
		}
	}
	
	public boolean validateActorImage(String actorImage) throws ValidationException {
		try {
			URL val = new URL(actorImage);
			return true;
		} catch (MalformedURLException e) {
			throw new ValidationException("actor image is not found");
		}
	}
}
