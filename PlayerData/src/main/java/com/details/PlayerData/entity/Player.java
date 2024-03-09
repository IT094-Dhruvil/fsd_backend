package com.details.PlayerData.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    private Team team;
}
