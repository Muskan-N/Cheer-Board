package com.example.Backend.controller;

import com.example.Backend.Requests.CreateRoleRequest;
import com.example.Backend.model.Role;
import com.example.Backend.service.AdminHomeServiceRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Validated
public class AdminRoleController {

    @Autowired
    AdminHomeServiceRole adminHomeServiceRole;

    @PostMapping("/createRole")
    @ResponseBody
    public ResponseEntity<Object> createUser(@RequestBody CreateRoleRequest request) {
        return adminHomeServiceRole.createRole(request);
    }

    @GetMapping("/showRoleDetail")
    public ResponseEntity<Object> roleDetail(String roleName) {
        return adminHomeServiceRole.roleDetail(roleName);
    }

    @GetMapping("/showAllRoleDetail")
    public List<Role> allRoleDetail() {
        return adminHomeServiceRole.allRoleDetail();
    }

    @PutMapping("/updateRole")
    @ResponseBody
    public ResponseEntity<Object> updateRole(@RequestParam int roleId, @RequestBody CreateRoleRequest request) {
        return adminHomeServiceRole.updateRole(roleId, request);
    }

    @DeleteMapping("/deleteRole")
    public ResponseEntity<Object> deleteUser(@RequestParam int roleId) {
        return adminHomeServiceRole.deleteByRoleId(roleId);
    }


}
