package com.app.petparadise.controllers;

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

import com.app.petparadise.hibernate.PetCareTaker;
import com.google.gson.Gson;

@RestController
@RequestMapping("/api/petcaretaker")
@CrossOrigin

public class PetCareTakerController {

	@PostMapping("/savepetcaretaker")
	public boolean setPetCaretaker(@RequestBody PetCareTaker petcaretaker) {

		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(petcaretaker);

		transaction.commit();

		session.close();

		return true;

	}

	@GetMapping("/allpetcaretaker")
	public String getPetCareTaker() {

		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from PetCareTaker");

		List<PetCareTaker> list = query.list();

		System.out.println("fun call");
		String json = new Gson().toJson(list);

		transaction.commit();

		session.close();

		return json;

	}
}
