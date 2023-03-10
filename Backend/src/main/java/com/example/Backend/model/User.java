package com.example.Backend.model;

import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "user")
public class User {
    public User() {
    }
    public User(int id, int empId, String email, String password, String fullname, boolean enabled) {
        this.id = id;
        this.empId = empId;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.enabled = enabled;
    }

    //add Sequence id
    @Indexed(unique = true)
    private int id;
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
    private boolean enabled;
    @DBRef
    //role of user
    private Set<Role> roles;

    //getter for unique ID
    public int getId() {
        return id;
    }

    //setter for unique ID
    public void setId(int id) {
        this.id = id;
    }
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

    //method to check user is admin or not
    public boolean isEnabled() {
        return enabled;
    }

    //setter for enabled
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    //getter for roles
    public Set<Role> getRoles() {
        return roles;
    }

    //setter for roles
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }



}
