package ar.com.api.cashonline.backendchallenge;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.api.cashonline.backendchallenge.entities.User;
import ar.com.api.cashonline.backendchallenge.services.UserService;


@SpringBootTest
class DemoApplicationTests {

	@Autowired
	UserService us;

	@Autowired
	User u;


	@Test
	void contextLoads() {
	}

	

}
