package com.capgemini.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.model.Student;
import com.capgemini.model.User;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public StudentDaoImpl(){
		
	}
	@Override
	public int insertStudent(Student student) {
		entityManager.persist(student);
		return 1;
	}

	@Override
	public int deleteStudent(int id) {
		Query query= entityManager.createQuery("Delete from Student s where s.studentId= :sid");
		query.setParameter("sid", id);
		int result= query.executeUpdate();
		if(result==1)
			return 1;
		else 
			return 0;
	}

	@Override
	public List<Student> selectAllStudents() {
		TypedQuery<Student> tquery= entityManager.createQuery("From Student", Student.class);
		List<Student> list= tquery.getResultList();
		return list;
	}

	@Override
	public Student selectStudentById(int id) {
		Student student=entityManager.find(Student.class, id);
		return student;
	}

	@Override
	public int updateStudent(Student student) {
		entityManager.merge(student);
		return 1;
	}
	@Override
	public int authenticateLogin(User user) {
		TypedQuery<User> tquery= entityManager.createQuery("From User", User.class);
		List<User> list= tquery.getResultList();
		for(User login: list){
			if(login.getUser().equals(user.getUser()) && login.getPass().equals(user.getPass()))
				return 1;
		}
		return 0;
	}

}
