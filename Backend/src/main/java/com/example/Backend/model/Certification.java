package com.example.Backend.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

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

    private String certificationCategory;
    private String certificationRecommendedForPersona;


}
