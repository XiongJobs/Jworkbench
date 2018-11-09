package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping({"/first","/home"})
	public String gohome() {
		System.out.println("hello world new world");
		return "index";
	}
}
