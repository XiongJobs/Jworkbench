package service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.User;


public class UserServiceTest {

	@Test
	public void testAdd() throws Exception {
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("configer/beans.xml");		
		
	//	UserService service = (UserService)ctx.getBean("userService");
		
		UserService service = ctx.getBean("userService",UserService.class); //可用泛型
		User user = new User();
		user.setName("fangxin");
		service.add(user);
	}

}
