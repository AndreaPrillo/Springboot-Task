package SPID.demo;

import SPID.demo.entities.Spid;
import SPID.demo.entities.Status;
import SPID.demo.entities.Type;
import SPID.demo.entities.User;
import SPID.demo.services.SpidService;
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

	@Autowired
	SpidService spidService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		User user=new User(LocalDateTime.now(),"andrea06","andrea","prillo","andrea06","ap@gmail.com","1234","1");
		userService.createUser(user);
		Spid spid= new Spid(LocalDateTime.now(),"andrea06",user,"Spid12", Status.PENDING, Type.LEVEL_1);
		spidService.createSpid(spid);
	}
}
