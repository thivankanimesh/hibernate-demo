package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepo studentRepo;

	@Override
	public Student save(Student student) {

		return studentRepo.save(student);
	}

	@Override
	public Optional<Student> getStudent(@RequestParam(value = "id") int id) {

		return studentRepo.findById(id);
	}

	@Override
	public void deleteById(int id) {

		studentRepo.deleteById(id);

	}

	@Override
	@Transactional
	public List<Student> getAll() {
		
		return  (List<Student>) studentRepo.findAll();
	}
	
	

}
