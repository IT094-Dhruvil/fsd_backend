package com.details.PlayerData.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teamId;

    private String teamName;

    @OneToMany(mappedBy = "team" ,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Player> players;
}
