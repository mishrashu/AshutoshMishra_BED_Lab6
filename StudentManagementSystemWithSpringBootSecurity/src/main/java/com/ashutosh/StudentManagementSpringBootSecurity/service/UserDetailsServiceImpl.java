package com.ashutosh.StudentManagementSpringBootSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ashutosh.StudentManagementSpringBootSecurity.entity.User;
import com.ashutosh.StudentManagementSpringBootSecurity.repository.UserRepository;
import com.ashutosh.StudentManagementSpringBootSecurity.security.myUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUserName(username);

		if (user == null)
			throw new UsernameNotFoundException("Could not find the user");
		return new myUserDetails(user);
	}

}
