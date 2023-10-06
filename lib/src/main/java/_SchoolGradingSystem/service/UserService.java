package _SchoolGradingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import _SchoolGradingSystem.entity.UserEntity;
import _SchoolGradingSystem.repository.RoleRepository;
import _SchoolGradingSystem.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	@Autowired
	public UserService(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}
	
	public UserEntity saveUser(UserEntity user) {
		return userRepository.save(user);
	}
	
	public UserEntity findById(long id) {
		return userRepository.findById(id);
	}
	
}