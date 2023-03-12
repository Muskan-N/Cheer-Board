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
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailsServiceTest {
    @Autowired
    private UserDetailsService userDetailsService;
    @MockBean
    private UserRepo userRepo;

    @Test
    public void testFindByEmail(){

        User user = new User();
        user.setId(1);
        user.setEmpId(101);
        user.setEmail("muskan2@nagarro.com");
        user.setPassword("muskan");
        user.setFullname("Muskan");
        user.setEnabled(true);

        Mockito.when(userRepo.findByEmail("muskan2@nagarro.com")).thenReturn(user);

        assertThat(userDetailsService.findUserByEmail("muskan2@nagarro.com")).isEqualTo(user);
    }
}
