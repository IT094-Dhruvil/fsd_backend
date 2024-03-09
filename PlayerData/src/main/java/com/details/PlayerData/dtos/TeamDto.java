package com.details.PlayerData.dtos;

import com.details.PlayerData.entity.Player;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class TeamDto {
    private Integer teamId;
    private String teamName;
    private List<PlayerDto> palyers;
}
