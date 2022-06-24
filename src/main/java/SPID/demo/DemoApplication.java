package SPID.demo;

import SPID.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import SPID.demo.services.UserService;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
//		System.out.println(userService.createUser(new User());
	}
}
