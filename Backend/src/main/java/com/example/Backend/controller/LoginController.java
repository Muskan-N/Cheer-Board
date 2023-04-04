package com.example.Backend.controller;


import com.example.Backend.Requests.UserloginRequest;
import com.example.Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@RestController
@Validated
@CrossOrigin
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/userLogin")
    @ResponseBody
    public ResponseEntity<Object> loginUser(@RequestBody UserloginRequest request) {
        return userService.loginUser(request);
    }


//making email a parameter in service

        //Returns User details  of user


    //Creates the user and gives 201 status code


    }









