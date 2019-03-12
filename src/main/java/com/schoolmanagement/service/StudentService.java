package com.schoolmanagement.service;

import java.util.List;

import com.schoolmanagement.entity.Course;
import com.schoolmanagement.entity.Student;
import com.schoolmanagement.entity.StudentDetailsView;

public interface StudentService {

	public List<Student> getStudents();

	public void saveStudent(Student theStudent);

	public StudentDetailsView getStudent(int studentId);

	public List<Course> getCourses();
}
