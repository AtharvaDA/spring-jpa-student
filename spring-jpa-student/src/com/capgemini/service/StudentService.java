package com.capgemini.service;

import java.util.List;

import com.capgemini.model.Student;
import com.capgemini.model.User;

public interface StudentService {
	public boolean admitStudent(Student student);
	public boolean suspendStudent(int id);
	public boolean upgradeStudent(Student student);
	public List<Student> showStudents();
	public Student showStudentById(int id);
	public boolean checkLogin(User user);
}
