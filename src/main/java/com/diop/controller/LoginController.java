package com.diop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class LoginController {
	
	@Autowired
	private LoginService fatou;
	
	
//	@RequestMapping(value = "/diagne")
//	@ResponseBody
//	public String fatougoout() {
//		return "who go out?";
//	}


@RequestMapping(value = "/login", method= RequestMethod.GET)
public String fatougoout() {
	return "login";
}

	@RequestMapping(value = "/login", method= RequestMethod.POST)
	public String showWelcomePage(@RequestParam String name,@RequestParam String password,ModelMap model) {
		
		if(!fatou.validateUser(name, password)) {
			model.put("errorMessage","Invalid Credentials");
			return "login";
		}	
		model.put("name", name);
		model.put("password", password);
		return "welcome";
}




}