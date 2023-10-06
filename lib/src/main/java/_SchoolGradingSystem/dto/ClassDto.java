package _SchoolGradingSystem.dto;

import java.util.HashSet;
import java.util.Set;

import _SchoolGradingSystem.entity.BookEntity;
import _SchoolGradingSystem.entity.UserEntity;

public class ClassDto {
	
	private String studentClass;
	
	private long studentId;
	
	private long bookId;
	
	private Set<UserEntity> students = new HashSet<>();
	
	private Set<BookEntity> books = new HashSet<>();

	public ClassDto() {}

	public ClassDto(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public Set<UserEntity> getStudents() {
		return students;
	}

	public void setStudents(Set<UserEntity> students) {
		this.students = students;
	}

	public Set<BookEntity> getBooks() {
		return books;
	}

	public void setBooks(Set<BookEntity> books) {
		this.books = books;
	}
	
}