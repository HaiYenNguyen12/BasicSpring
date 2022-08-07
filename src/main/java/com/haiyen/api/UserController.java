package com.haiyen.api;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.haiyen.service.UserService;
import com.haiyen.model.*;

@Controller
public class UserController {
	
	@Autowired private UserService service;
	
	public UserController (UserService service) {
		this.service = service;
	}
	
	@GetMapping("/user")
	public String showUserList(Model model) {
		List<User> list = service.listAll();
		model.addAttribute("listUsers",list);
		return "users";
	}

	@GetMapping("users/new")
	
	public String showNewForm (Model model) {
		model.addAttribute("user",new User());
		return "user_form";
	}
	
	@PostMapping("users/save")
	public String saveUser (User user, RedirectAttributes ra) {
		service.save(user);
		ra.addFlashAttribute("message", "The user has been saved successfully");
		return "redirect:/user";
		
	}
}
