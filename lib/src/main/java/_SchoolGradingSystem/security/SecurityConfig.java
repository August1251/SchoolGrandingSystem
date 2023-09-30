package _SchoolGradingSystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
		this.customUserDetailsService = customUserDetailsService;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.cors((cors) -> cors
					.disable())
				.authorizeHttpRequests((authz) -> authz
						.requestMatchers("/register", "/login").permitAll()
						.anyRequest().authenticated())
				.formLogin((form) -> {
					form.loginPage("/login").permitAll();
					form.defaultSuccessUrl("/home");
					form.failureUrl("/login").disable();
				})
				.logout((logout) -> logout
						.logoutUrl("/logout").permitAll()
						.logoutSuccessUrl("/login"));
		return http.build();
	}
	
}