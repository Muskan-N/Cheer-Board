package com.example.Backend.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "certificationCategory")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CertificationCategory {

    @Id
    //Primary key as sequence ID should be unique
    private int categoryId;
    //certification type internal/external
    @Indexed(unique = true)
    private String categoryName;

    private String categoryDef;

}
