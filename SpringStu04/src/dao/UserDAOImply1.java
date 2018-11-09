package dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import bean.User;


@Component("userDao")
public class UserDAOImply1 implements UserDAO {
	
	private HibernateTemplate hibernateTemplate;
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public void save(User user) {
		
		hibernateTemplate.save(user);
		System.out.println("user saved!");		
	}


	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	


	
	
	 

}
