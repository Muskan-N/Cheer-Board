package com.example.Backend.controller;


import com.example.Backend.Requests.CreateCertificationRequest;
import com.example.Backend.Requests.CreateCertificationRequest;
import com.example.Backend.model.Certification;
import com.example.Backend.repo.CertificationRepo;
import com.example.Backend.service.AdminHomeServiceCertification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Validated
public class AdminCertificationController {

    @Autowired
    AdminHomeServiceCertification adminHomeServiceCertification;
    @PostMapping("/createCertification")
    @ResponseBody
    public ResponseEntity<Object> createCertification(@RequestBody CreateCertificationRequest request) {
        return adminHomeServiceCertification.createCertification(request);
    }
    @GetMapping("/showAllCertificationDetail")
    public List<Certification> allCertificationDetail() {
        return adminHomeServiceCertification.allCertificationDetail();
    }
    @PutMapping("/updateCertification")
    @ResponseBody
    public ResponseEntity<Object> updateCertification(@RequestParam int certificationId, @RequestBody CreateCertificationRequest request) {
        return adminHomeServiceCertification.updateCertification(certificationId, request);
    }

    @DeleteMapping("/deleteCertification")
    public ResponseEntity<Object> deleteCertification(@RequestParam int certificationId) {
        return adminHomeServiceCertification.deleteByCertificationId(certificationId);
    }
}
