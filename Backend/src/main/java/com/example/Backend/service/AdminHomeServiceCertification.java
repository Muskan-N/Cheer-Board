package com.example.Backend.service;

import com.example.Backend.Requests.CreateCertificationRequest;
import com.example.Backend.model.Certification;
import com.example.Backend.model.Certification;
import com.example.Backend.repo.CertificationRepo;
import com.example.Backend.repo.CertificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminHomeServiceCertification {
    @Autowired
    CertificationRepo certificationRepo;
    public String newCertification(int certificationId,String certificationType,String certificationName,String certificationCategory,String certificationRecommendedForPersona) {
        Certification certification = new Certification();
        certification.setCertificationId(certificationId);
        certification.setCertificationType(certificationType);
        certification.setCertificationName(certificationName);
        certification.setCertificationCategory(certificationCategory);
        certification.setCertificationRecommendedForPersona(certificationRecommendedForPersona);
        certificationRepo.save(certification);
        return "Certification Created";
    }
    public ResponseEntity<Object> createCertification(CreateCertificationRequest request) {
        int certificationId = request.getCertificationId();
        String certificationType = request.getCertificationType().toLowerCase();
        String certificationName = request.getCertificationName().toLowerCase();
        String certificationCategory = request.getCertificationCategory().toLowerCase();
        String certificationRecommendedForPersona=request.getCertificationRecommendedForPersona().toLowerCase();
        Certification localCertification = certificationRepo.findByCertificationName(certificationName);
        Certification localCertificationId = certificationRepo.findByCertificationId(certificationId);
        return (null == localCertification && null == localCertificationId) ?
                new ResponseEntity<>(newCertification(certificationId,certificationType,certificationName,certificationCategory,certificationRecommendedForPersona), HttpStatus.CREATED) :
                new ResponseEntity<>("Certification already present", HttpStatus.CONFLICT);
    }
}
