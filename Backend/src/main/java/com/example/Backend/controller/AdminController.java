package com.example.Backend.controller;

import com.example.Backend.Requests.CreateUserRequest;
import com.example.Backend.model.User;
import com.example.Backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Validated
public class AdminController {
    @Autowired
    AdminService adminService;

    //API for Admin to create User
    @PostMapping("/createUser")
    @ResponseBody
    public ResponseEntity<Object> createUser(@RequestBody CreateUserRequest request) {
        System.out.println(request);
        return adminService.createUser(request);
    }

    //API for Admin to view details of User
    @GetMapping("/showUserDetail")
    public ResponseEntity<Object> UserDetail(String email) {
       return adminService.UserDetail(email);
    }
    //API for Admin to view all User
    @GetMapping("/showAllUserDetail")
    public List<User> AllUserDetail() {
        return adminService.AllUserDetail();
    }
    //API for Admin to update details of user
    @PutMapping("/updateUser")
    @ResponseBody
    public ResponseEntity<Object> updateUser(@RequestParam int empId,@RequestBody CreateUserRequest request){
        return adminService.updateUser(empId,request);
    }
    //API for Admin to delete detail of user
    @DeleteMapping("/deleteUser")
    public ResponseEntity<Object> deleteUser(@RequestParam int empId)
    {
        return adminService.deleteByEmpId(empId);
    }


}
