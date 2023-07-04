package model;

import java.io.Serializable;

public class User implements Serializable{
	
	private int userType;
	private String name;
	private String mail;
	private String pass;
	
	public User() {		
	}
	
	public User(String mail, String pass) {
		this.mail = mail;
		this.pass = pass;
	}
	
	public User(int userType, String name, String mail, String pass) {
		this.userType = userType;
		this.name = name;
		this.mail = mail;
		this.pass = pass;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}	
	
}
