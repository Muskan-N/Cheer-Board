package com.example.Backend.serviceTest;
//make swagger collection / postman colletion
//engineX

import com.example.Backend.model.User;
import com.example.Backend.repo.UserRepo;
import com.example.Backend.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {
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

}
