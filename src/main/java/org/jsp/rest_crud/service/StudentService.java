package org.jsp.rest_crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.rest_crud.dao.StudentDao;
import org.jsp.rest_crud.dto.Student;
import org.jsp.rest_crud.exception.DataNotFoundException;
import org.jsp.rest_crud.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class StudentService {
	
	@Autowired
	StudentDao dao;
	 
	@Autowired
	ResponseStructure structure;

	public ResponseStructure saveStudent(Student student) {
		double percentage=(student.getEnglish()+student.getScience()+student.getMaths())/3.0;
		student.setPercentage(percentage);
		if(student.getEnglish()<35 || student.getMaths()<35 || student.getScience()<35) {
			student.setResult("Fail");
		}else {
			if(student.getPercentage()>=85) 
				student.setResult("Distinction");
			else if(student.getPercentage()>=60) 
				student.setResult("First Class");
			else if(student.getPercentage()>=35) 
				student.setResult("Second Class");
			else
				student.setResult("Fail");
		}
		
		dao.saveStudent(student);
		structure.setMessage("Record saved success");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(student);
		return structure;
	}
	
	public ResponseStructure findById(int id) {
		Optional<Student> op=dao.findById(id);
		if(op.isEmpty()) {
			throw new DataNotFoundException("Data Not Found with id:"+id);
		}else {
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(op.get());
		}
		return structure;
	}

	public ResponseStructure fetchAllRecords() {
		List<Student> list=dao.fetchAllRecords();
		if(list.isEmpty()) {
			throw new DataNotFoundException("Data Not Found with records");
		}else {
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(list);
		}
		return structure;
	}

	public ResponseStructure saveStudents(List<Student> students) {
		for(Student student:students) {
			double percentage=(student.getEnglish()+student.getScience()+student.getMaths())/3.0;
			student.setPercentage(percentage);
			if(student.getEnglish()<35 || student.getMaths()<35 || student.getScience()<35) {
				student.setResult("Fail");
			}else {
				if(student.getPercentage()>=85) 
					student.setResult("Distinction");
				else if(student.getPercentage()>=60) 
					student.setResult("First Class");
				else if(student.getPercentage()>=35) 
					student.setResult("Second Class");
				else
					student.setResult("Fail");
			}
		}
		dao.saveStudents(students);
		
		structure.setMessage("Record saved success");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(students);
		return structure;
	}

	public ResponseStructure fetchByName(String name) {
		List<Student> list=dao.findByName(name);
		if(list.isEmpty()) {
			throw new DataNotFoundException("Data Not Found with name:"+name);
		}else {
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(list);
		}
		return structure;
		
	}

	public ResponseStructure findByMobile(long mobile) {
		List<Student> list=dao.findByMobile(mobile);
		if(list.isEmpty()) {
			throw new DataNotFoundException("Data Not Found with mobile:"+mobile);
		}else {
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(list);
		}
		return structure;
	}

	public ResponseStructure findByMobile(String result) {
		List<Student> list=dao.findByMobile(result);
		if(list.isEmpty()) {
			throw new DataNotFoundException("Data Not Found with result:"+result);
		}else {
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(list);
		}
		return structure;
	}

	public ResponseStructure findBySubjectMarksGreater(String subject, int marks) {
		List<Student> list=null;
		if(subject.equals("maths")) {
			list=dao.fetchByMathsGreater(marks);
		}else if(subject.equalsIgnoreCase("science")) {
			list=dao.fetchByScienceGreater(marks);
		}else if(subject.equalsIgnoreCase("english")) {
			list=dao.fetchByEnglishGreaterThan(marks);
		}
		else {
			list=new ArrayList<Student>();
		}
		if(list.isEmpty()) {
			throw new DataNotFoundException("Data Not Found with list");
		}else {
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(list);
		}
		return structure;
	}
		

}