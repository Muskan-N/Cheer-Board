package com.example.Backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    public User(int empId, String email, String password, String fullname, String role) {
        this.empId = empId;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
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
    //roles
    private String role;
    //token for reset password
    private String token;
    //token creation time
    @Field("TIMESTAMP")
    private LocalDateTime tokenCreationDate;


}
