package com.app.petparadise.hibernate;

import javax.persistence.*;

@Entity
@Table(name="BuySell")
public class BuySell 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private User buyer;
	
	@ManyToOne
	private Pet pet;
	
	@ManyToOne
	private User seller;

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public int getId() {
		return id;
	}
	
	public BuySellPojo toPOJO()
	{
		BuySellPojo bsp = new BuySellPojo();
		bsp.setBuyer(buyer.toPOJO());
		bsp.setId(id);
		bsp.setPet(pet.toPOJO());
		bsp.setSeller(seller.toPOJO());
		return bsp;
	}
}
