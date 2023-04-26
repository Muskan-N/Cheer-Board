package com.example.Backend.Requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCertificationRequest {
    int certificationId;
    //certification type internal/external
    String certificationType;

     String certificationName;
     String certificationCategory;
     List<String> certificationRecommendedForPersona;
}
