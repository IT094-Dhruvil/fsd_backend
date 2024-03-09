package com.details.PlayerData.service;

import com.details.PlayerData.dtos.TeamDto;
import java.util.List;
public interface TeamService {
    TeamDto createTeam(TeamDto teamDto);
    TeamDto updateTeam(TeamDto teamDto, Integer teamId);
    TeamDto getTeamById(Integer teamId);
    List<TeamDto> getAllTeams();
}
