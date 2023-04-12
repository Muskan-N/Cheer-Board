package com.example.Backend.service;

import com.example.Backend.model.User;
import com.example.Backend.repo.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;


class UserServiceTestUpdated {
    @Mock
    UserRepo userRepo;

    @InjectMocks
    UserService userService;
     private User user;
    @BeforeEach
    void setUp() {
        user=User.builder()
                        .empId(101)
                        .email("muskan12@nagarro.com")
                        .password("Muskan")
                        .fullname("Muskan Singh")
                        .role("Developer")
                                .build();
    }

    @Test
    void findUserByEmail() {
        given(userRepo.findByEmail("muskan12@nagarro.com")).willReturn(user);
        //when
        User user1 = userService.findUserByEmail(user.getEmail());
        // then
        assertEquals(user1,user);
    }

//    @Test
//    void loginUser() {
//        given(userRepo.findByEmail("muskan12@nagarro.com")).willReturn(new ResponseEntity<>("Login Successful", HttpStatus.OK));
//
//
//
//
//
//    }
}