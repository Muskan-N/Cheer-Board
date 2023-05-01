package com.example.Backend.controller;

import com.example.Backend.Requests.CreateTeamRequest;
import com.example.Backend.model.Team;
import com.example.Backend.service.AdminHomeServiceTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Validated
public class AdminTeamController {
    @Autowired
    AdminHomeServiceTeam adminHomeServiceTeam;

    @PostMapping("/createTeam")
    @ResponseBody
    public ResponseEntity<Object> createTeam(@RequestBody CreateTeamRequest request) {
        return adminHomeServiceTeam.createTeam(request);
    }

    @GetMapping("/showTeamDetail")
    public ResponseEntity<Object> teamDetail(String teamName) {
        return adminHomeServiceTeam.teamDetail(teamName);
    }

    @GetMapping("/showAllTeamDetail")
    public List<Team> allTeamDetail() {
        return adminHomeServiceTeam.allTeamDetail();
    }

    @PutMapping("/updateTeam")
    @ResponseBody
    public ResponseEntity<Object> updateTeam(@RequestParam int teamId, @RequestBody CreateTeamRequest request) {
        return adminHomeServiceTeam.updateTeam(teamId, request);
    }

    @DeleteMapping("/deleteTeam")
    public ResponseEntity<Object> deleteTeam(@RequestParam int teamId) {
        return adminHomeServiceTeam.deleteByTeamId(teamId);
    }


}
