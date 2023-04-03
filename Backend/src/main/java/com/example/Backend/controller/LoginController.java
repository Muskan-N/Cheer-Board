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

    //Returns String message that whether user was able to login or not
//    @PostMapping("/userLogin")
//    @ResponseBody
//    public ResponseEntity<Object> loginUser(@RequestBody UserloginRequest request) {
//        String email=request.getEmail().toLowerCase();
//         User local = userService.findUserByEmail(email);
//          return  email.matches(UtilityString.EMAIL_REGEX)?
//                   ( null == local ? new ResponseEntity<>("User not found with this email : " + email ,HttpStatus.UNAUTHORIZED): new ResponseEntity<>("Login Successful",HttpStatus.OK)):
//                  new ResponseEntity<>("you have not added the standard email format" ,HttpStatus.NOT_ACCEPTABLE);
//        }

    @PostMapping("/userLogin")
    @ResponseBody
    public ResponseEntity<Object> loginUser(@RequestBody UserloginRequest request) {
        return userService.loginUser(request);
    }


//making email a parameter in service

        //Returns User details  of user
//    @GetMapping("/showUserDetail")
//    public ResponseEntity<Object> UserDetail(String email) {
//        return  email.matches(UtilityString.EMAIL_REGEX)?
//                        new ResponseEntity<>(userService.getUserDetailbyEmail(email),HttpStatus.OK):
//                        new ResponseEntity<>("you have not added the standard email format",HttpStatus.NOT_ACCEPTABLE);
//    }

    //Creates the user and gives 201 status code
//    @PostMapping("/createUser")
//    @ResponseBody
//        public ResponseEntity<Object>createUser(@RequestParam int empId, @RequestParam String email, @RequestParam String password, @RequestParam String fullName) {
//
//        User localEmail = userService.findUserByEmail(email);
//        User localEmpId=userService.findUserByEmpId(empId);
//        return  email.matches(UtilityString.EMAIL_REGEX)?
//                ((null==localEmail)&&(null==localEmpId))?
//                        new ResponseEntity<>(userService.newUser(empId, email, password, fullName),HttpStatus.CREATED):
//                        new ResponseEntity<>("User already present",HttpStatus.CONFLICT):
//                new ResponseEntity<>("you have not added the standard email format",HttpStatus.NOT_ACCEPTABLE);
//    }

    }









