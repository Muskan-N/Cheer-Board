package com.example.Backend.service;

import com.example.Backend.model.UpdatedUser;
import com.example.Backend.model.User;
import com.example.Backend.repo.RoleRepo;
import com.example.Backend.repo.UpdatedUserRepo;
import com.example.Backend.repo.UserRepo;
import com.example.Backend.utility.ErrorUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

//three
@Service
public class CustomUserDetailsService {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Autowired
    public UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;
    
    @Autowired
    private UpdatedUserRepo updatedUserRepo;

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



    //new

    public void updateResetPasswordToken(String token, String email)  {
        UpdatedUser UpdatedUser= updatedUserRepo.findByEmail(email);
        if (UpdatedUser != null) {
            UpdatedUser.setResetPasswordToken(token);
            updatedUserRepo.save(UpdatedUser);
        } else {
            System.out.println("Could not find any customer with the email " + email);
        }
    }

    public UpdatedUser getByResetPasswordToken(String token) {
        return updatedUserRepo.findByResetPasswordToken(token);
    }

    public void updatePassword(UpdatedUser customer, String newPassword) {
        UpdatedUser updatedUser = new UpdatedUser();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        updatedUser.setPassword(encodedPassword);

        customer.setResetPasswordToken(null);
        updatedUserRepo.save(customer);
    }
}