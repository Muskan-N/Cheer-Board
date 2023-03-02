package com.example.Backend.controller;

import com.example.Backend.model.User;
import com.example.Backend.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//details of user getMapping method(read)
//use constructor for testing
@RestController
public class LoginController {
    @Autowired
   private CustomUserDetailsService userService;

    @GetMapping("/showUserDetail")
    public List<User> UserDetail(String email)
    {
    return userService.getUserDetailbyEmail(email);
     }

    @GetMapping("/userLogin")
    public List<User> getAllUsers(){
        //Returns hardcoded data, a real world application would return from the database
        List<User> userList = new ArrayList<User>();
        User user1= new User();
        user1.setEmpId(101);
        user1.setEmail("Muskan@nagarro.com");
        user1.setFullname("Muskan");
        userList.add(user1);
        return userList;
    }


}
