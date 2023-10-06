package _SchoolGradingSystem.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import _SchoolGradingSystem.entity.UserEntity;
import _SchoolGradingSystem.repository.UserRepository;

@SpringBootTest
@TestPropertySource("classpath:applicationtest.properties")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserServiceTest {
	
	private static final long ID = 1L;
	private static final String USERNAME = "August";
	private static final String PASSWORD = "123456789";
	private static final String FIRST_NAME = "Maksim";
	private static final String SUR_NAME = "Novikov";
	private static final LocalDate BIRTHDAY = LocalDate.of(2004, 9, 13);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	private UserEntity user;
	
	@BeforeEach
	public void setUp() {
		doCallRealMethod().when(user).setId(ID);
		doCallRealMethod().when(user).setUsername(USERNAME);
		doCallRealMethod().when(user).setPassword(PASSWORD);
		doCallRealMethod().when(user).setFirstName(FIRST_NAME);
		doCallRealMethod().when(user).setSurname(SUR_NAME);
		doCallRealMethod().when(user).setBirthdayDate(BIRTHDAY);
		
		user.setId(ID);
		user.setUsername(USERNAME);
		user.setPassword(PASSWORD);
		user.setFirstName(FIRST_NAME);
		user.setSurname(SUR_NAME);
		user.setBirthdayDate(BIRTHDAY);
	}
	
	@Test
	@DisplayName("Auth Service Test #1 - Save user")
	public void saveRegistredUser_saveUserToDB_whenUserEntryiedDatesToForm() {
		when(user.getId()).thenReturn(ID);
		
		userService.saveUser(user);
		final UserEntity find = userService.findById(user.getId());
		
		assertNotNull(user);
		assertNotNull(find);
		assertEquals(user.getId(), find.getId());
	}
	
	@Test
	@DisplayName("Auth Service Test #2 - Find by id")
	public void findById_findUserByIdFromDB_whenCalledMethodAndAddedIDToParams() {
		when(user.getId()).thenReturn(ID);
		
		userService.saveUser(user);
		UserEntity find1 = userService.findById(ID);
		
		assertNotNull(user);
		assertEquals(user.getId(), find1.getId());
	}
	
}