package dao;

import bean.User;

public class UserDAOImply1 implements UserDAO {

	@Override
	public void save(User user) {
		System.out.println("user saved!");		
	}

}
