package com.ducat.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.springrest.entity.Student;
import com.ducat.springrest.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		
		List<Student> students=studentRepository.findAll();
		
		return students;
	}
	
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id){
		
		Student student=studentRepository.findById(id).get();
		
		return student;
	}
	
	@PostMapping("/student/add")
	@ResponseStatus(code =HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student) {
		studentRepository.save(student);
		
	}
	
	@PutMapping("/student/update/{id}")
	public Student updateStudents(@PathVariable int id) {
		Student student= studentRepository.findById(id).get();
		student.setName("Pooja");
		student.setPercentage(65);
		studentRepository.save(student);
		return student;
	}
	
	@DeleteMapping("/student/delete/{id}")
	public void deleteStudent(@PathVariable int id) {
		Student student= studentRepository.findById(id).get();
		studentRepository.delete(student);
	}


}
