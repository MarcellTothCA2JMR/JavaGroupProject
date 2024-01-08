package hu.projekt.hap.application.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String form() {

		SecurityContextHolder.getContext().setAuthentication(null);

		return "login";
	}
	
	@GetMapping("/")
	public String home() {

		return "redirect:homepage";
	}
	
	@GetMapping("homepage")
	public String homePage() {

		return "home-page";
	}
}