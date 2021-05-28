package com.rpsgame.rpsrestservice.daos;

import com.rpsgame.rpsrestservice.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerDao extends JpaRepository<Player, Long> {
    Player findByUsername(String username);
}
