package _SchoolGradingSystem.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import _SchoolGradingSystem.entity.UserEntity;
import jakarta.validation.Valid;
import jakarta.validation.Validator;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:applicationtest.properties")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTest {
	
	private static final long ID = 1L;
	private static final String USERNAME = "August";
	private static final String PASSWORD = "1234566789";
	private static final String FIRST_NAME = "Maksim";
	private static final String SUR_NAME = "Novikov";
	private static final LocalDate BIRTHDAY = LocalDate.of(2004, 9, 13);
	
	@Autowired
	private UserRepository userRepository;
	
	private Validator validator;
	
	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	@Valid
	private UserEntity user;
	
	@BeforeEach
	public void setUp() {
		doCallRealMethod().when(user).setUsername(USERNAME);
		doCallRealMethod().when(user).setPassword(PASSWORD);
		doCallRealMethod().when(user).setFirstName(FIRST_NAME);
		doCallRealMethod().when(user).setSurname(SUR_NAME);
		doCallRealMethod().when(user).setBirthdayDate(BIRTHDAY);
		
		user.setUsername(USERNAME);
		user.setPassword(PASSWORD);
		user.setFirstName(FIRST_NAME);
		user.setSurname(SUR_NAME);
		user.setBirthdayDate(BIRTHDAY);
	}
	
	/*
	@BeforeEach
	public void setUp() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<UserEntity>> constraintViolations = validator.validate(user);
		for (ConstraintViolation cv : constraintViolations) {
            System.out.println("ValidatationConstraint: " + cv.getConstraintDescriptor().getAnnotation());
            System.out.println("ValidatationConstraint: " + cv.getConstraintDescriptor());
            System.out.println("ValidatationConstraint: " + cv.getMessageTemplate());
            System.out.println("ValidatationConstraint: " + cv.getInvalidValue());
            System.out.println("ValidatationConstraint: " + cv.getLeafBean());
            System.out.println("ValidatationConstraint: " + cv.getRootBeanClass());
            System.out.println("ValidatationConstraint: " + cv.getPropertyPath().toString());
            System.out.println("ValidatationConstraint: " + cv.getMessage());
        }
	}*/
	
	@Test
	@DisplayName("User Repository Test #1 - Save repository")
	public void saveRepository_shouldSaveRepositoryToDB_ReturnSavedUser() {
		when(user.getId()).thenReturn(ID);
		
		userRepository.save(user);
		final UserEntity finddedUser = userRepository.findById(ID);
		
		assertNotNull(finddedUser);
		assertNotNull(user);
		assertEquals(user, finddedUser);
	}
	
	@Test
	@DisplayName("User Repository Test #2 - Find user by name")
	public void findUserByUsername_shouldFindUserByIdFromDB_ReturnUserById() {
		when(user.getId()).thenReturn(ID);
		when(user.getUsername()).thenReturn(USERNAME);
		when(user.getPassword()).thenReturn(PASSWORD);
		when(user.getFirstName()).thenReturn(FIRST_NAME);
		when(user.getSurname()).thenReturn(SUR_NAME);
		when(user.getBirthdayDate()).thenReturn(BIRTHDAY);
		
		userRepository.save(user);
		final UserEntity finddedUser = userRepository.findByUsername(USERNAME);
		
		assertNotNull(user);
		assertNotNull(finddedUser);
		assertEquals(user, finddedUser);
	}
	
}