package com.app.petparadise.hibernate;

import javax.persistence.*;

@Entity
@Table(name="petcaretaker")
public class PetCareTaker 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column(nullable=false)
    public String name;
	
	@Column(nullable=false)
	public String center_name;
	
	@Column(nullable=false)
	public String address;
	
	@Column(nullable=false)
	public long phone_no;
	
	@Column(nullable=false)
	public String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCenter_name() {
		return center_name;
	}

	public void setCenter_name(String center_name) {
		this.center_name = center_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}
	
	
}
