package com.example.Backend.service;

import com.example.Backend.model.User;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import com.example.Backend.repo.UserRepo;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailsServiceTest {
    @Mock
    private UserRepo userRepo;

    private UserDetailsService userService;

    @BeforeEach
    void setUp()
    {
        this.userService
                = new UserDetailsService(userRepo);
    }

    @Test
    public void findUserByEmail1()
    {
        userService.findUserByEmail("muskan@nagarro.com");


    }
    @Test
    public void findUserByEmail2()
    {
        userService.findUserByEmail("muskan58@nagarro.com");

    }
}
