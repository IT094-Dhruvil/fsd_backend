package com.details.PlayerData.repository;

import com.details.PlayerData.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team, Integer> {

}
