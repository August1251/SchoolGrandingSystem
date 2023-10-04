package _SchoolGradingSystem.entity;

import java.util.HashMap;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "classes")
public class SchoolClassEntity {

	@Id
	@SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
	private long id;
	
	@NotBlank(message = "Is don't be nullable")
	@Size(min = 2, max = 3, message = "Min size is 2, max size is 3")
	@Column(unique = true)
	private String studentClass;
	
	private HashMap<String, Integer> books = new HashMap<>();

	public SchoolClassEntity() {}

	public SchoolClassEntity(String studentClass) {
		this.studentClass = studentClass;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public HashMap<String, Integer> getBooks() {
		return books;
	}

	public void setBooks(HashMap<String, Integer> books) {
		this.books = books;
	}
	
}