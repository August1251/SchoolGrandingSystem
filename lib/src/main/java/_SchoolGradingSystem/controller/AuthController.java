package _SchoolGradingSystem.controller;

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
import _SchoolGradingSystem.dto.RegisterDto;
import _SchoolGradingSystem.entity.UserEntity;
import _SchoolGradingSystem.service.UserService;
import jakarta.validation.Valid;

@Controller
public class AuthController {
	
	private AuthenticationManager authenticationManager;
	private PasswordEncoder passwordEncoder;
	private UserService userService;

	public AuthController(
			AuthenticationManager authenticationManager,
			PasswordEncoder passwordEncoder,
			UserService userService) {
		this.authenticationManager = authenticationManager;
		this.passwordEncoder = passwordEncoder;
		this.userService = userService;
	}
	
	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("user", new RegisterDto());
		
		return "register";
	}
	
	@PostMapping("/register")
	public String registerControl(@Valid @ModelAttribute("user") RegisterDto registerDto, BindingResult br) {
		if (!br.hasErrors()) {
			registerDto.setPassword(passwordEncoder.encode(registerDto.getPassword()));
			
			UserEntity user = new UserEntity(
					registerDto.getFirstName(),
					registerDto.getSurname(),
					registerDto.getUsername(),
					registerDto.getPassword(),
					registerDto.getBirthdayDate());
			
			userService.saveUser(user);
			return "redirect:/login";
		} else {
			return "register";
		}
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
			return "redirect:/home";
		} else {
			return "login";
		}
	}
	
}