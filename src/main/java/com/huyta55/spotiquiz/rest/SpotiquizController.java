package com.huyta55.spotiquiz.rest;

import java.util.List;

import com.huyta55.spotiquiz.entity.Player;
import com.huyta55.spotiquiz.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("api/")
public class SpotiquizController {

    private static final Logger logger = LoggerFactory.getLogger(SpotiquizController.class);

    @Autowired
    private PlayerService playerService;

    @Autowired
    public SpotiquizController(PlayerService thePlayerService) {
        playerService = thePlayerService;
    }


    @GetMapping("/players/")
    public List<Player> findAll() {
        return playerService.findAll();
    }


    @GetMapping("/players/{userName}/")
    public ResponseEntity<Player> findPlayer(@PathVariable String userName) {
        logger.info("Finding player with the provided username...");
        try {
            Player desiredPlayer = playerService.findByUsername(userName);
            if (desiredPlayer == null) {
                throw new RuntimeException("Player: " + userName + " not found!");
            }
            return new ResponseEntity<>(desiredPlayer, HttpStatus.OK);
        } catch (RuntimeException e) {
            logger.info("Player not found.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("An error occurred while trying to find the player: ");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/players/newplayer/")
    public void addPlayer(@RequestBody Player newPlayer) {
        logger.info("Creating new player...");
        playerService.save(newPlayer);
    }


    @DeleteMapping("/players/rm/")
    public ResponseEntity<Void> deletePlayer(@RequestBody Player player) {
        logger.info("Attempting to delete provided user...");
        playerService.deletePlayerByUser(player.getUsername());
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
