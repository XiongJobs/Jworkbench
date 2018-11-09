package service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.User;


public class UserServiceTest {

	@Test
	public void testAdd() throws Exception {
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("configer/beans.xml");		
		
		UserService service = (UserService)ctx.getBean("userService");

		User u = new User();
		u.setName("aluba");
		service.add(u);
	}

}
