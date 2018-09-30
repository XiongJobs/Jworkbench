package beans;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utils.HibernateSessionFactory;

public class StudyTest {
	private Session session = null;
	
	@Before
	public void setUp() throws Exception {
		session = HibernateSessionFactory.getCurrentSession();
	}

	@After
	public void tearDown() throws Exception {
		session.close();
	}
	
	@Test
	public void selectTest() {
		String hql = " select o.customer.name,o.tradeDate,o.status,o.amount from Order o "+
	"where o.tradeDate between '2015-5-1' and '2015-6-1' and status in('已付款','已发货')"+
				"and o.amount>1000";
		
		Query query=session.createQuery(hql);
		
		List<Object[]> list=query.list();
		
		for(Object[] objs:list) {
			
			System.out.println("-------------------------------------");
			System.out.println("CustomerName:"+objs[0]);
			System.out.println("tradeDate:"+objs[1]);
			System.out.println("status:"+objs[2]);
			System.out.println("amount:"+objs[3]);
			System.out.println("-------------------------------------");
			System.out.println();
		}
	}
	
	@Test
	public void selectTest2() {
		String hql="select c.name,c.price,c.seller.name,c.category from Commodity c "
				+ "where c.category like'%书%' and c.price>=10 "
				+ "order by c.seller.name asc,c.price desc,c.name asc";
		
		Query query=session.createQuery(hql);
		
		List<Object[]> list=query.list();
		
		for(Object[] objs:list) {
			
			System.out.println("-------------------------------------");
			System.out.println("name:"+objs[0]);
			System.out.println("price:"+objs[1]);
			System.out.println("seller:"+objs[2]);
			System.out.println("category:"+objs[3]);
			System.out.println("-------------------------------------");
			System.out.println();
		}
	}
	
}
