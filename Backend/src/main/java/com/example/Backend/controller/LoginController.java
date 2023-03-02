package com.example.Backend.controller;

import com.example.Backend.ErrorHandler.ResourceNotFoundException;
import com.example.Backend.model.User;
import com.example.Backend.model.UserError;
import com.example.Backend.service.UserDetailsService;
import com.example.Backend.utility.UtilityString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
@RestController
@Validated
public class LoginController {
    @Autowired
    private UserDetailsService userService;
    ModelAndView mv = new ModelAndView();

    @GetMapping("/addUser")
    public List<User> getAllUsers() {
        //Returns hardcoded data, a real world application would return from the database
        List<User> userList = new ArrayList<User>();
        User user1 = new User();
        user1.setId(1);
        user1.setEmpId(101);
        user1.setEmail("Muskan@nagarro.com");
        user1.setPassword("muskan");
        user1.setFullname("Muskan");
        userList.add(user1);
        userService.saveUser(user1);
        return userList;
    }
    @GetMapping("/userLogin")
    public String loginUser(String email) {
        User local = userService.findUserByEmail(email);
       return  email.matches(UtilityString.EMAIL_REGEX)?
               ( null == local ? "User not found with this email : " + email : "login Successful"):
                "you have not added the standard email format";
        }
        //view details of user
    @GetMapping("/showUserDetail")
    public ResponseEntity<Object> UserDetail(String email) {
        return  email.matches(UtilityString.EMAIL_REGEX)?
                        new ResponseEntity<>(userService.getUserDetailbyEmail(email),HttpStatus.OK):
                        new ResponseEntity<>("you have not added the standard email format",HttpStatus.NOT_ACCEPTABLE);
    }
//give output in 201 status code
    @PostMapping("/createUser")
    @ResponseBody
        public ResponseEntity<Object>createUser(@RequestParam int id, @RequestParam int empId, @RequestParam String email, @RequestParam String password, @RequestParam String fullName) {

        User local = userService.findUserByEmail(email);
        return  email.matches(UtilityString.EMAIL_REGEX)?
                (null==local)?
                        new ResponseEntity<>(userService.newUser(id, empId, email, password, fullName),HttpStatus.CREATED):
                        new ResponseEntity<>("User already present",HttpStatus.CONFLICT):
                new ResponseEntity<>("you have not added the standard email format",HttpStatus.NOT_ACCEPTABLE);
    }

    }









