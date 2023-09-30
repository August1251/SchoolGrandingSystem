package _SchoolGradingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import _SchoolGradingSystem.entity.UserEntity;
import _SchoolGradingSystem.service.AuthService;

@Controller
public class AuthController {
	
	private AuthenticationManager authenticationManager;
	private PasswordEncoder passwordEncoder;
	private AuthService authService;

	@Autowired
	public AuthController(
			AuthenticationManager authenticationManager,
			PasswordEncoder passwordEncoder,
			AuthService authService) {
		this.authenticationManager = authenticationManager;
		this.passwordEncoder = passwordEncoder;
		this.authService = authService;
	}
	
	@GetMapping("/register")
	public String register_page(Model model) {
		model.addAttribute("user", new UserEntity());
		
		return "register";
	}
	
	@PostMapping("/register")
	public String register_control(@ModelAttribute("user") UserEntity user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		authService.saveRegisteredUser(user);
		
		return "register";
	}
	
}