package hu.projekt.hap.application.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.authorizeRequests()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/h2-console/**").permitAll()
			.antMatchers("/register-doctor**").hasRole("ADMIN")
			.antMatchers("/register-patient**").permitAll()
			.antMatchers("/edit-patient**").hasRole("PATIENT")
			.antMatchers("/doctors**").hasRole("PATIENT")
			.antMatchers("/add-appointment**").hasRole("PATIENT")
			.antMatchers("/remove-appointment**").hasRole("PATIENT")
			.antMatchers("/bookable-times**").hasRole("DOCTOR")
			.antMatchers("/prescriptions-**").hasRole("DOCTOR")
			.antMatchers("/make-prescription").hasRole("DOCTOR")
			.antMatchers("/request-prescription**").hasRole("PATIENT")
			.antMatchers("/appointments").hasAnyRole("DOCTOR", "PATIENT")
			.antMatchers("/prescriptions").hasAnyRole("DOCTOR", "PATIENT")
			.anyRequest().authenticated()
		.and()
			.csrf().ignoringAntMatchers("/h2-console/**")
		.and()
			.headers().frameOptions().sameOrigin()
		.and()
	.formLogin()
			.loginPage("/login").permitAll()
		.and()
			.logout().permitAll();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder(12);
	}
}