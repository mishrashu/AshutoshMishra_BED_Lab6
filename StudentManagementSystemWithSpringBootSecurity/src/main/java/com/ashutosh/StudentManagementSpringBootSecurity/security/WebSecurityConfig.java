package com.ashutosh.StudentManagementSpringBootSecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ashutosh.StudentManagementSpringBootSecurity.service.UserDetailsServiceImpl;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailService());
		authProvider.setPasswordEncoder(passwordEncoder());
		auth.authenticationProvider(authProvider);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailService() {
		return new UserDetailsServiceImpl();
	}

	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/", "/student/save", "/student/showFormForAdd", "/student/403")
				.hasAnyAuthority("USER", "ADMIN").antMatchers("/student/showFormForUpdate", "/student/delete")
				.hasAuthority("ADMIN").anyRequest().authenticated().and().formLogin().loginProcessingUrl("/login")
				.successForwardUrl("/student/list").permitAll().and().logout().logoutSuccessUrl("/login").permitAll()
				.and().exceptionHandling().accessDeniedPage("/student/403").and().cors().and().csrf().disable();
	}
}
