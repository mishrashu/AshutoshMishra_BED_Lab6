package com.ashutosh.StudentManagementSpringBootSecurity.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.ashutosh.StudentManagementSpringBootSecurity.entity.Student;
import com.ashutosh.StudentManagementSpringBootSecurity.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	public String listStudents(Model model) {

		List<Student> students = studentService.findAll();
		model.addAttribute("Students", students);
		return "list-Students";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		Student student = new Student();
		model.addAttribute("Student", student);

		return "Student-form";

	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int id, Model model) {

		Student student = studentService.findById(id);
		model.addAttribute("Student", student);
		return "Student-form";

	}

	@PostMapping("/save")
	public String saveStudent(@ModelAttribute Student student) {

		studentService.save(student);
		return "redirect:/student/list";
	}

	@RequestMapping("/delete")
	public String saveStudent(@RequestParam("studentId") int id) {

		studentService.delete(id);
		return "redirect:/student/list";
	}

	@GetMapping("/403")
	public ModelAndView accessDenied(Principal user) {
		ModelAndView model = new ModelAndView();

		if (user != null)
			model.addObject("msg", "Hi " + user.getName() + " you do not have permission to access this page.");
		else
			model.addObject("msg", "Hi, you do not have permission to access this page.");

		model.setViewName("403");
		return model;
	}

}
