package com.example.Backend.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "team")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Team {
    @Id
    //Primary key as sequence ID should be unique
    private int id;
    //Role of employee
    private String teamName;
}
