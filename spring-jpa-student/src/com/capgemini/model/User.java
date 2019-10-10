package com.capgemini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="login")
public class User {
	@Id
	@Size(min=2, max=12, message="Give the username you idiot")
	@Column(name="username")
	private String user;
	@Size(min=2, max=12, message="The password is not valid")
	@Column(name="password")
	private String pass;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "User [user=" + user + ", pass=" + pass + "]";
	}
	
	
}
