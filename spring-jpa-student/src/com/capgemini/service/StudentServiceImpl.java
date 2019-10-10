package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.StudentDao;
import com.capgemini.model.Student;
import com.capgemini.model.User;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao dao = null;

	public StudentDao getDao() {
		return dao;
	}

	public void setDao(StudentDao dao) {
		this.dao = dao;
	}

	@Override
	@Transactional
	public boolean admitStudent(Student student) {
		int result = dao.insertStudent(student);
		if (result == 1)
			return true;
		else
			return false;
	}

	@Override
	@Transactional
	public boolean suspendStudent(int id) {
		int result = dao.deleteStudent(id);
		if (result == 1)
			return true;
		else
			return false;
	}

	@Override
	@Transactional
	public boolean upgradeStudent(Student student) {
		int result = dao.updateStudent(student);
		if (result == 1)
			return true;
		else
			return false;
	}

	@Override
	public List<Student> showStudents() {
		return dao.selectAllStudents();
	}

	@Override
	public Student showStudentById(int id) {
		return dao.selectStudentById(id);
	}

	@Override
	public boolean checkLogin(User user) {
		int result = dao.authenticateLogin(user);
		if (result == 1)
			return true;
		else
			return false;
	}

}
