package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer>{
	
	public Student save(Student student);

	public Optional<Student> findById(int id);
	
	public void deleteById(int id);
	
	public List<Student> getAll();
	

}
