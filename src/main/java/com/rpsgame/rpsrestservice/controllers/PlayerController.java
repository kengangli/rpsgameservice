package com.rpsgame.rpsrestservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rpsgame.rpsrestservice.services.*;
import com.rpsgame.rpsrestservice.entities.*;

import java.util.List;

@RestController
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public List<Player> listPlayers(){
        List<Player> listPlayers = playerService.listPlayers();
        return listPlayers;


    }

    @GetMapping("/")
    public String initializePlayers(){
        playerService.initializePlayers();
        String greeting = "Welcome to Rock-Paper-Scissor Game";
        return greeting;


    }
}
