package service;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import bean.Tlog;
import bean.User;
import dao.LogDao;
import dao.UserDAO;


@Controller("userService")
public class UserService {
	
	private UserDAO userDAO;  
	private LogDao logDAO;
	
	@Transactional
	public void add(User user) {
		userDAO.save(user);
		Tlog tlog=new Tlog();
		tlog.setMsg("an action done!");
		logDAO.save(tlog);
	}
	
	
	public UserDAO getUserDAO() {
		return userDAO; 
	}
	
	@Resource
	public void setUserDAO( UserDAO userDAO) {
		this.userDAO = userDAO;
	}


	public LogDao getLogDAO() {
		return logDAO;
	}

	@Resource(name="logDao")
	public void setLogDAO(LogDao logDAO) {
		this.logDAO = logDAO;
	}
	
	
}
