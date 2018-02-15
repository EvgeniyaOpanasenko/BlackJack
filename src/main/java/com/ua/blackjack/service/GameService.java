package com.ua.blackjack.service;

import com.ua.blackjack.model.Game;

/**
 * Contains list options which the game can have
 */
public interface GameService {
    Game createGame(Game newGame);
}
