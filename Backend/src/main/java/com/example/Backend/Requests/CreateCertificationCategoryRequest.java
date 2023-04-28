package com.example.Backend.Requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCertificationCategoryRequest {
    int categoryId;
    String categoryName;
    String categoryDef;
}
