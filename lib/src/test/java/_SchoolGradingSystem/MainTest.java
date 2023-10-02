package _SchoolGradingSystem;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import _SchoolGradingSystem.repository.RoleRepositoryTest;
import _SchoolGradingSystem.repository.UserRepositoryTest;

@Suite
@SelectClasses({
	UserRepositoryTest.class,
	RoleRepositoryTest.class})
public class MainTest {

}