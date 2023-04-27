package com.example.Backend.service;

import com.example.Backend.Requests.CreateUserRequest;
import com.example.Backend.model.Certification;
import com.example.Backend.model.Persona;
import com.example.Backend.model.Team;
import com.example.Backend.model.User;
import com.example.Backend.repo.UserRepo;
import com.example.Backend.Requests.CreateUserRequest;
import com.example.Backend.utility.ErrorUtility;
import com.example.Backend.utility.UtilityString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceUser {
    @Autowired
    UserRepo userRepo;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    //Method to find user using email
    public User findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    //Method to find user using empId
    public User findUserByEmpId(int empId) {
        return userRepo.findByEmpId(empId);
    }

    //Saving new user Details encrypted password
    public String newUser(int empId, String email, String password, String fullname, Persona persona, Team team, Certification certification) {
        User user = new User();
            user.setEmpId(empId);
            user.setEmail(email.toLowerCase());
            user.setPassword(bCryptPasswordEncoder.encode(password));
            user.setFullname(fullname.toLowerCase());//convert it to camelCase by default
            user.setPersona(persona);
            user.setTeam(team);
            user.setCertification(certification);
            userRepo.save(user);
            return "User Created";
    }

    //method for creating New user if do not exist already
    public ResponseEntity<Object> createUser(CreateUserRequest request) {
        int empId=request.getEmpId();
        String email=request.getEmail().toLowerCase();
        String password =request.getPassword();
        String fullName=request.getFullName();
        Persona persona =new Persona();
        //need to figure it out
        persona.setPersonaId(request.getPersonaId());
        Team team =new Team();
        team.setTeamId(request.getTeamId());
        Certification certification=new Certification();
        certification.setCertificationId(request.getCertificationId());
        User localEmail = findUserByEmail(email);
        User localEmpId=findUserByEmpId(empId);
        return  email.matches(UtilityString.EMAIL_REGEX)?
                ((null==localEmail)&&(null==localEmpId))?
                        new ResponseEntity<>(newUser(empId, email, password, fullName, persona,team,certification), HttpStatus.CREATED):
                        new ResponseEntity<>("User already present",HttpStatus.CONFLICT):
                new ResponseEntity<>("You have not added the standard email format",HttpStatus.NOT_ACCEPTABLE);
    }

    //Returning list consisting of user details
    public List<User> getUserDetailbyEmail(String email) {
        User user = userRepo.findByEmail(email);
        List<User> userList = new ArrayList<User>();
        if (email.equals(user.getEmail())) {
            user.setEmpId( user.getEmpId());
            user.setEmail(user.getEmail());
            user.setFullname(user.getFullname());
            userList.add(user);
            return userList;
        }
        else {
            throw new UsernameNotFoundException(ErrorUtility.USER_NOT_FOUND);
        }
    }

    //method for viewing user detail if exists.
    public ResponseEntity<Object> UserDetail(String email) {
        return  email.matches(UtilityString.EMAIL_REGEX)?
                new ResponseEntity<>(getUserDetailbyEmail(email),HttpStatus.OK):
                new ResponseEntity<>("you have not added the standard email format",HttpStatus.NOT_ACCEPTABLE);
    }
    //method for viewing all details
    public List<User> AllUserDetail() {
        return userRepo.findAll();
    }

//method for updating User
    public ResponseEntity<Object> updateUser(int empId,CreateUserRequest request) {
        String password =request.getPassword();
        String fullName=request.getFullName();
        Persona persona =new Persona();
        //need to figure it out
        persona.setPersonaId(request.getPersonaId());
        Team team =new Team();
        team.setTeamId(request.getTeamId());
        Certification certification=new Certification();
        certification.setCertificationId(request.getCertificationId());
        if (null!=userRepo.findByEmpId(empId)){
            User user = userRepo.findByEmpId(empId);
            user.setPassword(bCryptPasswordEncoder.encode(password));
            user.setFullname(fullName.toLowerCase());//convert it to camelCase by default
            user.setPersona(persona);
            user.setTeam(team);
            user.setCertification(certification);
            userRepo.save(user);
            return new ResponseEntity<>("User Updated Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("User does not exist",HttpStatus.NOT_FOUND);
    }

 //method for deleting user
    public ResponseEntity<Object> deleteByEmpId(int empId) {
        User user=userRepo.findByEmpId(empId);
        if(null!=user){
            userRepo.delete(user);
            return new ResponseEntity<>("User deleted successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("User does not exist",HttpStatus.NOT_FOUND);
    }
}
