package com.example.Backend.controller;

import com.example.Backend.Requests.CreatePersonaRequest;
import com.example.Backend.model.Persona;
import com.example.Backend.service.AdminHomeServicePersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Validated
public class AdminPersonaController {

    @Autowired
    AdminHomeServicePersona adminHomeServicePersona;

    @PostMapping("/createPersona")
    @ResponseBody
    public ResponseEntity<Object> createPersona(@RequestBody CreatePersonaRequest request) {
        return adminHomeServicePersona.createPersona(request);
    }

    @GetMapping("/showPersonaDetail")
    public ResponseEntity<Object> personaDetail(String personaName) {
        return adminHomeServicePersona.personaDetail(personaName);
    }

    @GetMapping("/showAllPersonaDetail")
    public List<Persona> allPersonaDetail() {
        return adminHomeServicePersona.allPersonaDetail();
    }

    @PutMapping("/updatePersona")
    @ResponseBody
    public ResponseEntity<Object> updatePersona(@RequestParam int personaId, @RequestBody CreatePersonaRequest request) {
        return adminHomeServicePersona.updatePersona(personaId, request);
    }

    @DeleteMapping("/deletePersona")
    public ResponseEntity<Object> deletePersona(@RequestParam int personaId) {
        return adminHomeServicePersona.deleteByPersonaId(personaId);
    }


}
