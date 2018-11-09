package gotest;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import beans.Adress;
import beans.Student;

public class StudentTest {
	
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	
	@Before
	public void init() {
		//创建配置对象
		Configuration config=new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().
				applySettings(config.getProperties()).buildServiceRegistry();
		//创建会话工厂对象
		sessionFactory=config.buildSessionFactory(serviceRegistry);
		//会话对象
		session=sessionFactory.openSession();
		//开启事务
		transaction=session.beginTransaction();
	}
	
	
	@Test
	public void testSaveStudent() {
		 Adress add=new Adress("350004","2143532","fujian");
		 Student stu=new Student(1,"tom","male",new Date(),add);
		 session.save(stu); //保存对象
	}
	
	@Test
	public void testGetStudent() {   //get方式获取学生
		Student stu= (Student)session.get(Student.class, 1);   //1为主键
		System.out.println(stu);
	}
	
	@Test
	public void testLoadStudent() {  //load方式获取学生
		Student stu= (Student)session.load(Student.class, 1); //1为主键
		System.out.println("load student:" +stu);
	}
	
	@Test
	public void testUpdateStudent() {  //更新学生信息
		Student stu=(Student)session.get(Student.class, 1);
		stu.setSname("setboy");
		session.update(stu);
	}
	
	@Test
	public void testDeleteStudent() {  //删除学生信息
		Student stu=(Student)session.get(Student.class, 1);
		session.delete(stu);
	}
	
	@After
	public void destory() {
		transaction.commit(); //提交事务
		session.close();   //关闭事务
		sessionFactory.close(); //关闭会话工厂
	}
}
