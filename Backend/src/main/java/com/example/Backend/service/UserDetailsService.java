package com.example.Backend.service;

import com.example.Backend.model.User;
import com.example.Backend.utility.ErrorUtility;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Backend.repo.RoleRepo;
import com.example.Backend.repo.UserRepo;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
@Service
public class UserDetailsService {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    //finding user by email
    public User findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }
    //view user detail
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
    //creating user
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        userRepo.save(user);
    }
    public String newUser(int id,int empId,String email,String password,String fullname){
        User user = new User();
        user.setId(id);
        user.setEmpId(empId);
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setFullname(fullname);
        user.setEnabled(true);
        userRepo.save(user);
        return "User Created";
}
}
