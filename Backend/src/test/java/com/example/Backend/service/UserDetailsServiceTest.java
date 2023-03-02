package com.example.Backend.service;

import com.example.Backend.model.User;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import com.example.Backend.repo.UserRepo;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserDetailsServiceTest {
    @Mock
    private UserRepo userRepo;

    private UserDetailsService userService;

    @BeforeEach
    void setUp()
    {
        this.userService
                = new UserDetailsService();
    }

    @Test
    void findUserByEmail1()
    {
        userService.findUserByEmail("muskan98@nagarro1.com");
        verify(userRepo).findByEmail("muskan98@nagarro1.com");
        System.out.println("test case hit");
        assertThat("muskan98@nagarro1.com");
    }
    @Test
    void findUserByEmail2()
    {
        userService.findUserByEmail("muskan58@nagarro.com");
        verify(userRepo).findByEmail("muskan58@nagarro.com");
    }
}
