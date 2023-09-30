package _SchoolGradingSystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class LoginDto {

	@NotBlank(message = "username empty")
	private String username;
	
	@NotBlank(message = "password empty")
	private String password;

	public LoginDto() {}

	public LoginDto(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}