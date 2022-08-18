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

import com.app.petparadise.hibernate.Trainer;
import com.google.gson.Gson;

@RestController
@RequestMapping("/api/trainer")
@CrossOrigin
public class TrainerController {
	


		@PostMapping("/savetrainer")
		public boolean setUsers(@RequestBody Trainer trainer) {
			
			StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder().configure().build();
			Metadata metadata=new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
			SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();
			Session session=sessionFactory.openSession();
			Transaction Transaction = session.beginTransaction();
			
			session.save(trainer);
			
		
			Transaction.commit();
			
			session.close();
			
			return true;

		}
		
		
		
		@GetMapping("/alltrainer")
		public String getTrainer() {
			
			StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder().configure().build();
			Metadata metadata=new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
			SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();
			Session session=sessionFactory.openSession();
			Transaction Transaction = session.beginTransaction();
			
			Query query = session.createQuery("from Trainer");
			
			List<Trainer> list = query.list();

			String json = new Gson().toJson(list);
		
			Transaction.commit();
			
			session.close();
			
			return json;

		}
	}




  

 


