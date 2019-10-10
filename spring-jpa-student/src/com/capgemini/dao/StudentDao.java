package com.capgemini.dao;

import java.util.List;

import com.capgemini.model.Student;
import com.capgemini.model.User;

public interface StudentDao {
	public int insertStudent(Student student);
	public int deleteStudent(int id);
	public List<Student> selectAllStudents();
	public Student selectStudentById(int id);
	public int updateStudent(Student student);
	public int authenticateLogin(User user);
}
