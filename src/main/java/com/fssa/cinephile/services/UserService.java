package com.fssa.cinephile.services;



import com.fssa.cinephile.DAO.UserDAO;
import com.fssa.cinephile.DAO.exceptions.DAOException;
import com.fssa.cinephile.model.User;
import com.fssa.cinephile.services.exceptions.ServiceException;
import com.fssa.cinephile.validation.UserValidator;
import com.fssa.cinephile.validation.exceptions.ValidationException;

public class UserService {
	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateUser(user);
			if (userDAO.createUser(user)) {
				return true;
			} else {
				return false;
			}
		} catch (DAOException | ValidationException e) { 
			throw new ServiceException(e);
		}

	}
	
	public boolean logInUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateLogIn(user);
			if (userDAO.checkUserLogin(user.getEmail(), user.getPassword())) {
				return true;
			} else {
				return false;
			}

		} catch (DAOException | ValidationException e) {
			throw new ServiceException(e);
		}

 }

}
