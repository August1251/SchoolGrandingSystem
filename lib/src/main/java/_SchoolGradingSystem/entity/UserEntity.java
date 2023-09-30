package _SchoolGradingSystem.entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class UserEntity {
	
	@Id
	@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	private long id;
	
	@NotEmpty(message = "Username is empty")
	@Pattern(regexp = "[a-zA-Z0-9]+", message = "Invalid value")
	private String username;
	
	@NotEmpty(message = "Password is empty")
	@Max(value = 16, message = "Max password size is 16")
	@Min(value = 8, message = "Min password size is 8")
	private String password;
	
	@NotEmpty(message = "First Name is empty")
	private String firstName;
	
	@NotEmpty(message = "Surname is empty")
	private String surname;
	
	@NotNull(message = "Birthday dates is empty")
	private LocalDate birthdayDate;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<RoleEntity> roles = new HashSet<>();
	
	@Transient
	private int age;

	public UserEntity() {}

	public UserEntity(
			String username,
			String password,
			String firstName,
			String surname,
			LocalDate birthdayDate) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.surname = surname;
		this.birthdayDate = birthdayDate;	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public LocalDate getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(LocalDate birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	public int getAge() {
		return Period.between(this.birthdayDate, LocalDate.now()).getYears();
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}
	
}