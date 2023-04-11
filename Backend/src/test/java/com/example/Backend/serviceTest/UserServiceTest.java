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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.aggregation.AggregationExpression;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.springframework.data.mongodb.core.aggregation.ConditionalOperators.Switch.CaseOperator.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
     UserRepo userRepo;

    @InjectMocks
     UserService userService;

    @DisplayName("JUnit test for findUserByEmail method")
    @Test
    public void findUserByEmailTest1() {
        final User user = new User(101,"muskan1@nagarro.com","Muskan","Muskan Singh","Developer");
        given(userRepo.findByEmail("muskan1@nagarro.com")).willReturn(user);

        // when
        User user1 = userService.findUserByEmail(user.getEmail());

        // then
      assertEquals(user1,user);
    }

    @DisplayName("JUnit test for loginUser method case : 1 ")
    @Test
    public void loginUserTest() {
        final User user = new User(101,"muskan12@nagarro.com","Muskan","Muskan Singh","Developer");
        Mockito.when(userRepo.save(user)).thenReturn(user);
        //given(userRepo.findByEmail("muskan@12@gmail.com")).willReturn(user);
        System.out.println("user : "+user);
        String email = "preeti@nagarro.com";
        UserloginRequest request = new UserloginRequest();
        request.setEmail(email);
        // when
        ResponseEntity userE = userService.loginUser(request);
        // then
        assertEquals(new ResponseEntity<>("Login Successful", HttpStatus.OK), userE);
    }
}
