package com.example.Backend.service;

import com.example.Backend.model.Role;
import com.example.Backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Backend.repo.RoleRepo;
import com.example.Backend.repo.UserRepo;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.Backend.utility.ErrorUtility;
import com.example.Backend.utility.UtilityString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.logging.Logger;
//three
@Service
public class CustomUserDetailsService {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    //mocking data in user table
//     void createUser(){
//        UserRepo.save(new UserRepo(1, 01, "muskan.singh@nagarro.com", "password", "muskan", true, " x");
//
//         LOGGER.log(Level.INFO, "user created");
//    }
    //finding user by email
    public User findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    //creating user
    public void saveUser(User user) {
        Role userRole = roleRepo.findByRole(UtilityString.ADMIN);
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        user.setPassword(user.getPassword());
        if (userRole.equals(UtilityString.ADMIN)) {
            user.setEnabled(true);
        }
        userRepo.save(user);
    }


    //reading user
    public String readUserByName(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        if (user != null) {
            user.getFullname();
            user.getRoles();
            return "";
        } else {
            throw new UsernameNotFoundException(ErrorUtility.USER_NOT_FOUND);
        }
    }

}