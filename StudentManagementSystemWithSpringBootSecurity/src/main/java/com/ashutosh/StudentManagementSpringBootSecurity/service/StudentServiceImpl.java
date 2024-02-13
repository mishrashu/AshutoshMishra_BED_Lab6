package com.ashutosh.StudentManagementSpringBootSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashutosh.StudentManagementSpringBootSecurity.entity.Student;
import com.ashutosh.StudentManagementSpringBootSecurity.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(int id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public void save(Student student) {
		studentRepository.save(student);

	}

	@Override
	public void delete(int id) {
		studentRepository.deleteById(id);

	}
}
