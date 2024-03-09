package com.details.PlayerData.repository;

import com.details.PlayerData.entity.Player;
import com.details.PlayerData.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepo extends JpaRepository<Player,Integer> {
    List<Player> findPlayerByTeam(Team team);
}
