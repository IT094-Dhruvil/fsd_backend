package com.details.PlayerData.service.impl;

import com.details.PlayerData.dtos.TeamDto;
import com.details.PlayerData.entity.Team;
import com.details.PlayerData.exception.ResourceNotFound;
import com.details.PlayerData.repository.TeamRepo;
import com.details.PlayerData.service.TeamService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepo teamRepo;

    @Autowired
    private ModelMapper model;

    @Override
    public TeamDto createTeam(TeamDto teamDto) {
        Team team = model.map(teamDto, Team.class);
        Team team1 = teamRepo.save(team);
        return model.map(team1,TeamDto.class);
    }

    @Override
    public TeamDto updateTeam(TeamDto teamDto, Integer teamId) {
        Team team = teamRepo.findById(teamId).orElseThrow(() -> new ResourceNotFound("Team", "Id", teamId));

        team.setTeamId(teamId);
        team.setTeamName(teamDto.getTeamName());

        Team team2 = teamRepo.save(team);
        return model.map(team2, TeamDto.class);
    }

    @Override
    public TeamDto getTeamById(Integer teamId) {
        Team team = teamRepo.findById(teamId).orElseThrow(() -> new ResourceNotFound("Team", "Id", teamId));
        return model.map(team, TeamDto.class);
    }

    @Override
    public List<TeamDto> getAllTeams() {
        List<Team> teams = teamRepo.findAll();
        List<TeamDto> teamDtos = teams.stream().map(team -> model.map(team, TeamDto.class)).collect(Collectors.toList());
        return teamDtos;
    }
}
