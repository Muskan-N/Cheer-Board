package com.example.Backend.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "certification")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Certification {
    @Id
    //Primary key as sequence ID should be unique
    private int certificationId;
    //certification type internal/external
    private String certificationType;
    @Indexed(unique = true)
    private String certificationName;

    @DBRef
    private CertificationCategory certificationCategory;
    @DBRef
    private List<Persona> certificationRecommendedForPersona;
//1.way to handle list input--> customize backend as per array sent in input((typecast)
// 2. convert string(json) to array.

}
