package com.details.PlayerData.service.impl;

import com.details.PlayerData.dtos.PlayerDto;
import com.details.PlayerData.entity.Player;
import com.details.PlayerData.entity.Team;
import com.details.PlayerData.exception.ResourceNotFound;
import com.details.PlayerData.repository.PlayerRepo;
import com.details.PlayerData.repository.TeamRepo;
import com.details.PlayerData.service.PlayService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayServiceImpl implements PlayService {

    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private ModelMapper mopdel;

    @Autowired
    private TeamRepo teamRepo;

    @Override
    public PlayerDto createPlayer(PlayerDto player, Integer teamId) {
        Team team = teamRepo.findById(teamId).orElseThrow(() -> new ResourceNotFound("Team", "Id", teamId));
        Player player1 = mopdel.map(player, Player.class);
        player1.setTeam(team);
        Player p1 = playerRepo.save(player1);
        return mopdel.map(p1, PlayerDto.class);
    }

    @Override
    public PlayerDto updatePlayer(PlayerDto player, Integer teamId, Integer pId) {
        Team team = teamRepo.findById(teamId).orElseThrow(() -> new ResourceNotFound("Team", "Id", teamId));
        Player p1 = playerRepo.findById(pId).orElseThrow(() -> new ResourceNotFound("Player", "Id", pId));

        p1.setPId(pId);
        p1.setPlayerName(player.getPlayerName());
        p1.setSr(player.getSr());
        p1.setBest(player.getBest());
        p1.setAvg(player.getAvg());
        p1.setRuns(player.getRuns());
        p1.setP50s(player.getP50s());
        p1.setP100s(player.getP100s());
        p1.setWickets(player.getWickets());
        p1.setTeam(team);
        Player p2 = playerRepo.save(p1);
        return mopdel.map(p2, PlayerDto.class);
    }

    @Override
    public PlayerDto getPlayerById(Integer pId) {
        Player player = playerRepo.findById(pId).orElseThrow(() -> new ResourceNotFound("Player", "Id", pId));
        return mopdel.map(player,PlayerDto.class);
    }

    @Override
    public List<PlayerDto> getAllPlayers() {
        List<Player> players = playerRepo.findAll();
        List<PlayerDto> playerDtos = players.stream().map(player -> mopdel.map(player,PlayerDto.class)).collect(Collectors.toList());
        return playerDtos;
    }

    @Override
    public List<PlayerDto> getAllPlayerByTeamId(Integer teamId) {
        Team team = teamRepo.findById(teamId).orElseThrow(() -> new ResourceNotFound("Team", "id", teamId));
        List<Player> players = playerRepo.findPlayerByTeam(team);
        List<PlayerDto> playerDtos = players.stream().map(player -> mopdel.map(player, PlayerDto.class)).collect(Collectors.toList());
        return playerDtos;
    }
}
