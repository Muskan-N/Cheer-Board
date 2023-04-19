package com.example.Backend.Requests;

import com.example.Backend.model.Role;
import com.example.Backend.model.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserRequest {
    int empId;
    String email, password, fullName;
    Role roleName;
    Team teamName;
}

