
package com.wipro.TestingDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.TestingDemo.entity.Student;
import com.wipro.TestingDemo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService service;

	@PostMapping("/student")
	public Student saveStudent(@RequestBody Student student) {

		return service.saveStudent(student);
	}

	@GetMapping("/student")
	public List<Student> getAllStudents() {

		return service.getAllStudents();
	}
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable int id) {

	    return service.getStudentById(id);
	}

}
