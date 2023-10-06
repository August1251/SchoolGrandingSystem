package _SchoolGradingSystem.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import _SchoolGradingSystem.entity.BookEntity;
import _SchoolGradingSystem.entity.SchoolClassEntity;
import _SchoolGradingSystem.entity.UserEntity;
import _SchoolGradingSystem.repository.BookRepository;
import _SchoolGradingSystem.repository.ClassRepository;
import _SchoolGradingSystem.repository.RoleRepository;
import _SchoolGradingSystem.repository.UserRepository;

@Service
public class ClassService {

	private ClassRepository classRepository;
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BookRepository bookRepository;
	
	public ClassService(
			ClassRepository classRepository,
			UserRepository userRepository,
			RoleRepository roleRepository,
			BookRepository bookRepository) {
		this.classRepository = classRepository;
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bookRepository = bookRepository;
	}
	
	public SchoolClassEntity saveClassEntity(SchoolClassEntity classEntity) {
		return classRepository.save(classEntity);
	}
	
	public BookEntity findBookById(long id) {
		return bookRepository.findById(id);
	}
	
	public UserEntity findStudentById(long id) {
		return userRepository.findById(id);
	}
		
}