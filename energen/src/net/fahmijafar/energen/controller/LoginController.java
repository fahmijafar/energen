package net.fahmijafar.energen.controller;

import net.fahmijafar.energen.pojo.User;
import net.fahmijafar.energen.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@Autowired
	private UserService defaultUserService;
	
	@RequestMapping("/")
	public String home(){
		return "index";
	}
	
	@RequestMapping(value="/Login.spring", method= RequestMethod.POST)
	public ModelAndView processCredentials(@RequestParam("userName")String username,
			@RequestParam("password")String password) {
		String message = "Invalid credentials";
		
		if (!username.equals("") && !password.equals("")) {
			if (username.equals(password)) {
				message = "Welcome " + username + "!!";
			}
		}
		User user = defaultUserService.find(username);
		if (user != null) {
			System.out.println("UserID : " + user.getUserId());
			System.out.println("UserName : " + user.getUsername());
			System.out.println("Password : " + user.getPassword());
		} else {
			System.out.println("not found");
		}
		
		return new ModelAndView("index", "message", message);
	}
}
