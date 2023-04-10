package com.example.Backend.serviceTest;

import com.example.Backend.Requests.UserloginRequest;
import com.example.Backend.model.User;
import com.example.Backend.repo.UserRepo;
import com.example.Backend.service.UserService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserRepo userRepo;

    @InjectMocks
    UserService userService;
    private User user;
    @BeforeEach
    public void setUp(){
        user=User.builder().empId(101)
                .email("muskan1@nagarro.com")
                .password("Muskan")
                .fullname("Muskan Singh")
                .role("Developer")
                .build();
    }
    @DisplayName("JUnit test for findUserByEmail method ")
    @Test
    public void findUserByEmailTest1() {
        given(userRepo.findByEmail("muskan1@nagarro.com")).willReturn(user);
        // when
        User user1 = userService.findUserByEmail(user.getEmail());
        // then
        assertEquals(user1, user);
    }

    @DisplayName("JUnit test for loginUser method case : 1 ")
    @Test
    public void loginUserTest() {
        String email = "muskan12@nagarro.com";
        UserloginRequest request = new UserloginRequest();
        // when
        ResponseEntity user1 = userService.loginUser(request);
        // then
        assertEquals("Login Successful", user1);
    }

}
