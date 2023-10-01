package _SchoolGradingSystem;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.springframework.test.context.TestPropertySource;

import _SchoolGradingSystem.repository.UserRepositoryTest;

@Suite
@SelectClasses({
	UserRepositoryTest.class
})
public class MainTest {

}