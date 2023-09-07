package com.fssa.cinephile.services;

import com.fssa.cinephile.DAO.UserDAO;
import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.User;
import com.fssa.cinephile.services.exceptions.ServiceException;
import com.fssa.cinephile.util.PasswordUtil;
import com.fssa.cinephile.validation.UserValidator;
import com.fssa.cinephile.validation.exceptions.ValidationException;

/**
 * Service class for managing User-related operations.
 * 
 * @author UtchikannaNeelakandan
 */
public class UserService {

	UserDAO userDAO = new UserDAO();
	UserValidator userValidator = new UserValidator();
	/**
	 * Registers a new user.
	 *
	 * @param user The User object representing the user to be registered.
	 * @return True if the user registration was successful, false otherwise.
	 * @throws ServiceException If an error occurs during the registration process.
	 */
	public boolean registerUser(User user) throws ServiceException {
		

		try {
			if (user == null) {
				throw new ServiceException("Registration credentials must not be null");
			}
			
			System.out.print(user.getEmail());
			userValidator.validateUser(user);
			
			// Check if the user already exists and is Active
			User existingUser = userDAO.getUser(user.getEmail());
			if (existingUser != null) {
				throw new ServiceException("User already exists.");
			}
			String newPassword = PasswordUtil.hashPassword(user.getPassword());
			user.setPassword(newPassword);
			userDAO.createUser(user);
			return true;
		} catch (DAOException | ValidationException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
    /**
     * Retrieves a user by their email.
     *
     * @param searchEmail The email of the user to retrieve
     * @return The User object if found, otherwise null
     * @throws ServiceException If an error occurs during the service operation
     */
    public User getUserByEmail(String searchEmail) throws ServiceException {
        try {
            return userDAO.getUser(searchEmail); 
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
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
		try {
			userValidator.validateLogIn(user);
			User fromDb = userDAO.checkUserLogin(user.getEmail());
			if (!PasswordUtil.checkPassword(user.getPassword(),fromDb.getPassword())) {
				throw new DAOException("Bad credentials");	
			}
			return true;
		} catch (DAOException | ValidationException e) {
			throw new ServiceException(e.getMessage());
		}
	}
}
