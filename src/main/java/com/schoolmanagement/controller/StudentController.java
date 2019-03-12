package com.schoolmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.schoolmanagement.entity.Course;
import com.schoolmanagement.entity.Student;
import com.schoolmanagement.entity.StudentAddress;
import com.schoolmanagement.entity.StudentDetailsView;
import com.schoolmanagement.service.StudentService;

@Controller
@Component
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
	
	//Get list of students
	@GetMapping("/list")
	public String listStudents(Model theModel) {
		
		List<Student> theStudents = studentService.getStudents();
		
		theModel.addAttribute("student", theStudents);
		
		System.out.println("Returning: " + theStudents.size());
		
		return "list-students";
	}
	
	@GetMapping("/showAddStudent")
	public String addStudents(Model theModel) {
		
		Student newStudent = new Student();
		StudentAddress addressDetails = new StudentAddress();
		
		theModel.addAttribute("student", newStudent);
		theModel.addAttribute("studentAddress", addressDetails);
		
		return "add-student";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@Valid @ModelAttribute("student") Student theStudent
			                 ,@Valid @ModelAttribute("studentAddress") StudentAddress theStudentAddress
			                 ,BindingResult theBindingResult
			                 ,ModelMap theModel) {
		
		//Set Student Address Details to Student Object
		System.out.println("=====> Checking the input");
		if (theBindingResult.hasErrors()) {
			System.out.println("=====> Here in theBindingResult errors part");
            return "add-student";
        } else {
        	theStudent.setStudentAddress(theStudentAddress);
        	
        	studentService.saveStudent(theStudent);
        	
        	return "redirect:/student/list";
        }
	}
	
	@GetMapping("/showStudentDetails")
	public String getStudent(@RequestParam("studentId") int studentId, Model theModel) {
		
		StudentDetailsView theStudent = studentService.getStudent(studentId);
		
		theModel.addAttribute("studentDetailView", theStudent);
		
		return "student-details";
	}
	
	@GetMapping("/showEnrollPage")
	public String getListCourses(Model theModel) {
		
		List<Course> theCourses = studentService.getCourses();
		  
		theModel.addAttribute("Course", theCourses);
		
		return "enroll-subjects";
	}
}
