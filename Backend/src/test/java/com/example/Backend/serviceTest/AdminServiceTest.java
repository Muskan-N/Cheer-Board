package com.example.Backend.serviceTest;
//make swagger collection / postman colletion
//engineX

import com.example.Backend.Requests.CreateUserRequest;
import com.example.Backend.Requests.UserloginRequest;
import com.example.Backend.model.User;
import com.example.Backend.repo.UserRepo;
import com.example.Backend.service.AdminService;
import com.example.Backend.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {
    @Mock
    UserRepo userRepo;

    @InjectMocks
    AdminService adminService;

    @DisplayName("JUnit test for findUserByEmail method")
    @Test
    public void findUserByEmailTest() {
        final User user = new User(101,"muskan1@nagarro.com","Muskan","Muskan Singh","Developer");
        when(userRepo.findByEmail("muskan1@nagarro.com")).thenReturn(user);
        // when
        User user1 = adminService.findUserByEmail(user.getEmail());
        // then
        assertEquals(user1,user);
    }
    @DisplayName("JUnit test for findUserByEmpId method")
    @Test
    public void findUserByEmpIdTest() {
        final User user = new User(101,"muskan1@nagarro.com","Muskan","Muskan Singh","Developer");
        when(userRepo.findByEmpId(101)).thenReturn(user);
        // when
        User user1 = adminService.findUserByEmpId(user.getEmpId());
        // then
        assertEquals(user1,user);
    }
    @DisplayName("JUnit test for createUser method")
    @Test
    public void createUserTest() {
        final User user = new User(101,"muskan1@nagarro.com","Muskan","Muskan Singh","Developer");
        Mockito.when(userRepo.save(user)).thenReturn(user);
        System.out.println(userRepo);
        System.out.println(adminService);
        CreateUserRequest request = new CreateUserRequest();
//        int empId=101;
//        String email = "preeti@nagarro.com";
//        String password = "123";
//        String fullname = "preeti";
//        String role="Engineering Manager";
        request.setEmpId(user.getEmpId());
        request.setEmail(user.getEmail());
        request.setPassword(user.getPassword());
        request.setFullName(user.getFullname());
        request.setRole(user.getRole());
        // when -  action or the behaviour that we are going test
        ResponseEntity createUser = adminService.createUser(request);
        System.out.println(createUser);
        // then - verify the output
        assertEquals(new ResponseEntity<>("User Created", HttpStatus.CREATED),createUser);
        //assertThat(createUser).isNotNull();
    }

}
