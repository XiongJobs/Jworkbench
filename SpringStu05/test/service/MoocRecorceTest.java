package service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.User;

public class MoocRecorceTest {
	
	@Test
	public void testResource() throws Exception {
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("configer/beans.xml");
				
		MoocRecorce service = ctx.getBean("MoocRecorce",MoocRecorce.class);
		service.resorces();
		
		
	}
}
