package _SchoolGradingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import _SchoolGradingSystem.service.AuthService;

@Controller
public class AuthController {
	
	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
}