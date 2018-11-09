package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FilterController {
	
	@RequestMapping("/viewAll")
	public ModelAndView viewAll(String name,String pwd) {
		ModelAndView mv=new ModelAndView();
		System.out.println("进入控制器的viewAll方法……");
		System.out.println("name= "+name);
		System.out.println("passWord= "+pwd);
		mv.setViewName("/home");
		return mv;
	}
	
}
