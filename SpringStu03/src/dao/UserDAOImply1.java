package dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import bean.User;


@Component("userDao")
public class UserDAOImply1 implements UserDAO {

	private SessionFactory sessionFactory;
	
	@Override
	public void save(User user) {
/*		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.save(user);
		s.getTransaction().commit();*/
		
		//当开启事务后应该用以下方法
		Session s = sessionFactory.getCurrentSession();		
		s.save(user);
		
		System.out.println("user saved!");		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	 

}
