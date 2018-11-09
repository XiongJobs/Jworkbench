package utils;

import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Grade;
import beans.Students;

public class Test2 {

	public static void main(String[] args) {
		//Save();
		findStudent();

	}
	
	
	public static void Save() {
		Grade grade=new Grade("J31class", "Java三班");
		Students stu3=new Students("Jun","male");
		Students stu4=new Students("Komia","female");
		
		stu3.setGrade(grade);
		stu4.setGrade(grade);
		grade.getStus().add(stu3);
		grade.getStus().add(stu4);
		
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		
		session.save(grade);
		
//		session.save(stu3);
//		session.save(stu4);
		tx.commit();
		session.close();
	}
	
	//获取学生信息
	public static void findStudent() {
		Session session=HibernateUtil.getSession();
		Students stu=(Students) session.get(Students.class,2);
		System.out.println(stu.getSid()+","+stu.getSname());
		
		Grade gra=stu.getGrade();
		System.out.println(gra.getGid()+","+gra.getGname());
	}
}
