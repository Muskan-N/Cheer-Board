package com.example.Backend.serviceTest;

import com.example.Backend.Requests.CreateTeamRequest;
import com.example.Backend.model.Team;
import com.example.Backend.repo.TeamRepo;
import com.example.Backend.service.AdminHomeServiceTeam;
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
public class AdminHomeServiceTeamTest {
    @Mock
    TeamRepo teamRepo;

    @InjectMocks
    AdminHomeServiceTeam adminHomeServiceTeam;

    private Team team;
    @BeforeEach
    void setUp(){
        team = Team.builder()
                .teamId(201)
                .teamName("team1")
                .build();
    }
    @DisplayName("createTeamTest")
    @Test
    public void createTeamTest() {
        when(teamRepo.save(team)).thenReturn(team);
        CreateTeamRequest request = new CreateTeamRequest();
        request.setTeamId(team.getTeamId());
        request.setTeamName(team.getTeamName());
        // when -  action or the behaviour that we are going test
        ResponseEntity createTeam = adminHomeServiceTeam.createTeam(request);
        // then - verify the output
        assertEquals(new ResponseEntity<>("Team Created", HttpStatus.CREATED), createTeam);
        //assertThat(createTeam).isNotNull();
    }


    @DisplayName("AllTeamDetailTest")
    @Test
    public void allTeamTest(){
        given(teamRepo.findAll()).willReturn(List.of(team));

        // when -  action or the behaviour that we are going test
        List<Team> teamList = adminHomeServiceTeam.allTeamDetail();

        // then - verify the output
        assertThat(team).isNotNull();
        assertThat(teamList.size()).isEqualTo(1);
    }
    @DisplayName("updateTest:Positive")
    @Test
    public void updateTest1(){
        given(teamRepo.findByTeamId(201)).willReturn(team);
        CreateTeamRequest request = new CreateTeamRequest();
        // update the team entity
        request.setTeamName("software developer");
        // get the updated person entity
        ResponseEntity updatedPerson = adminHomeServiceTeam.updateTeam(201,request);
        // check that the person entity was updated correctly
        assertEquals(new ResponseEntity<>("Team Updated Successfully", HttpStatus.OK), updatedPerson);
    }
    @DisplayName("updateTest:Negative")
    @Test
    public void updateTest2(){
        given(teamRepo.findByTeamId(202)).willReturn(null);
        CreateTeamRequest request = new CreateTeamRequest();
        // update the team entity
        request.setTeamName("software developer");
        // get the updated person entity
        ResponseEntity updatedPerson = adminHomeServiceTeam.updateTeam(202,request);
        // check that the person entity was updated correctly
        assertEquals(new ResponseEntity<>("Team does not exist", HttpStatus.NOT_FOUND), updatedPerson);
    }

    @DisplayName("deleteTest:Positive")
    @Test
    public void deleteByEmpIdTest1() {
        // given - precondition or setup
        int teamId = 101;
        given(teamRepo.findByTeamId(teamId)).willReturn(team);
        // when -  action or the behaviour that we are going test
        ResponseEntity team1 = adminHomeServiceTeam.deleteByTeamId(teamId);
        // then
        assertEquals(new ResponseEntity<>("Team deleted successfully", HttpStatus.OK), team1);
    }

    @DisplayName("deleteTest:Negative")
    @Test
    public void deleteByEmpIdTest2() {
        // given - precondition or setup
        int teamId = 103;
        given(teamRepo.findByTeamId(teamId)).willReturn(null);
        // when -  action or the behaviour that we are going test
        ResponseEntity team1 = adminHomeServiceTeam.deleteByTeamId(teamId);
        // then
        assertEquals(new ResponseEntity<>("Team does not exist", HttpStatus.NOT_FOUND), team1);
    }
}
