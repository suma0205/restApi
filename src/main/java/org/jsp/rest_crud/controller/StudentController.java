package org.jsp.rest_crud.controller;

import java.util.List;

import org.jsp.rest_crud.dto.Student;
import org.jsp.rest_crud.helper.ResponseStructure;
import org.jsp.rest_crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class StudentController {

	@Autowired
	StudentService service;
	@Operation(summary="saving one student record")
	@PostMapping("/students")  
	public ResponseStructure saveStudent(@RequestBody Student student) {
		return service.saveStudent(student);
	}
	
	@Operation(summary="fetch student record by id")
	@GetMapping("/students/{id}")
	public ResponseStructure findStudentById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@Operation(summary="fetch all student record")
	@GetMapping("/students")
	public ResponseStructure findAllRecord() {
		return service.fetchAllRecords();
	}
	
	@Operation(summary="saving multiple student record")
	@PostMapping("/students/many")  
	public ResponseStructure saveStudents(@RequestBody List<Student> students) {
		return service.saveStudents(students);
	}
	
	@Operation(summary="fetch student record by name")
	@GetMapping("/students/name/{name}")
	public ResponseStructure fetchByName(@PathVariable String name) {
		return service.fetchByName(name);
	}
	
	@Operation(summary="fetch student record by mobile")
	@GetMapping("students/mobile/{mobile}")
	public ResponseStructure fetchByMobile(@PathVariable long mobile) {
		return service.findByMobile(mobile);
	}
	
	@Operation(summary="fetch student record by result")
	@GetMapping("students/result/{result}")
	public ResponseStructure fetchByMobile(@PathVariable String result) {
		return service.findByMobile(result);
	}
	
	@Operation(summary="fetch student record subject and marks greater than")
	@GetMapping("students/{subject}/greater/{marks}")
	public ResponseStructure findBySubjectMarksGreater(@PathVariable String subject,@PathVariable int marks) {
		return service.findBySubjectMarksGreater(subject,marks);
	}
}