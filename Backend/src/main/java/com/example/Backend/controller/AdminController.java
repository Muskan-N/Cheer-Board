package com.example.Backend.controller;

import com.example.Backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;
    @PostMapping("/createUser")
    @ResponseBody
    public ResponseEntity<Object> createUser(@RequestParam int empId, @RequestParam String email,
                                             @RequestParam String password, @RequestParam String fullName) {
        return adminService.createUser(empId,email,password,fullName);
    }
    @GetMapping("/showUserDetail")
    public ResponseEntity<Object> UserDetail(String email) {
       return adminService.UserDetail(email);
    }

}
