package com.app.petparadise.controllers;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.petparadise.hibernate.BuySell;
import com.app.petparadise.hibernate.Pet;
import com.app.petparadise.hibernate.PetPojo;
import com.app.petparadise.hibernate.PetReg;
import com.app.petparadise.hibernate.User;
import com.google.gson.Gson;


@RestController
@RequestMapping("/api/pets")
@CrossOrigin
public class PetController {

	@GetMapping("/allpets")
	public String getUsers() {

		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Pet");

		List<Pet> list = query.list();

		List<PetPojo> pets = new ArrayList();
		for (Pet p : list) {
			pets.add(p.toPOJO());
		}
		String json = new Gson().toJson(pets);

		transaction.commit();

		session.close();

		return json;

	}

	@PostMapping("/viewpets")
	public String viewPet(@RequestBody User user) {

		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		List<Pet> list = session.createQuery("FROM Pet p WHERE p.user.id =:id ", Pet.class)
				.setParameter("id", user.getId()).getResultList();

		List<PetPojo> pets = new ArrayList();
		for (Pet p : list) {
			pets.add(p.toPOJO());
		}
		String json = new Gson().toJson(pets);//to overcome circular error

		transaction.commit();

		session.close();

		return json;

	}

	@PostMapping("/buyerpetdisp")
	public String BuyerPetDisp(@RequestBody User user) {
		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<BuySell> p = session.createQuery("FROM BuySell bs WHERE bs.buyer.id =:id ", BuySell.class)
				.setParameter("id", user.getId()).getResultList();

		List<Pet> pets_data = new ArrayList();
		for (BuySell p1 : p) {

			pets_data.add(p1.getPet());
		}

		List<PetPojo> pets = new ArrayList();
		for (Pet p1 : pets_data) {
			pets.add(p1.toPOJO());
		}
		String json = new Gson().toJson(pets);

		transaction.commit();

		session.close();

		return json;

	}

	@PostMapping("/getpets")
	public String getPets(@RequestBody Pet pet) {

		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Pet p = session.createQuery("FROM Pet p WHERE p.id =:id ", Pet.class).setParameter("id", pet.getId())
				.uniqueResult();

		int user_id = p.getUser().getId();

		User u = session.createQuery("from User u where  u.id=:c", User.class).setParameter("c", user_id)
				.getSingleResult();

		String json = new Gson().toJson(u.toPOJO());

		return json;

	}

	@PostMapping("/buypets")
	public String BuyPet(@RequestBody PetReg pet) {

		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		BuySell p = session.createQuery("FROM BuySell bs WHERE bs.pet.id =:id ", BuySell.class)
				.setParameter("id", pet.getId()).uniqueResult();

		User u = session.createQuery("from User u where  u.id=:c", User.class).setParameter("c", pet.getUid())
				.uniqueResult();

		p.setBuyer(u);
		session.save(p);
		transaction.commit();

		session.close();
		return "ok";

	}

	@PostMapping("/addpet")
	public boolean addPet(@RequestBody PetReg pet) {
		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Pet pet1 = new Pet();
		BuySell buySell = new BuySell();
		pet1.setAge(pet.getAge());
		pet1.setBreed(pet.getBreed());
		pet1.setColor(pet.getColor());
		pet1.setGender(pet.getGender());
		pet1.setPetname(pet.getPetname());
		pet1.setPrice(pet.getPrice());
		pet1.setStatus(pet.getStatus());
		pet1.setType(pet.getType());
		User u = session.createQuery("from User u where  u.id=:c", User.class).setParameter("c", pet.getUid())
				.uniqueResult();

		pet1.setUser(u);
		buySell.setPet(pet1);
		buySell.setSeller(u);
		session.save(pet1);
		session.save(buySell);

		transaction.commit();

		session.close();

		return true;

	}
}
