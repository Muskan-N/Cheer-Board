package com.example.Backend.service;

import com.example.Backend.Requests.CreatePersonaRequest;
import com.example.Backend.model.Persona;
import com.example.Backend.repo.PersonaRepo;
import com.example.Backend.utility.ErrorUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminHomeServicePersona {
    @Autowired
    PersonaRepo personaRepo;

    public String newPersona(int personaId, String personaName) {
        Persona persona1 = new Persona();
        persona1.setPersonaId(personaId);
        persona1.setPersonaName(personaName);
        personaRepo.save(persona1);
        return "Persona Created";
    }

    public ResponseEntity<Object> createPersona(CreatePersonaRequest request) {
        int personaId = request.getPersonaId();
        String personaName = request.getPersonaName().toLowerCase();
        Persona localPersona = personaRepo.findByPersonaName(personaName);
        Persona localPersonaId = personaRepo.findByPersonaId(personaId);
        return (null == localPersona && null == localPersonaId) ?
                new ResponseEntity<>(newPersona(personaId, personaName), HttpStatus.CREATED) :
                new ResponseEntity<>("Persona already present", HttpStatus.CONFLICT);
    }

    public List<Persona> getPersonaDetailbyPersonaName(String personaName) {
        Persona persona = personaRepo.findByPersonaName(personaName);
        List<Persona> personaList = new ArrayList<Persona>();
        if (personaName.equals(persona.getPersonaName())) {
            persona.setPersonaId(persona.getPersonaId());
            persona.setPersonaName(persona.getPersonaName());
            personaList.add(persona);
            return personaList;
        } else {
            throw new UsernameNotFoundException(ErrorUtility.ROLE_NOT_FOUND);
        }
    }


    public ResponseEntity<Object> personaDetail(String personaName) {
        return new ResponseEntity<>(getPersonaDetailbyPersonaName(personaName), HttpStatus.OK);
    }

    public List<Persona> allPersonaDetail() {
        return personaRepo.findAll();
    }

    public ResponseEntity<Object> updatePersona(int personaId, CreatePersonaRequest request) {
        String personaName = request.getPersonaName();
        if (null != personaRepo.findByPersonaId(personaId)) {
            Persona persona = personaRepo.findByPersonaId(personaId);
            persona.setPersonaName(personaName.toLowerCase());//convert it to camelCase by default
            personaRepo.save(persona);
            return new ResponseEntity<>("Persona Updated Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Persona does not exist", HttpStatus.NOT_FOUND);
    }

    //method for deleting persona
    public ResponseEntity<Object> deleteByPersonaId(int personaId) {
        Persona persona = personaRepo.findByPersonaId(personaId);
        if (null != persona) {
            personaRepo.delete(persona);
            return new ResponseEntity<>("Persona deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Persona does not exist", HttpStatus.NOT_FOUND);
    }
}
