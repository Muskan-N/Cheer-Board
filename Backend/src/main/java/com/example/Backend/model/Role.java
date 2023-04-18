package com.example.Backend.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Role {

    @Id
    //Primary key as sequence ID should be unique
    private int roleId;
    //Role of employee
    @Indexed(unique = true)
    private String roleName;



}