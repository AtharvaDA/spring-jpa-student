package com.capgemini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Students")
public class Student {
	@Id
	@Column(name="studentid")
	private int studentId;
	@Column(name="studentname")
	private String studentName;
	@Column(name="studentscore")
	private float studentScore;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public float getStudentScore() {
		return studentScore;
	}
	public void setStudentScore(float studentScore) {
		this.studentScore = studentScore;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName="
				+ studentName + ", studentScore=" + studentScore + "]";
	}
	
	
}
