package com.example.Backend.service;

import com.example.Backend.Requests.CreateRoleRequest;
import com.example.Backend.model.Role;
import com.example.Backend.repo.RoleRepo;
import com.example.Backend.utility.ErrorUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminHomeServiceRole {
    @Autowired
    RoleRepo roleRepo;

    public String newRole(int roleId, String roleName) {
        Role role1 = new Role();
        role1.setRoleId(roleId);
        role1.setRoleName(roleName);
        roleRepo.save(role1);
        return "Role Created";
    }

    public ResponseEntity<Object> createRole(CreateRoleRequest request) {
        int roleId = request.getRoleId();
        String roleName = request.getRoleName().toLowerCase();
        Role localRole = roleRepo.findByRoleName(roleName);
        Role localRoleId = roleRepo.findByRoleId(roleId);
        return (null == localRole && null == localRoleId) ?
                new ResponseEntity<>(newRole(roleId, roleName), HttpStatus.CREATED) :
                new ResponseEntity<>("Role already present", HttpStatus.CONFLICT);
    }

    public List<Role> getRoleDetailbyRoleName(String roleName) {
        Role role = roleRepo.findByRoleName(roleName);
        List<Role> roleList = new ArrayList<Role>();
        if (roleName.equals(role.getRoleName())) {
            role.setRoleId(role.getRoleId());
            role.setRoleName(role.getRoleName());
            roleList.add(role);
            return roleList;
        } else {
            throw new UsernameNotFoundException(ErrorUtility.ROLE_NOT_FOUND);
        }
    }


    public ResponseEntity<Object> roleDetail(String roleName) {
        return new ResponseEntity<>(getRoleDetailbyRoleName(roleName), HttpStatus.OK);
    }

    public List<Role> allRoleDetail() {
        return roleRepo.findAll();
    }

    public ResponseEntity<Object> updateRole(int roleId, CreateRoleRequest request) {
        String roleName = request.getRoleName();
        if (null != roleRepo.findByRoleId(roleId)) {
            Role role = roleRepo.findByRoleId(roleId);
            role.setRoleName(roleName.toLowerCase());//convert it to camelCase by default
            roleRepo.save(role);
            return new ResponseEntity<>("Role Updated Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Role does not exist", HttpStatus.NOT_FOUND);
    }

    //method for deleting role
    public ResponseEntity<Object> deleteByRoleId(int roleId) {
        Role role = roleRepo.findByRoleId(roleId);
        if (null != role) {
            roleRepo.delete(role);
            return new ResponseEntity<>("Role deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Role does not exist", HttpStatus.NOT_FOUND);
    }
}
