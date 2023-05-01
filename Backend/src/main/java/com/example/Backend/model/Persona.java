package com.example.Backend.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "persona")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Persona {

    @Id
    //Primary key as sequence ID should be unique
    private int personaId;
    //Persona of employee
    @Indexed(unique = true)
    private String personaName;

}