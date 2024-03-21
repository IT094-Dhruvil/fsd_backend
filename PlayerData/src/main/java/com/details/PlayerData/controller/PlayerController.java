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
    private ResponseEntity<?> createPlayer(@RequestBody PlayerDto player, @PathVariable("teamId") Integer teamId) {
        return new ResponseEntity<>(playerService.createPlayer(player, teamId), HttpStatus.CREATED);
    }

    @PutMapping("/team/player/{pId}")
    private ResponseEntity<?> updatePlayer(@RequestBody PlayerDto player ,@PathVariable("pId") Integer pId) {
        PlayerDto updatedPlayer = playerService.updatePlayer(player,  pId);
        if (updatedPlayer != null) {
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Player not found", HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/team/player/{pId}")
    private ResponseEntity<?> getPlayerById(@PathVariable("pId") Integer pId) {
        return new ResponseEntity<>(playerService.getPlayerById(pId), HttpStatus.OK);
    }

    @GetMapping("/player/")
    private ResponseEntity<?> getAllPlayers() {
        return new ResponseEntity<>(playerService.getAllPlayers(), HttpStatus.OK);
    }

    @GetMapping("/team/{teamId}/player/")
    private ResponseEntity<?> getPlayerByTeamId(@PathVariable("teamId") Integer teamId) {
        return new ResponseEntity<>(playerService.getAllPlayerByTeamId(teamId), HttpStatus.OK);
    }

    @DeleteMapping("/team/player/{pId}")
    private ResponseEntity<?> deletePlayerById(@PathVariable("pId") Integer pId) {
        try {
            playerService.deletePlayerById(pId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error " + e.getMessage());
        }
    }

}
