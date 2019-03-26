package com.spring.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/")
	public String getWelcomePage() {
		System.out.println("get welcome");
		return "welcome.jsp";
	}

}
