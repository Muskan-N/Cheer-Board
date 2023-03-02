package com.example.Backend.service;

import com.example.Backend.model.User;
import com.example.Backend.repo.RoleRepo;
import com.example.Backend.repo.UserRepo;
import com.example.Backend.utility.ErrorUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

@Service
public class CustomUserDetailsService {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;


    public User findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public List<User> getUserDetailbyEmail(String email) {
        User user = userRepo.findByEmail(email);
        List<User> userList = new ArrayList<User>();

        if (email.equals(user.getEmail())) {
            user.setEmpId( user.getEmpId());
            user.setEmail(user.getEmail());
            user.setFullname(user.getFullname());
            userList.add(user);
            return userList;

        } else {
            throw new UsernameNotFoundException(ErrorUtility.USER_NOT_FOUND);
        }
    }
}