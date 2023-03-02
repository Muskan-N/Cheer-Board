package com.example.Backend.service;

import com.example.Backend.model.User;
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
    void findUserByEmail()
    {
        userService.findUserByEmail("muskan@nagarro.com");
        verify(userRepo).findByEmail("muskan@nagarro.com");
    }
}
