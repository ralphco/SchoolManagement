package com.schoolmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course", schema="student_info")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="course_code")
	private String courseCode;
	
	@Column(name="course_title")
	private String courseTitle;
	
	@Column(name="course_time")
	private String courseTime;
	
	@Column(name="course_unit")
	private String courseUnit;
	
	@Column(name="classroom")
	private String classroom;
	
	@Column(name="prof_id")
	private String professorId;
	
	private int isChecked;
	
	public Course() {
		
	}

	public Course(String courseCode, String courseTitle, String courseTime, String courseUnit, String classroom,
			String professorId,int isChecked) {
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
		this.courseTime = courseTime;
		this.courseUnit = courseUnit;
		this.classroom = classroom;
		this.professorId = professorId;
		this.isChecked = isChecked;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseTime() {
		return courseTime;
	}

	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}

	public String getCourseUnit() {
		return courseUnit;
	}

	public void setCourseUnit(String courseUnit) {
		this.courseUnit = courseUnit;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public String getProfessorId() {
		return professorId;
	}

	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}

	public int getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(int isChecked) {
		this.isChecked = isChecked;
	}

}
