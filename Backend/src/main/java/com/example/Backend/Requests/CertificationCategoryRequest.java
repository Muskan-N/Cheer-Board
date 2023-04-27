package com.example.Backend.Requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CertificationCategoryRequest {
    int categoryId;
    String categoryName;
    String categoryDef;
}
