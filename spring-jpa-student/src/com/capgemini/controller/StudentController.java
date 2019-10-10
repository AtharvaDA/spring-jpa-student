package com.capgemini.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.model.Student;
import com.capgemini.model.User;
import com.capgemini.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String homePage(Model model){
		model.addAttribute("loginForm", new User());
		return "login";
	}
	
	@RequestMapping(path="/login.do", method=RequestMethod.POST)
	public String loginPage(@Valid @ModelAttribute("loginForm") User user, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "login";
		}
		boolean result=service.checkLogin(user);
		if(result)
			return "index";
		else
			return "error";
	}
	
	@RequestMapping(path="/addStudentPage")
	public String addStudentPage(Model model1, Model model2){
		model1.addAttribute("addStudentForm", new Student());
		List<Student> list= service.showStudents();
		model2.addAttribute("studentList", list);
		return "addStudent";
	}
	
	@RequestMapping(path="/addStudent.do", method=RequestMethod.POST)
	public String processAddStudent(Model model,@ModelAttribute("addStudentForm")Student student, BindingResult bindingResult){
		boolean result= service.admitStudent(student);
		List<Student> list= service.showStudents();
		model.addAttribute("studentList", list);
		if(result)
			return "addStudent";
		else
			return "error";
	}
	
	@RequestMapping(path="/deleteStudentPage")
	public String deleteStudentPage(){
		return "deleteStudent";
	}
	
	@RequestMapping(path="/deleteStudent.do", method=RequestMethod.POST)
	public String processDeleteStudent(@RequestParam("studentId")int id){
		boolean result= service.suspendStudent(id);
		if(result)
			return "redirect:/viewStudents.do";
		else
			return "error";
	}

	@RequestMapping(path="/viewStudentByIdPage")
	public String viewTraineeByIdPage(){
		return "viewStudentById";
	}
	
	@RequestMapping(path="/viewStudentById.do", method=RequestMethod.POST)
	public String processViewTraineeByID(@RequestParam("studentId") int id, Model model){
		Student student= new Student();
		student.setStudentId(id);;
		Student student1 = service.showStudentById(id);
		List<Student> list = new ArrayList<Student>();
		list.add(student1);
		model.addAttribute("studentList", list);
		return "viewStudent";
	}
	@RequestMapping(path="/updateStudentPage")
	public String blala(){
		return "update";
	}
	@RequestMapping(path="/modifyStudent")
	public String updateStudentPage(Model model, @RequestParam("studentId")int id){
		Student student=service.showStudentById(id);
		model.addAttribute("student", student);
		return "updateStudent";
	}
	
	@RequestMapping(path="/updateStudent.do", method=RequestMethod.POST)
	public String processUpdateStudent(@RequestParam("studentId")int id, @RequestParam("studentName")String name, @RequestParam("studentScore")float score){
		Student student= new Student();
		student.setStudentId(id);
		student.setStudentName(name);
		student.setStudentScore(score);
		boolean result=service.upgradeStudent(student);
		if(result)
			return "redirect:/viewStudents.do";
		else
			return "error";
	}
	@RequestMapping(path="/viewStudents.do")
	public String processViewAllStudents(Model model) {
		List<Student> list= service.showStudents();
		model.addAttribute("studentList", list);
		return "viewStudent";
	}
}
