package _SchoolGradingSystem.service;

import org.springframework.stereotype.Service;

import _SchoolGradingSystem.entity.SchoolClassEntity;
import _SchoolGradingSystem.repository.ClassRepository;
import _SchoolGradingSystem.repository.RoleRepository;
import _SchoolGradingSystem.repository.UserRepository;

@Service
public class ClassService {

	private ClassRepository classRepository;
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	public ClassService(
			ClassRepository classRepository,
			UserRepository userRepository,
			RoleRepository roleRepository) {
		this.classRepository = classRepository;
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}
	
	public SchoolClassEntity saveClassEntity(SchoolClassEntity classEntity) {
		return classRepository.save(classEntity);
	}
		
}