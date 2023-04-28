package com.example.Backend.controller;

import com.example.Backend.Requests.CreateCertificationCategoryRequest;
import com.example.Backend.model.CertificationCategory;
import com.example.Backend.service.AdminHomeServiceCertificationCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Validated
public class AdminCertificationCategoryController {
    @Autowired
    AdminHomeServiceCertificationCategory adminHomeServiceCertificationCategory;

    @PostMapping("/createCertificationCategory")
    @ResponseBody
    public ResponseEntity<Object> createCertificationCategory(@RequestBody CreateCertificationCategoryRequest request) {
        return adminHomeServiceCertificationCategory.createCertificationCategory(request);
    }

    @GetMapping("/showAllCertificationCategoryDetail")
    public List<CertificationCategory> allCertificationCategoryDetail() {
        return adminHomeServiceCertificationCategory.allCertificationCategoryDetail();
    }

    @PutMapping("/updateCertificationCategory")
    @ResponseBody
    public ResponseEntity<Object> updateCertificationCategory(@RequestParam int certificationCategoryId, @RequestBody CreateCertificationCategoryRequest request) {
        return adminHomeServiceCertificationCategory.updateCertificationCategory(certificationCategoryId, request);
    }

    @DeleteMapping("/deleteCertificationCategory")
    public ResponseEntity<Object> deleteCertificationCategory(@RequestParam int certificationCategoryId) {
        return adminHomeServiceCertificationCategory.deleteByCertificationCategoryId(certificationCategoryId);
    }
}
