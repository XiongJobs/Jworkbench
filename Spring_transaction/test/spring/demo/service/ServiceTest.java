package spring.demo.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:SpringContext.xml")
public class ServiceTest {
	
	@Resource(name="accountService")
	//@Resource(name="accountServiceProxy")  //注入代理类进行增强型事务操作(原始方式)
	private AccountService accountService;
	
	@Test
	public void demo1() {
		accountService.transfer("aaa","bbb",200d);
	}
}
