package com.ua.blackjack.controller;

import com.ua.blackjack.model.Game;
import com.ua.blackjack.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/blackjack")
public class GameController {
    private static final Logger LOG = LoggerFactory.getLogger(GameController.class);

    @Autowired
    private GameService gameService;

    @PostMapping
    public ResponseEntity<Void> newGame(UriComponentsBuilder ucBuilder) {
        Game newGame = new Game();
        gameService.createGame(newGame);
        LOG.info(" new game created: " + newGame.getId());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/blackjack/game/{id}").buildAndExpand(newGame.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }


}
