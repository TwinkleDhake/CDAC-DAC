package com.app.petparadise.hibernate;

import java.util.List;


public class UserPojo 
{
private int id;
	
	private String aadhaar_no;
	
	private String email;
	
	private String fname;
	
	private String lname;
	
	private String password;
	
	private long phone_no;
	
	private String username;
	
	private int usertype;
	
	private List<PetPojo> pets;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAadhaar_no() {
		return aadhaar_no;
	}

	public void setAadhaar_no(String aadhaar_no) {
		this.aadhaar_no = aadhaar_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int isUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}

	public List<PetPojo> getPets() {
		return pets;
	}

	public void setPets(List<PetPojo> pets) {
		this.pets = pets;
	}
}
