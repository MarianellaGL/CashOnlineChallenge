package ar.com.api.cashonline.backendchallenge;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.api.cashonline.backendchallenge.entities.User;
import ar.com.api.cashonline.backendchallenge.services.UserService;
import ar.com.api.cashonline.backendchallenge.services.UserService.UserValidationType;


@SpringBootTest
class DemoApplicationTests {

	@Autowired
	UserService us;

	@Autowired
	User u;


	@Test
	void contextLoads() {
	}

    @Test
	void verificarUser() {
		
		

		UserValidationType validationType = us.verifyUser(u);
		
		assertEquals(UserValidationType.USER_DATOS_INVALIDOS, validationType);

	}

	

}
