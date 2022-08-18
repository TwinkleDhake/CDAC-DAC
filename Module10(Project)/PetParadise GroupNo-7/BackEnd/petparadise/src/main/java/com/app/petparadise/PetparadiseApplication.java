package com.app.petparadise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PetparadiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetparadiseApplication.class, args);
	}

}
 