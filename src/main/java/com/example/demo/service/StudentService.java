package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Student;

public interface StudentService {

	public Student save(Student student);
	
	public Optional<Student>  getStudent(int id);
	
	public void deleteById(int id);
	
	public List<Student> getAll();
	
}
