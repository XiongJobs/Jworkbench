package utils;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Grade;
import beans.Students;

public class Test {

	public static void main(String[] args) {
		//add();
		//findStudents();
		//update();
		deletStu();
	}
	
	//��ѧ����ӵ��༶
	public static void add() {
		Grade grade=new Grade("J1class", "Javaһ��");
		Students stu1=new Students("Tony","male");
		Students stu2=new Students("lucy","female");
		
		grade.getStus().add(stu1);
		grade.getStus().add(stu2);
		
		
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		session.save(grade);
		session.save(stu1);
		session.save(stu2);
		tx.commit();
		session.close();   //�رջỰ
	}
	
	//��ѯ�༶�а�����ѧ��
	public static void findStudents() {
		Session session=HibernateUtil.getSession();
		Grade grade=(Grade)session.get(Grade.class, 1);
		System.out.println(grade.getGname()+","+grade.getGdesc());
		System.out.println("---------------------------");
		
		Set<Students> stus=grade.getStus();
		
		for(Students stu:stus) {
			System.out.println(stu.getSname()+","+stu.getSex());
		}
		session.close();   //�رջỰ
	}
	
	//�޸İ༶�е�ѧ����Ϣ
	public static void update() {
		Grade gra=new Grade("J2class", "Java����");
		Session session=HibernateUtil.getSession();
		Transaction trx=session.beginTransaction();
		
		Students stu=(Students)session.get(Students.class, 1);
		gra.getStus().add(stu);
		session.save(gra);
		trx.commit();
		session.close();
	}
	
	//ɾ���༶ �е�ѧ����Ϣ
	
	public static void deletStu() {
		Session session=HibernateUtil.getSession();
		Transaction trx=session.beginTransaction();
		Students stu=(Students)session.get(Students.class, 2);
		
		session.delete(stu);
		trx.commit();
		session.close();
	}
}
