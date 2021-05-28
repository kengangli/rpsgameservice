package com.rpsgame.rpsrestservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rpsgame.rpsrestservice.daos.*;
import com.rpsgame.rpsrestservice.entities.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    private final GameDao gameDao;

    private List<Game> playerGames;

    @Autowired
    PlayerService playerService;

    @Autowired
    public GameService( GameDao gameDao) {
        this.gameDao = gameDao;
    }


    public List<Game> listGamesByPlayer(){
        playerGames = new ArrayList<Game>();
        String username = playerService.getCurrentPlayer().getUsername();
        List<Game> gameList = gameDao.findAll();
        for (Game game: gameList)
        {
            if (game.getPlayer().equalsIgnoreCase(username)){
                playerGames.add(game);
            }
        }
        return playerGames;
    }

    @Transactional
    public Game playGame(String playerChoice) {

        String username = playerService.getCurrentPlayer().getUsername();
        String hostChoice = getHostChoice();
        String result = "na";
        Game game = new Game();
        game.setPlayer(username);
        game.setPlayerChoice(playerChoice);
        game.setHostChoice(hostChoice);

        if (hostChoice.equalsIgnoreCase("Paper")){
            if (playerChoice.equalsIgnoreCase("Paper")){
                result = "Draw";
            } else if (playerChoice.equalsIgnoreCase("Rock")){
                result = "Loss";
            } else {
                result = "Win";
            }
        } else if (hostChoice.equalsIgnoreCase("Rock")){
            if (playerChoice.equalsIgnoreCase("Paper")){
                result = "Win";
            } else if (playerChoice.equalsIgnoreCase("Rock")){
                result = "Draw";
            } else {
                result = "Loss";
            }
        } else {
            if (playerChoice.equalsIgnoreCase("Paper")){
                result = "Loss";
            } else if (playerChoice.equalsIgnoreCase("Rock")){
                result = "Win";
            } else {
                result = "Loss";
            }
        }
        game.setResult(result);
        gameDao.save(game);
        return game;
    }

    private String getHostChoice(){
        int randomNbr = (int)((Math.random() * 3) + 1);
        if (randomNbr == 1){
            return "Rock";
        } else if (randomNbr == 2){
            return "Paper";
        } else {
            return "Scissor";
        }
    }

}
