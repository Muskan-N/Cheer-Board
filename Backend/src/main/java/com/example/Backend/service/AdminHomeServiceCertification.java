package com.example.Backend.service;

import com.example.Backend.Requests.CreateCertificationRequest;
import com.example.Backend.model.Certification;
import com.example.Backend.model.CertificationCategory;
import com.example.Backend.model.Persona;
import com.example.Backend.repo.CertificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminHomeServiceCertification {
    @Autowired
    CertificationRepo certificationRepo;

    public String newCertification(int certificationId, String certificationType, String certificationName, CertificationCategory certificationCategory, List<Persona> certificationRecommendedForPersona) {
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
        CertificationCategory certificationCategory = new CertificationCategory();
        certificationCategory.setCategoryId(request.getCertificationCategoryId());
        //persona se reference

        List<Persona> certificationRecommendedForPersonaIds = new ArrayList<>();
        for (int i : request.getCertificationRecommendedForPersonaIds()) {
            Persona persona = new Persona();
            persona.setPersonaId(i);
            certificationRecommendedForPersonaIds.add(persona);
        }
        Certification localCertification = certificationRepo.findByCertificationName(certificationName);
        Certification localCertificationId = certificationRepo.findByCertificationId(certificationId);
        return (null == localCertification && null == localCertificationId) ?
                new ResponseEntity<>(newCertification(certificationId, certificationType, certificationName, certificationCategory, certificationRecommendedForPersonaIds), HttpStatus.CREATED) :
                new ResponseEntity<>("Certification already present", HttpStatus.CONFLICT);
    }

    public List<Certification> allCertificationDetail() {
        return certificationRepo.findAll();
    }


    public ResponseEntity<Object> updateCertification(int certificationId, CreateCertificationRequest request) {
        String certificationName = request.getCertificationName().toLowerCase();
        CertificationCategory certificationCategory = new CertificationCategory();
        certificationCategory.setCategoryId(request.getCertificationCategoryId());
        List<Persona> certificationRecommendedForPersonaIds = new ArrayList<>();
        for (int i : request.getCertificationRecommendedForPersonaIds()) {
            Persona persona = new Persona();
            persona.setPersonaId(i);
            certificationRecommendedForPersonaIds.add(persona);
        }
        if (null != certificationRepo.findByCertificationId(certificationId)) {
            Certification certification = certificationRepo.findByCertificationId(certificationId);
            certification.setCertificationName(certificationName);
            certification.setCertificationCategory(certificationCategory);
            certification.setCertificationRecommendedForPersona(certificationRecommendedForPersonaIds);
            certificationRepo.save(certification);
            return new ResponseEntity<>("Certification Updated Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Certification does not exist", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> deleteByCertificationId(int certificationId) {
        Certification certification = certificationRepo.findByCertificationId(certificationId);
        if (null != certification) {
            certificationRepo.delete(certification);
            return new ResponseEntity<>("Certification deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Certification does not exist", HttpStatus.NOT_FOUND);
    }
}
//bring preparation live with certificates.
//when admin has edited certification then what about cutoff and preparation links