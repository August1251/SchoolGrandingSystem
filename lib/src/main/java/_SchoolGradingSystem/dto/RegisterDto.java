package _SchoolGradingSystem.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterDto {

	@NotEmpty(message = "First Name is empty")
	private String firstName;
	
	@NotEmpty(message = "Surname is empty")
	private String surname;
	
	@NotEmpty(message = "Username is empty")
	@Pattern(regexp = "[a-zA-Z0-9]+", message = "Invalid value")
	private String username;
	
	@NotEmpty(message = "Password is empty")
	@Size(min = 6, max = 32, message = "Min size 8 max size 32")
	private String password;
	
	@NotNull(message = "Birthday dates is empty")
	private LocalDate birthdayDate;

	public RegisterDto() {}

	public RegisterDto(
			String firstName,
			String surname,
			String username,
			String password,
			LocalDate birthdayDate) {
		this.firstName = firstName;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.birthdayDate = birthdayDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public LocalDate getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(LocalDate birthdayDate) {
		this.birthdayDate = birthdayDate;
	}
	
}