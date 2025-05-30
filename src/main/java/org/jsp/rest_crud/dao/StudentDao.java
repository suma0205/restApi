package org.jsp.rest_crud.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.rest_crud.dto.Student;
import org.jsp.rest_crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentDao {

	@Autowired
	StudentRepository repository;

	public void saveStudent(Student student) {
		repository.save(student);

	}

	public Optional<Student> findById(int id) {
		return repository.findById(id);
	}

//	public Boolean deleteById(int id) {
//		int rowsAffected=repository.deleteById(id);
//		return rowsAffected>0;
//	}

//	public Boolean deleteById(int id) {
//		repository.deleteById(id);;
//		return null;
//	}

	public List<Student> fetchAllRecords() {
		return repository.findAll();
	}

	public void saveStudents(List<Student> students) {
		repository.saveAll(students);
	}

	public List<Student> findByName(String name) {
		// TODO Auto-generated method stub
		return repository.findByName(name);
	}

	public List<Student> findByMobile(long mobile) {
		return repository.findByMobile(mobile);
	}

	public List<Student> findByMobile(String result) {
		return repository.findByResult(result);
	}

	public List<Student> fetchByMathsGreater(int marks) {
		return repository.findByMathsGreaterThanEqual(marks);
	}

	public List<Student> fetchByScienceGreater(int marks) {
		return repository.findByScienceGreaterThanEqual(marks);
	}

	public List<Student> fetchByEnglishGreaterThan(int marks) {
		return repository.findByEnglishGreaterThanEqual(marks);
	}
}