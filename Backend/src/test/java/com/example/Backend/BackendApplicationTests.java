package com.example.Backend;

import com.example.Backend.model.User;
import com.example.Backend.repo.UserRepo;
import com.example.Backend.service.UserDetailsService;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendApplicationTests {
//	@Autowired
//	private UserDetailsService service;
//	@MockBean
//	private UserRepo userRepo;
//
//	@Test
//	public void getUsersTest1(){
//	 when(userRepo.findAll()).thenReturn(Stream
//		 .of(new User(102,10123,"muskan@n12agarro.com","muskan","Muskan Singh",true)).collect(Collectors.toList()));
//	assertEquals(1,service.getUser().size());
//
//	}
//	@Test
//	public void getUserByEmail(){
//
//		service.findUserByEmail("muskan@nagarro.com");
//		verify(userRepo).;
//	}

    @Test
    void contextLoads() {

    }
}


