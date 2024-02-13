package com.ashutosh.StudentManagementSpringBootSecurity.service;

import java.util.List;

import com.ashutosh.StudentManagementSpringBootSecurity.entity.Student;

public interface StudentService {

	List<Student> findAll();

	Student findById(int id);

	void save(Student student);

	void delete(int id);

}
