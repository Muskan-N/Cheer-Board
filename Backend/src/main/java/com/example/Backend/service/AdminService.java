package com.example.Backend.service;

import com.example.Backend.model.User;
import com.example.Backend.repo.UserRepo;
import com.example.Backend.utility.ErrorUtility;
import com.example.Backend.utility.UtilityString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
@Service
public class AdminService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    //Method to find user using email
    public User findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    //Method to find user using empId
    private User findUserByEmpId(int empId) {
        return userRepo.findByEmpId(empId);
    }

    //Saving new user Details encrypted password
    public String newUser(int empId,String email,String password,String fullname) {
        User user = new User();
            user.setEmpId(empId);
            user.setEmail(email.toLowerCase());
            user.setPassword(bCryptPasswordEncoder.encode(password));
            user.setFullname(fullname.toLowerCase());//convert it to camelCase by default
            userRepo.save(user);
            return "User Created";
    }

    //method for creating New user if do not exist already
    public ResponseEntity<Object> createUser(@RequestParam int empId, @RequestParam String email,
                                             @RequestParam String password, @RequestParam String fullName) {
        User localEmail = findUserByEmail(email);
        User localEmpId=findUserByEmpId(empId);
        return  email.matches(UtilityString.EMAIL_REGEX)?
                ((null==localEmail)&&(null==localEmpId))?
                        new ResponseEntity<>(newUser(empId, email, password, fullName), HttpStatus.CREATED):
                        new ResponseEntity<>("User already present",HttpStatus.CONFLICT):
                new ResponseEntity<>("You have not added the standard email format",HttpStatus.NOT_ACCEPTABLE);
    }

    //Returning list consisting of user details
    public List<User> getUserDetailbyEmail(String email) {
        User user = userRepo.findByEmail(email);
        List<User> userList = new ArrayList<User>();
        if (email.equals(user.getEmail())) {
            user.setEmpId( user.getEmpId());
            user.setEmail(user.getEmail());
            user.setFullname(user.getFullname());
            userList.add(user);
            return userList;
        }
        else {
            throw new UsernameNotFoundException(ErrorUtility.USER_NOT_FOUND);
        }
    }

    //method for viewing user detail if exists.
    public ResponseEntity<Object> UserDetail(String email) {
        return  email.matches(UtilityString.EMAIL_REGEX)?
                new ResponseEntity<>(getUserDetailbyEmail(email),HttpStatus.OK):
                new ResponseEntity<>("you have not added the standard email format",HttpStatus.NOT_ACCEPTABLE);
    }


}
