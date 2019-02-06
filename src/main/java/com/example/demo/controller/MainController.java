package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class MainController {

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public Student save(@RequestBody Student student) {
		return studentService.save(student);
	}

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public Optional<Student> getStudent(@RequestParam(value = "id") int id) {

		return studentService.getStudent(id);
	}

	@RequestMapping(value = "/student", method = RequestMethod.DELETE)
	public void deleteStudent(@RequestParam(value = "id") int id) {
		studentService.deleteById(id);
	}
	
	@RequestMapping(value="/students",method=RequestMethod.GET)
	public List<Student> getAllStudents() {
		return studentService.getAll();
	}

}
