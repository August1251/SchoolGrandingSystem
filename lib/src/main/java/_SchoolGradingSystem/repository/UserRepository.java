package _SchoolGradingSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import _SchoolGradingSystem.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	Optional<UserEntity> findUserByUsername(String username);
	UserEntity findByUsername(String username);
	UserEntity findById(long id);
	
}