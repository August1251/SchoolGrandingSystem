package _SchoolGradingSystem;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import _SchoolGradingSystem.repository.RoleRepositoryTest;
import _SchoolGradingSystem.repository.UserRepositoryTest;
import _SchoolGradingSystem.service.UserServiceTest;

@Suite
@SelectClasses({
	UserRepositoryTest.class,
	RoleRepositoryTest.class,
	UserServiceTest.class})
public class MainTest {

}