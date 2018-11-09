package service;

import bean.User;
import dao.UserDAO;

public class UserService {
	
	private UserDAO userDAO;  
	
	
	public UserService(UserDAO userDAO) {
		super();
		System.out.println("userService construct");
		this.userDAO = userDAO;
	}
	
	
	
	public void add(User user) {
		userDAO.save(user);
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
