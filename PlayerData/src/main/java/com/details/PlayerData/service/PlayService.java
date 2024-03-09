package com.details.PlayerData.service;

import com.details.PlayerData.dtos.PlayerDto;
import com.details.PlayerData.entity.Player;
import com.details.PlayerData.entity.Team;

import java.util.List;

public interface PlayService {
    PlayerDto createPlayer(PlayerDto player, Integer teamId);
    PlayerDto updatePlayer(PlayerDto player, Integer teamId, Integer pId);
    PlayerDto getPlayerById(Integer pId);
    List<PlayerDto> getAllPlayers();
    List<PlayerDto> getAllPlayerByTeamId(Integer teamId);
}
