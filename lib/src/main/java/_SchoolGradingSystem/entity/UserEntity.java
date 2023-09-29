package _SchoolGradingSystem.entity;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "users")
public class UserEntity {
	
	@Id
	@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	private long id;
	
	private String firstName;
	
	private String surname;
	
	private LocalDate birthdayDate;
	
	@Transient
	private int age;

	public UserEntity() {}

	public UserEntity(String firstName, String surname, LocalDate birthdayDate, int age) {
		this.firstName = firstName;
		this.surname = surname;
		this.birthdayDate = birthdayDate;
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
}