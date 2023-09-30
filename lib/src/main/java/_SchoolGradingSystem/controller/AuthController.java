package _SchoolGradingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import _SchoolGradingSystem.dto.LoginDto;
import _SchoolGradingSystem.entity.UserEntity;
import _SchoolGradingSystem.service.AuthService;
import jakarta.validation.Valid;

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
	public String registerPage(Model model) {
		model.addAttribute("user", new UserEntity());
		
		return "register";
	}
	
	@PostMapping("/register")
	public String registerControl(@Valid @ModelAttribute("user") UserEntity user, BindingResult br) {
		if (!br.hasErrors()) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		
			authService.saveRegisteredUser(user);
		}
		return "register";
	}
	
	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("login", new LoginDto());
		
		return "login";
	}
	
	@PostMapping("/login")
	public String loginControl(@Valid @ModelAttribute("login") LoginDto login, BindingResult br) {
		if (!br.hasErrors()) {
			Authentication authentication = new UsernamePasswordAuthenticationToken(
					login.getUsername(),
					login.getPassword());
		
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		
		return "login";
	}
	
}