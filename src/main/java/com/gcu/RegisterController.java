package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.SecurityServiceInterface;
import com.gcu.model.LoginModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/register")

public class RegisterController {
	@Autowired
	SecurityServiceInterface securityService;

	@GetMapping("/")
	public String display(Model model) {
		// Display Login Form View
		model.addAttribute("title", "Register Form");
		model.addAttribute("loginModel", new LoginModel());
		return "register";
	}

	@PostMapping("/doRegister")
	public String doRegister(@Valid LoginModel registerModel, BindingResult bindingResult, Model model) {
		// Check for validation errors
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Register Form");
			return "register";
		} else {
			securityService.addNewLogin(registerModel);
			model.addAttribute("registerModel", registerModel);
			return "redirect:/home";
		}

	}
}
