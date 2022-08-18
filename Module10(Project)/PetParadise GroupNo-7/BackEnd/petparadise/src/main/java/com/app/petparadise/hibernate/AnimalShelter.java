package com.app.petparadise.hibernate;

import javax.persistence.*;

@Entity
@Table(name="animalshelter")
public class AnimalShelter 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column(nullable=false)
    public String name;
	
	@Column(nullable=false)
	public String address;
	
	@Column(nullable=false)
	public long phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public int getId() {
		return id;
	}
	
	
}
