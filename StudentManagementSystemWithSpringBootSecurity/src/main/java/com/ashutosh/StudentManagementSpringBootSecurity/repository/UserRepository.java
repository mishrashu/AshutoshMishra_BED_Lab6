package com.ashutosh.StudentManagementSpringBootSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashutosh.StudentManagementSpringBootSecurity.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("SELECT user FROM User user WHERE userName.userName = ?1")
	public User findByUserName(String userName);
}
