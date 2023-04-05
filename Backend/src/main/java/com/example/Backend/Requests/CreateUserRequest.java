package com.example.Backend.Requests;

public class CreateUserRequest {
    int empId;
    String email, password, fullName,role;

    public int getEmpId() {
        return empId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getRole() {
        return role;
    }
}
