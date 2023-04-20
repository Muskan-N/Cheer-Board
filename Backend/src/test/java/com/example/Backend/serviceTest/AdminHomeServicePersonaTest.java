package com.example.Backend.serviceTest;

import com.example.Backend.Requests.CreatePersonaRequest;
import com.example.Backend.model.Persona;
import com.example.Backend.repo.PersonaRepo;
import com.example.Backend.service.AdminHomeServicePersona;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AdminHomeServicePersonaTest {

    @Mock
    PersonaRepo personaRepo;

    @InjectMocks
    AdminHomeServicePersona adminHomeServicePersona;

    private Persona persona;
    @BeforeEach
    void setUp(){
        persona = Persona.builder()
                .personaId(101)
                .personaName("manager")
                .build();
    }
    @DisplayName("createPersonaTest")
    @Test
    public void createPersonaTest() {
        when(personaRepo.save(persona)).thenReturn(persona);
        CreatePersonaRequest request = new CreatePersonaRequest();
        request.setPersonaId(persona.getPersonaId());
        request.setPersonaName(persona.getPersonaName());
        // when -  action or the behaviour that we are going test
        ResponseEntity createPersona = adminHomeServicePersona.createPersona(request);
        // then - verify the output
        assertEquals(new ResponseEntity<>("Persona Created", HttpStatus.CREATED), createPersona);
        //assertThat(createPersona).isNotNull();
    }
    @DisplayName("AllPersonaDetailTest")
    @Test
    public void allPersonaTest(){
        given(personaRepo.findAll()).willReturn(List.of(persona));

        // when -  action or the behaviour that we are going test
        List<Persona> personaList = adminHomeServicePersona.allPersonaDetail();

        // then - verify the output
        assertThat(persona).isNotNull();
        assertThat(personaList.size()).isEqualTo(1);
    }
    @DisplayName("updateTest:Positive")
    @Test
    public void updateTest1(){
        given(personaRepo.findByPersonaId(101)).willReturn(persona);
        CreatePersonaRequest request = new CreatePersonaRequest();
        // update the persona entity
        request.setPersonaName("software developer");
        // get the updated person entity
        ResponseEntity updatedPerson = adminHomeServicePersona.updatePersona(101,request);
        // check that the person entity was updated correctly
        assertEquals(new ResponseEntity<>("Persona Updated Successfully", HttpStatus.OK), updatedPerson);
    }
    @DisplayName("updateTest:Negative")
    @Test
    public void updateTest2(){
        given(personaRepo.findByPersonaId(102)).willReturn(null);
        CreatePersonaRequest request = new CreatePersonaRequest();
        // update the persona entity
        request.setPersonaName("software developer");
        // get the updated person entity
        ResponseEntity updatedPerson = adminHomeServicePersona.updatePersona(102,request);
        // check that the person entity was updated correctly
        assertEquals(new ResponseEntity<>("Persona does not exist", HttpStatus.NOT_FOUND), updatedPerson);
    }

    @DisplayName("deleteTest:Positive")
    @Test
    public void deleteByPersonaIdTest1() {
        // given - precondition or setup
        int personaId = 101;
        given(personaRepo.findByPersonaId(personaId)).willReturn(persona);
        // when -  action or the behaviour that we are going test
        ResponseEntity persona1 = adminHomeServicePersona.deleteByPersonaId(personaId);
        // then
        assertEquals(new ResponseEntity<>("Persona deleted successfully", HttpStatus.OK), persona1);
    }

    @DisplayName("deleteTest:Negative")
    @Test
    public void deleteByPersonaIdTest2() {
        // given - precondition or setup
        int personaId = 103;
        given(personaRepo.findByPersonaId(personaId)).willReturn(null);
        // when -  action or the behaviour that we are going test
        ResponseEntity persona1 = adminHomeServicePersona.deleteByPersonaId(personaId);
        // then
        assertEquals(new ResponseEntity<>("Persona does not exist", HttpStatus.NOT_FOUND), persona1);
    }
}
