package com.app.petparadise.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="User")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private String aadhaar_no;
	
	@Column(nullable=false, unique=true)
	private String email;
	
	@Column(nullable=false)
	private String fname;
	
	@Column(nullable=false)
	private String lname;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private long phone_no;
	
	@Column(nullable=false, unique=true)
	private String username;
	
	@Column(nullable=false)
	private int usertype;
	
	@OneToMany(mappedBy="user")
	private List<Pet> pets;
	
	@OneToMany(mappedBy="buyer")
	private List<BuySell> buys;
	
	@OneToMany(mappedBy="seller")
	private List<BuySell> sells;
	

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

	

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}

	public int getId() {
		return id;
	}
	
	public UserPojo toPOJO()
	{
		UserPojo up = new UserPojo();
		up.setAadhaar_no(aadhaar_no);
		up.setEmail(email);
		up.setFname(fname);
		up.setId(id);
		up.setLname(lname);
		up.setPassword(password);
		List<PetPojo> petsp = new ArrayList();
		for(Pet p: pets)
		{
			petsp.add(p.toPOJO());
		}
		up.setPets(petsp);
		up.setPhone_no(phone_no);
		up.setUsername(username);
		up.setUsertype(usertype);
		return up;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public List<BuySell> getBuys() {
		return buys;
	}

	public List<BuySell> getSells() {
		return sells;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", aadhaar_no=" + aadhaar_no + ", email=" + email + ", fname=" + fname + ", lname="
				+ lname + ", password=" + password + ", phone_no=" + phone_no + ", username=" + username + ", usertype="
				+ usertype + ", pets=" + pets + ", buys=" + buys + ", sells=" + sells + "]";
	}
	
	
	

}

