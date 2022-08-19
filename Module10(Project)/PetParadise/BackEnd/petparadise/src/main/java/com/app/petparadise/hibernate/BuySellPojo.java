package com.app.petparadise.hibernate;


public class BuySellPojo 
{
	private int id;
	
	private UserPojo buyer;
	
	private PetPojo pet;
	
	private UserPojo seller;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserPojo getBuyer() {
		return buyer;
	}

	public void setBuyer(UserPojo buyer) {
		this.buyer = buyer;
	}

	public PetPojo getPet() {
		return pet;
	}

	public void setPet(PetPojo pet) {
		this.pet = pet;
	}

	public UserPojo getSeller() {
		return seller;
	}

	public void setSeller(UserPojo seller) {
		this.seller = seller;
	}

	
}
