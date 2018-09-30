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
		//�������ö���
		Configuration config=new Configuration().configure();
		//��������ע�����
		ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().
				applySettings(config.getProperties()).buildServiceRegistry();
		//�����Ự��������
		sessionFactory=config.buildSessionFactory(serviceRegistry);
		//�Ự����
		session=sessionFactory.openSession();
		//��������
		transaction=session.beginTransaction();
	}
	
	
	@Test
	public void testSaveStudent() {
		 Adress add=new Adress("350004","2143532","fujian");
		 Student stu=new Student(1,"tom","male",new Date(),add);
		 session.save(stu); //����������ݿ�
	}
	
	@Test
	public void testGetStudent() {   //get��ʽ��ȡѧ��
		Student stu= (Student)session.get(Student.class, 1);   //1Ϊ����
		System.out.println(stu);
	}
	
	@Test
	public void testLoadStudent() {  //load��ʽ��ȡѧ��
		Student stu= (Student)session.load(Student.class, 1); //1Ϊ����
		System.out.println("load student:" +stu);
	}
	
	@Test
	public void testUpdateStudent() {  //����ѧ����Ϣ
		Student stu=(Student)session.get(Student.class, 1);
		stu.setSname("setboy");
		session.update(stu);
	}
	
	@Test
	public void testDeleteStudent() {  //ɾ��ѧ����Ϣ
		Student stu=(Student)session.get(Student.class, 1);
		session.delete(stu);
	}
	
	@After
	public void destory() {
		transaction.commit(); //�ύ����
		session.close();   //�رջỰ
		sessionFactory.close(); //�رջỰ����
	}
}
