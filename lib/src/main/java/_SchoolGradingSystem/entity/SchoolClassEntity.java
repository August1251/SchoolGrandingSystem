package _SchoolGradingSystem.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "class_books",
			joinColumns = @JoinColumn(name = "class_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
	private Set<BookEntity> books = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "student_id")
	private Set<UserEntity> students = new HashSet<>();

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

	public Set<BookEntity> getBooks() {
		return books;
	}

	public void setBooks(Set<BookEntity> books) {
		this.books = books;
	}

	public Set<UserEntity> getStudents() {
		return students;
	}

	public void setStudents(Set<UserEntity> students) {
		this.students = students;
	}
	
}