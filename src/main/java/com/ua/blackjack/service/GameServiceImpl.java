package com.ua.blackjack.service;

import com.ua.blackjack.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private Game game;

    @Override
    public void initGame() {

    }

    @Override
    public void countScore() {

    }
}
