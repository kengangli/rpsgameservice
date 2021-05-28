package com.rpsgame.rpsrestservice.services;

import com.rpsgame.rpsrestservice.daos.*;
import com.rpsgame.rpsrestservice.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PlayerService implements UserDetailsService {

    private final PlayerDao playerDao;

    private Player currentPlayer;
    private List<Player> players;

    @Autowired
    public PlayerService(PlayerDao playerDao) {
        this.playerDao = playerDao;

    }

    @Transactional
    public Player addPlayer(String playerName, String username, String password) {
        Player player = new Player();
        player.setName(playerName);
        player.setUsername(username);
        player.setPassword(password);
        player.setAccountNonExpired(true);
        player.setEnabled(true);
        player.setAccountNonLocked(true);
        player.setCredentialsNonExpired(true);

        playerDao.save(player);
        return player;
    }

    public void initializePlayers(){
        List<Player> listPlayers = playerDao.findAll();
        if (listPlayers.isEmpty()){
            //initialise player table
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            Player player1 = addPlayer("John Doe","user1",new BCryptPasswordEncoder().encode("pass1"));
            Player player2 = addPlayer("Jane Doe","user2",new BCryptPasswordEncoder().encode("pass2"));
        }
    }

    public List<Player> listPlayers(){
        List<Player> listPlayers = playerDao.findAll();

        return listPlayers;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Player player = playerDao.findByUsername(username);
        if (player == null){
            throw new UsernameNotFoundException(username);
        }
        this.currentPlayer = player;
        return player;
    }

    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }
}
