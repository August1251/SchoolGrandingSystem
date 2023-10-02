package _SchoolGradingSystem.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import _SchoolGradingSystem.entity.UserEntity;

@DataJpaTest
@TestPropertySource(locations = "classpath:applicationtest.properties")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	private UserEntity user;
	
	@BeforeEach
	public void setUp() {
		user = new UserEntity("August", "maksmaks11q", "Maksim", "Novikov", LocalDate.of(2004, 9, 13));
	}
	
	@Test
	@DisplayName("User Repository Test #1")
	public void saveRepository_shouldSaveRepositoryToDB_ReturnSavedUser() {
		UserEntity newUser = new UserEntity("August1", "maksmaks11q", "Maksim", "Novikov", LocalDate.of(2004, 9, 13));
		
		userRepository.save(newUser);
		UserEntity finddedUser = userRepository.findByUsername("August1");
		
		assertNotNull(finddedUser);
		assertNotNull(newUser);
	}
	
	@Test
	@DisplayName("User Repository Test #2")
	public void findUserByUsername_shouldFindUserByIdFromDB_ReturnUserById() {
		userRepository.save(user);
		
		UserEntity finddedUser1 = userRepository.findUserByUsername("August").get();
		UserEntity finddedUser2 = userRepository.findByUsername("August");
		
		assertNotNull(user);
		assertNotNull(finddedUser1);
		assertNotNull(finddedUser2);
		assertEquals(user, finddedUser1);
		assertEquals(user, finddedUser2);
	}
	
}