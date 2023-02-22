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
@CrossOrigin
public class LoginController {
    @Autowired
   private CustomUserDetailsService userService;

   //global object of modelAndView
//    ModelAndView modelAndView = new ModelAndView();
//    //login method for login of user
//    public ModelAndView login() {
//        modelAndView.setViewName("login");
//        return modelAndView;
//    }
//    //dashboard method for view of admin
//    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
//    public ModelAndView dashboard() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.findUserByEmail(auth.getName());
//        modelAndView.addObject("currentUser", user);
//        modelAndView.addObject("fullName", "Welcome " + user.getFullname());
//        modelAndView.setViewName("dashboard");
//        return modelAndView;
//    }
//
//    //home page for user other than admin
//    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
//    public ModelAndView home() {
//        modelAndView.setViewName("home");
//        return modelAndView;
//    }
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
