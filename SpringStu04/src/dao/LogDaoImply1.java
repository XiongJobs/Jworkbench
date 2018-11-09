package dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import bean.Tlog;

@Repository("logDao")
public class LogDaoImply1 implements LogDao {
	
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public void save(Tlog tlog) {
/*		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.save(tlog);
		s.getTransaction().commit();
		System.out.println("user saved!");	*/	
		
		//开启事务后用以下方法
		Session s = sessionFactory.getCurrentSession();
		s.save(tlog);
		
	}

}
