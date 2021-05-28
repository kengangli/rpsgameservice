package com.rpsgame.rpsrestservice.controllers;

import com.rpsgame.rpsrestservice.entities.Game;
import com.rpsgame.rpsrestservice.entities.Player;
import com.rpsgame.rpsrestservice.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {
    private final GameService gameService;


    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/games")
    public List<Game> listGamesByPlayer(){
        List<Game> listGames = gameService.listGamesByPlayer();
        return listGames;

    }

    @GetMapping("/game")
    public Game  playGame(@RequestParam String playerChoice){
        Game game = gameService.playGame(playerChoice);
        return game;
    }

}
