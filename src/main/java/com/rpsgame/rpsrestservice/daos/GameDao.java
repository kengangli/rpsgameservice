package com.rpsgame.rpsrestservice.daos;

import com.rpsgame.rpsrestservice.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameDao extends JpaRepository<Game, Long> {
}

