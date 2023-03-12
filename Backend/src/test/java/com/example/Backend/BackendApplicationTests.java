package com.example.Backend;

import com.example.Backend.model.User;
import com.example.Backend.repo.UserRepo;
import com.example.Backend.service.UserDetailsService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
class BackendApplicationTests {
	@Autowired
	private UserDetailsService service;
	@MockBean
	private UserRepo userRepo;

	public void getUsersTest(){
	 when(userRepo.findAll()).thenReturn(Stream
			 .of(new User(1,"")));
	}

//	@Test
//	void contextLoads() {

	}

}
