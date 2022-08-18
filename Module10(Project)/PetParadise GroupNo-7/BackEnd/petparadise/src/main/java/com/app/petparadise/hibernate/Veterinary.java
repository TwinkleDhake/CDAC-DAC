package com.app.petparadise.hibernate;

import javax.persistence.*;

@Entity
@Table(name="veterinary")
public class Veterinary 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column(nullable=false)
	public String name;
	
	@Column(nullable=false)
	public String hospital_name;
	
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

	public String getHospital_name() {
		return hospital_name;
	}

	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
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
