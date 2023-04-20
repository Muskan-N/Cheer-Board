package com.example.Backend.Requests;

import com.example.Backend.model.Persona;
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
    Persona personaName;
    Team teamName;
}

