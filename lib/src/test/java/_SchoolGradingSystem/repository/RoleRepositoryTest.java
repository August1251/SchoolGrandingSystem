package _SchoolGradingSystem.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import _SchoolGradingSystem.entity.RoleEntity;

@DataJpaTest
@TestPropertySource(locations = "classpath:applicationtest.properties")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class RoleRepositoryTest {
	
	private static final long ID = 1L;
	private static final String ROLE_NAME = "USER";
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Mock
	private RoleEntity role;
	
	@Test
	@DisplayName("Role Repository Test #1 - Save Role")
	public void saveRole_shouldSaveRoleOnDB_whenCalledByServer() {
		when(role.getId()).thenReturn(ID);
		
		roleRepository.save(role);
		
		assertNotNull(role);
	}
	
	@Test
	@DisplayName("Role Repository Test #2 - Find by name")
	public void findByName_shouldFindRoleByName_whenExists() {
		when(role.getName()).thenReturn(ROLE_NAME);
		doCallRealMethod().when(role).setName(ROLE_NAME);
		role.setName(ROLE_NAME);
		
		roleRepository.save(role);
		final RoleEntity role1 = roleRepository.findByName(ROLE_NAME);
		
		assertNotNull(role);
		assertEquals(role, role1);
	}
	
}