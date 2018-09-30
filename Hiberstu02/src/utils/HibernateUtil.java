package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static Session session;
	
	static {
		Configuration config =new Configuration().configure();
		ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().
				applySettings(config.getProperties()).buildServiceRegistry();
		sessionFactory=config.buildSessionFactory(serviceRegistry);
	}
	
	//获取SessionFactory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	//获取session
	public static Session getSession() {
		session=sessionFactory.openSession();
		return session;
	}
	
	//关闭session
	public static void closeSession(Session session) {
		if(session !=null) {
			session.close();
		}
	}
	
}
