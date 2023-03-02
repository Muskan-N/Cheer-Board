package com.example.Backend.service;

import com.example.Backend.repo.UserRepo;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ForgotPasswordServiceTest {
    @Mock
    private UserRepo userRepo;

    private ForgotPasswordService forgotPasswordService;

    @BeforeEach
    void setUp()
    {
        this.forgotPasswordService
                = new ForgotPasswordService();
    }

    @Test
    public void forgotPassword1()
    {
        forgotPasswordService.forgotPassword("muskan@nagarro.com");
        //verify(userRepo).findByEmail("muskan98@nagarro.com");

    }
    @Test
    public void forgotPassword2()
    {
        forgotPasswordService.forgotPassword("muskan98@nagarro.com");
        verify(userRepo).findByEmail("muskan58@nagarro.com");
    }
}
