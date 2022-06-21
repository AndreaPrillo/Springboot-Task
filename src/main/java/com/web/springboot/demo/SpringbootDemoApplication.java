package com.web.springboot.demo;

import com.web.springboot.demo.entities.USER;
import com.web.springboot.demo.entities.SPID;
import com.web.springboot.demo.entities.Status;
import com.web.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;

@SpringBootApplication
public class SpringbootDemoApplication implements CommandLineRunner {

	@Autowired
	UserService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception{
		service.createUser(1, new Timestamp(System.currentTimeMillis()), "andrea28", "andrea", "prillo", "andrea28");
		service.createUser(2, new Timestamp(System.currentTimeMillis()), "devis04", "devis", "dervishi", "devis04");
		service.createSpid(1,new Timestamp(System.currentTimeMillis()),(USER)service.getDbUser(1),"Spid one");
		service.createSpid(2,new Timestamp(System.currentTimeMillis()),(USER)service.getDbUser(2),"Spid two");

		USER user=(USER)service.getDbUser(1);
		System.out.println(user);

		service.editSpid(1, "Spid one updated", Status.APPROVED);
		service.editUser(2, "devis05", "david", "beckham");
		service.changeSpidStatusToAproved(2);

		for(SPID s:service.listAllSpids()) {
			System.out.println(s);
		}

		System.out.println(service.spidConnectedToUser(1));
		System.out.println(service.spidCreatedBy(2));


	}

}
