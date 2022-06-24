package SPID.demo;

import SPID.demo.entities.Spid;
import SPID.demo.entities.Status;
import SPID.demo.entities.Type;
import SPID.demo.entities.User;
import SPID.demo.services.SpidService;
import SPID.demo.services.UserService;
import lombok.experimental.SuperBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@SpringBootTest(classes = {DemoApplication.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DemoApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private SpidService spidService;


	@Test
	public void doesItCreateUser( ){
		User user=new User(LocalDateTime.now(),"andrea06","andrea","prillo","andrea06","ap@gmail.com","1234","1");
		userService.createUser(user);
		Assertions.assertNotNull(userService.getUser(user.getId()));
	}
	@Test
	public void doesItCreateSpid( ){
		User user=new User(LocalDateTime.now(),"andrea06","andrea","prillo","andrea06","ap@gmail.com","1234","1");
		userService.createUser(user);
		Spid spid= new Spid(LocalDateTime.now(),"andrea06",user,"Spid12", Status.PENDING, Type.LEVEL_1);
		spidService.createSpid(spid);
		Assertions.assertNotNull(spidService.getSpid(spid.getId()));
	}
	@Test
	public void doesItDeleteSpid(){
		User user=new User(LocalDateTime.now(),"andrea06","andrea","prillo","andrea06","ap@gmail.com","1234","1");
		userService.createUser(user);
		Spid spid= new Spid(LocalDateTime.now(),"andrea06",user,"Spid12", Status.PENDING, Type.LEVEL_1);
		spidService.createSpid(spid);
		spidService.deleteSpid(spid.getId());
		Assertions.assertNull(spidService.getSpid(spid.getId()));
	}

}
