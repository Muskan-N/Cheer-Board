package com.example.Backend.model;

import java.time.LocalDateTime;
import java.util.Set;

import org.jnosql.artemis.Column;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document(collection = "user")
public class User {
    public User() {
    }
    public User(int empId, String email, String password, String fullname) {
        this.empId = empId;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
    }
    //add Sequence id

    @Id
    //Primary key as employee ID should be unique
    private int empId;
    @Indexed(unique = true)
    //employee email
    private String email;
    //employee password
    private String password;
    //employee fullname
    private String fullname;
    //token for reset password
    private String token;
    //token creation time
    @Field("TIMESTAMP")
    private LocalDateTime tokenCreationDate;

    //getter for empId
    public int getEmpId() {
        return  empId;
    }
    //setter for empId
    public void setEmpId(int empId) {
        this.empId = empId;
    }

    //getter for email
    public String getEmail() {
        return email;
    }

    //setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    //getter for password
    public String getPassword() {
        return password;
    }

    //setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    //getter for fullname
    public String getFullname() {
        return fullname;
    }

    //setter for fullname
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    //getter for token
    public String getToken() {
        return token;
    }
    //setter for token
    public void setToken(String token) {
        this.token = token;
    }
    //getter for token creation time
    public LocalDateTime getTokenCreationDate() {
        return tokenCreationDate;
    }
    //setter for token creation time
    public void setTokenCreationDate(LocalDateTime tokenCreationDate) {
        this.tokenCreationDate = tokenCreationDate;
    }

















}
