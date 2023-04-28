package com.example.Backend.service;

import com.example.Backend.Requests.CreateCertificationCategoryRequest;
import com.example.Backend.model.CertificationCategory;
import com.example.Backend.repo.CertificationCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminHomeServiceCertificationCategory {
    @Autowired
    CertificationCategoryRepo certificationCategoryRepo;

    public String newCategory(int categoryId, String categoryName, String categoryDef) {
        CertificationCategory category = new CertificationCategory();
        category.setCategoryId(categoryId);
        category.setCategoryName(categoryName);
        category.setCategoryDef(categoryDef);
        certificationCategoryRepo.save(category);
        return "New Category Created";
    }

    public ResponseEntity<Object> createCertificationCategory(CreateCertificationCategoryRequest request) {
        int categoryId = request.getCategoryId();
        String categoryName = request.getCategoryName().toLowerCase();
        String categoryDef = request.getCategoryDef().toLowerCase();
        CertificationCategory localCategory = certificationCategoryRepo.findByCategoryName(categoryName);
        CertificationCategory localCategoryId = certificationCategoryRepo.findByCategoryId(categoryId);
        return (null == localCategory && null == localCategoryId) ?
                new ResponseEntity<>(newCategory(categoryId, categoryName, categoryDef), HttpStatus.CREATED) :
                new ResponseEntity<>("Category already present", HttpStatus.CONFLICT);
    }

    public List<CertificationCategory> allCertificationCategoryDetail() {
        return certificationCategoryRepo.findAll();
    }


    public ResponseEntity<Object> updateCertificationCategory(int categoryId, CreateCertificationCategoryRequest request) {
        String categoryName = request.getCategoryName().toLowerCase();
        String categoryDef = request.getCategoryDef().toLowerCase();
        if (null != certificationCategoryRepo.findByCategoryId(categoryId)) {
            CertificationCategory category = certificationCategoryRepo.findByCategoryId(categoryId);
            category.setCategoryName(categoryName);
            category.setCategoryDef(categoryDef);
            certificationCategoryRepo.save(category);
            return new ResponseEntity<>(" Category Updated Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Category does not exist", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> deleteByCertificationCategoryId(int categoryId) {
        CertificationCategory category = certificationCategoryRepo.findByCategoryId(categoryId);
        if (null != category) {
            certificationCategoryRepo.delete(category);
            return new ResponseEntity<>("Category deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(" Category does not exist", HttpStatus.NOT_FOUND);
    }
}
