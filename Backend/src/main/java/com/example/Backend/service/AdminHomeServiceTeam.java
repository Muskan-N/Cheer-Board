package com.example.Backend.service;

import com.example.Backend.Requests.CreateTeamRequest;
import com.example.Backend.model.Team;
import com.example.Backend.repo.TeamRepo;
import com.example.Backend.utility.ErrorUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminHomeServiceTeam {
    @Autowired
    TeamRepo teamRepo;

    public String newTeam(int teamId, String teamName) {
        Team team = new Team();
        team.setTeamId(teamId);
        team.setTeamName(teamName);
        teamRepo.save(team);
        return "Team Created";
    }

    public ResponseEntity<Object> createTeam(CreateTeamRequest request) {
        int teamId = request.getTeamId();
        String teamName = request.getTeamName().toLowerCase();
        Team localTeam = teamRepo.findByTeamName(teamName);
        Team localTeamId = teamRepo.findByTeamId(teamId);
        return (null == localTeam && null == localTeamId) ?
                new ResponseEntity<>(newTeam(teamId, teamName), HttpStatus.CREATED) :
                new ResponseEntity<>("Team already present", HttpStatus.CONFLICT);
    }

    public List<Team> getTeamDetailbyTeamName(String teamName) {
        Team team = teamRepo.findByTeamName(teamName);
        List<Team> teamList = new ArrayList<Team>();
        if (teamName.equals(team.getTeamName())) {
            team.setTeamId(team.getTeamId());
            team.setTeamName(team.getTeamName());
            teamList.add(team);
            return teamList;
        } else {
            throw new UsernameNotFoundException(ErrorUtility.TEAM_NOT_FOUND);
        }
    }

    public ResponseEntity<Object> teamDetail(String teamName) {
        return new ResponseEntity<>(getTeamDetailbyTeamName(teamName), HttpStatus.OK);
    }

    public List<Team> allTeamDetail() {
        return teamRepo.findAll();
    }

    public ResponseEntity<Object> updateTeam(int teamId, CreateTeamRequest request) {
        String teamName = request.getTeamName();
        if (null != teamRepo.findByTeamId(teamId)) {
            Team team = teamRepo.findByTeamId(teamId);
            team.setTeamName(teamName.toLowerCase());//convert it to camelCase by default
            teamRepo.save(team);
            return new ResponseEntity<>("Team Updated Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Team does not exist", HttpStatus.NOT_FOUND);
    }

    //method for deleting team
    public ResponseEntity<Object> deleteByTeamId(int teamId) {
        Team team = teamRepo.findByTeamId(teamId);
        if (null != team) {
            teamRepo.delete(team);
            return new ResponseEntity<>("Team deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Team does not exist", HttpStatus.NOT_FOUND);
    }
}
