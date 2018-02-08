package com.ua.blackjack.controller;

import com.ua.blackjack.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blackjack")
public class GameController {
    private static final Logger logger = LoggerFactory.getLogger(GameController.class);

    @Autowired
    private GameService gameService;

    /*
     * кнопка счет игрока
     * кнопка счет дилера
     * начать игру
     * еще карту
     * отказ
     * */


}
