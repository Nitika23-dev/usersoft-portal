package com.cdac.training.usersoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.cdac.training.usersoft.model.User;
import com.cdac.training.usersoft.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




/**
 * Author : nitik
 * Date : 31 Dec 2024
 * Time : 9:39:46 pm
*/

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/index")
	public String ShowIndexPage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String ShowRegisterPage(Model m) {
		User user = new User();
		m.addAttribute("user",user);
		return "register";
	}
	
	@PostMapping("/register")
	public String UserRegister(@ModelAttribute User user,Model model) {
		userService.UserRegister(user);
		model.addAttribute("message", "Registration successful! Please log in.");
		return "login";
	}
	
	@GetMapping("/login")
	public String ShowLoginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String UserLogin(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
		var user = userService.UserLogin(email,password);
		if(user.isPresent()) {
			session.setAttribute("loggedUser", user.get());
			return "redirect:/home";
		}else {
			model.addAttribute("error", "Invalid email or password");
			return "login";
		}
	}
	
	@GetMapping("/home")
	public String ShowHomePage(HttpSession session, Model model) {
		var user = session.getAttribute("loggedUser");
		if(user == null) {
			return "redirect:/login";
		}
		model.addAttribute("user", user);
		return "home";
	}

	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}
	
}
