package com.details.PlayerData.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PlayerDto {

    private Integer pId;
    private String playerName;
    private Integer matches;
    private Integer runs;
    private Integer best;
    private Integer p50s;
    private Integer p100s;
    private Integer avg;
    private Integer wickets;
    private Integer sr;

}
