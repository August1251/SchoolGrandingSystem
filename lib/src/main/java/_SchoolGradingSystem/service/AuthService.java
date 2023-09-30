package _SchoolGradingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import _SchoolGradingSystem.entity.UserEntity;
import _SchoolGradingSystem.repository.RoleRepository;
import _SchoolGradingSystem.repository.UserRepository;

@Service
public class AuthService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	@Autowired
	public AuthService(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}
	
	public UserEntity saveRegisteredUser(UserEntity user) {
		return userRepository.save(user);
	}
	
}