package com.details.PlayerData.controller;

import com.details.PlayerData.dtos.PlayerDto;
import com.details.PlayerData.entity.Player;
import com.details.PlayerData.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin
public class PlayerController {

    @Autowired
    private PlayService playerService;

    @PostMapping("/team/{teamId}/")
    private ResponseEntity<?> createPlayer(@RequestBody PlayerDto player, @PathVariable("teamId") Integer teamId){
        return new ResponseEntity<>(playerService.createPlayer(player, teamId), HttpStatus.CREATED);
    }

    @PutMapping("/team/{teamId}/player/{pId}")
    private ResponseEntity<?> updatePlayer(@RequestBody PlayerDto player, @PathVariable("teamId") Integer teamId , @PathVariable("pId") Integer pId){
        return new ResponseEntity<>(playerService.updatePlayer(player, teamId, pId), HttpStatus.OK);
    }

    @GetMapping("/team/player/{pId}")
    private ResponseEntity<?> getPlayerById(@PathVariable("pId") Integer pId){
        return new ResponseEntity<>(playerService.getPlayerById( pId), HttpStatus.OK);
    }

    @GetMapping("/player/")
    private ResponseEntity<?> getAllPlayers(){
        return new ResponseEntity<>(playerService.getAllPlayers(), HttpStatus.OK);
    }

    @GetMapping("/team/{teamId}/player/")
    private ResponseEntity<?> getPlayerByTeamId(@PathVariable("teamId") Integer teamId){
        return new ResponseEntity<>(playerService.getAllPlayerByTeamId(teamId), HttpStatus.OK);
    }

}
