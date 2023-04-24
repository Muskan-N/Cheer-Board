package com.example.Backend.controller;


import com.example.Backend.Requests.CreateCertificationRequest;
import com.example.Backend.repo.CertificationRepo;
import com.example.Backend.service.AdminHomeServiceCertification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Validated
public class AdminCertificationController {

    @Autowired
    AdminHomeServiceCertification adminHomeServiceCertification;
    @PostMapping("/createCertification")
    @ResponseBody
    public ResponseEntity<Object> createPersona(@RequestBody CreateCertificationRequest request) {
        return adminHomeServiceCertification.createCertification(request);
    }
}
