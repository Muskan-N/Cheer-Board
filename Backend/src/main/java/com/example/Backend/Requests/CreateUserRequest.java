package com.example.Backend.Requests;

import com.example.Backend.model.Role;

public class CreateUserRequest {
    int empId;
    String email, password, fullName;
    Role roleName;

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

    public Role getRoleName() {
        return roleName;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setRoleName(Role roleName) {
        this.roleName = roleName;
    }

}
