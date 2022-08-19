package com.app.petparadise.hibernate;

import javax.persistence.*;

@Entity
@Table(name="trainer")
public class Trainer 
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
    public long phone;
    
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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
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
