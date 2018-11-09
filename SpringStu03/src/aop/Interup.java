package aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Controller;


@Aspect
@Controller
public class Interup {
	
	@Pointcut(value = "execution(public * service..*.add(..))")
	private void log(){}
	
/*	@Before(value = "execution(public void dao.UserDAOImply1.save(bean.User))")*/
	@Before(value = "log()")
	public void say() {
		System.out.println("before a method");
	}
}
