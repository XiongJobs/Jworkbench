package service;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import bean.User;
import dao.UserDAO;


@Controller("userService")
public class UserService {
	
	private UserDAO userDAO;  
	
	
	public void add(User user) {
		userDAO.save(user);
	}
	
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	@Resource
	public void setUserDAO( UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
