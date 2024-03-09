package com.details.PlayerData.controller;

import com.details.PlayerData.dtos.TeamDto;
import com.details.PlayerData.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/team/")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/")
    private ResponseEntity<?> createTeam(@RequestBody TeamDto teamDto){
        return new ResponseEntity<>(teamService.createTeam(teamDto), HttpStatus.CREATED);
    }

    @PutMapping("/{teamId}")
    private ResponseEntity<?> updateTeam(@RequestBody TeamDto teamDto, @PathVariable("teamId") Integer teamId){
        return new ResponseEntity<>(teamService.updateTeam(teamDto, teamId), HttpStatus.OK);
    }

    @GetMapping("/{teamId}")
    private ResponseEntity<?> getTeamById(@PathVariable("teamId") Integer teamId){
        return new ResponseEntity<>(teamService.getTeamById(teamId), HttpStatus.OK);
    }

    @GetMapping("/")
    private ResponseEntity<?> getAllTeams(){
        return new ResponseEntity<>(teamService.getAllTeams(), HttpStatus.OK);
    }

}
