package com.example.Backend.service;

import com.example.Backend.Requests.UserloginRequest;
import com.example.Backend.model.User;
import com.example.Backend.repo.UserRepo;
import com.example.Backend.utility.UtilityString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
@Service
public class UserService{

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Autowired
    private UserRepo userRepo;

    //Returning user using email else throwing exception
    public User findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }
    public ResponseEntity<Object> loginUser(UserloginRequest request){
        String email=request.getEmail().toLowerCase();
        System.out.println("email from test : "+email);
        User local = findUserByEmail(email);
        System.out.println("value from findeUserByEmail : "+local);
        return  email.matches(UtilityString.EMAIL_REGEX)?
                ( null == local ? new ResponseEntity<>("User not found with this email : "
                        + email , HttpStatus.UNAUTHORIZED): new ResponseEntity<>("Login Successful",HttpStatus.OK)):
                new ResponseEntity<>("You have not added the standard email format" ,HttpStatus.NOT_ACCEPTABLE);
    }


}
