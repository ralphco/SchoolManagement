package com.schoolmanagement.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.schoolmanagement.dao.StudentDAO;
import com.schoolmanagement.entity.Course;
import com.schoolmanagement.entity.Student;
import com.schoolmanagement.entity.StudentDetailsView;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	@Transactional
	public List<Student> getStudents() {
		
		return studentDAO.getStudents();
	}

	@Override
	@Transactional
	public void saveStudent(Student theStudent) {
		
		//Generate StudentNumber
		String studentNum;
		int year;
		
		LocalDate currentDate = LocalDate.now();
		
		year = currentDate.getYear();
		
		studentNum = (year + "000" + theStudent.getId());
		
		//Set StudentNumber
		theStudent.setStudentNumber(studentNum);
		
		studentDAO.saveStudent(theStudent);
	}

	@Override
	@Transactional
	public StudentDetailsView getStudent(int studentId) {

		return studentDAO.getStudent(studentId);
		
	}

	@Override
	@Transactional
	public List<Course> getCourses() {
		
		return studentDAO.getCourses();
	}
	
}
