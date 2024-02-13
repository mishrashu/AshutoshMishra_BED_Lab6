package com.ashutosh.StudentManagementSpringBootSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashutosh.StudentManagementSpringBootSecurity.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
