package com.example.Backend.service;

import com.example.Backend.repo.UserRepo;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

public class ForgotPasswordServiceTest {
    @Mock
    private UserRepo userRepo;

    private ForgotPasswordService forgotPasswordService;

    @BeforeEach
    void setUp()
    {
        this.forgotPasswordService = new ForgotPasswordService();
    }

    @Test
    void findUserByEmail()
    {
        forgotPasswordService.forgotPassword("muskan@nagarro.com");
        verify(userRepo).findByEmail("muskan@nagarro.com");
    }
}
