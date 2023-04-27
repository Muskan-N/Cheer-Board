package com.example.Backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
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
    //roles
    //private String role;

    //aggregation from many to one.
    @DBRef
    @Field("personaId")
    private Persona persona;
    @DBRef
    private Team team;
    //token for reset password
   @DBRef
    private Certification certification;


}
