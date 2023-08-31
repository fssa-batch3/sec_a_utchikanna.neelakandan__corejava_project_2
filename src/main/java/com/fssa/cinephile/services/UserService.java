package com.fssa.cinephile.services;

import com.fssa.cinephile.DAO.UserDAO;
import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.User;
import com.fssa.cinephile.services.exceptions.ServiceException;
import com.fssa.cinephile.validation.UserValidator;
import com.fssa.cinephile.validation.exceptions.ValidationException;

/**
 * Service class for managing User-related operations.
 * 
 * @author UtchikannaNeelakandan
 */
public class UserService {

	/**
	 * Registers a new user.
	 *
	 * @param user The User object representing the user to be registered.
	 * @return True if the user registration was successful, false otherwise.
	 * @throws ServiceException If an error occurs during the registration process.
	 */
	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		
		try {
			if (user == null) {
				throw new ServiceException("Registration credentials must not be null");
			}
			UserValidator.validateUser(user);
			// Check if the user already exists and is Active
						User existingUser = userDAO.getUser(user.getEmail());
						if (existingUser != null) {
							throw new ServiceException("User already exists.");
						}
			if (userDAO.createUser(user)) {
				return true;
			} else {
				return false;
			}
		} catch (DAOException | ValidationException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Attempts to log in a user.
	 *
	 * @param user The User object representing the user's login credentials.
	 * @return True if the login was successful, false otherwise.
	 * @throws ServiceException If an error occurs during the login process.
	 */
	public boolean logInUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateLogIn(user);
			User fromDb = userDAO.checkUserLogin(user.getEmail(), user.getPassword());
			if (fromDb.getPassword().equals(user.getPassword())) {
				System.out.println("Log in successfully");
			} else {
				throw new DAOException("Bad credentials");
			}
			return true;
		} catch (DAOException | ValidationException e) {
			throw new ServiceException(e);
		}
	}
}
