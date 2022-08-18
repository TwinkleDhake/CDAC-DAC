package com.app.petparadise.controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.app.petparadise.hibernate.User;

@RestController
@RequestMapping("/api/registration")
@CrossOrigin
public class UserController {

	@PostMapping("/signup")
	public boolean getUsers(@RequestBody User user) {
		
		StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata=new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();
		Session session=sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		
		session.save(user);
		
	
		transaction.commit();
		
		session.close();
		
		return true;

	}
	
	@PostMapping("/login")//postmapping to insert data in database
	public String loginCheck(@RequestBody User user) { // to get data from frontend we used->requestbody
		
		StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata=new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();
		Session session=sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		
		
	Query query = session.createQuery("from User where username=: user and password=:pwd");
		
	query.setParameter("user", user.getUsername());
	query.setParameter("pwd", user.getPassword());
	User u = (User) query.getSingleResult();
	

		String json = new Gson().toJson(u.toPOJO()); // to overcome circular error
	
		transaction.commit();
		
		session.close();
		
		return json;

	}
	
}
