package com.app.petparadise.hibernate;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Pet")
public class Pet 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private int age;
	
	@Column(nullable=false)
	private String breed;
	
	@Column(nullable=false)
	private String color;
	
	@Column(nullable=false)
	private String gender;
	
	@Column(nullable=false)
	private String petname;
	
	@Column(nullable=false)
	private double price;
	
	@Column(nullable=false)
	private String status;
	
	@Column(nullable=false)
	private String type;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy="pet")
	private List<BuySell> buysell;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPetname() {
		return petname;
	}

	public void setPetname(String petname) {
		this.petname = petname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}
	
	public PetPojo toPOJO()
	{
		PetPojo pp = new PetPojo();
		pp.setBreed(breed);
		pp.setColor(color);
		pp.setGender(gender);
		pp.setId(id);
		pp.setAge(age);
		pp.setPrice(price);
		pp.setPrice(price);
		pp.setStatus(status);
		pp.setType(type);
		pp.setPetname(petname);
		return pp;
	}

	public List<BuySell> getBuysell() {
		return buysell;
	}
	
	
	
}
