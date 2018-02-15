package com.ua.blackjack.service;

import com.ua.blackjack.model.Card;
import com.ua.blackjack.model.Deck;
import com.ua.blackjack.model.Game;
import com.ua.blackjack.model.GameStatus;
import com.ua.blackjack.repository.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * Class contains realization of interface GameService
 */
@Service
public class GameServiceImpl implements GameService {

    private static final Logger LOG = LoggerFactory.getLogger(Game.class);
    private final Object lock = new Object();

    @Autowired
    GameRepository gameRepository;

    @Autowired
    private Game game;

    @Autowired
    private Deck deck;

    //TODO remove Player from game
    private List<Card> player;
    private List<Card> dealer;

    //TODO add exception
    public void initGame(Game newGame) {
        gameRepository.save(newGame);
        deal(player);
        deal(player);
        countResult();
        deal(dealer);
    }

    private void countResult() {
        if (HandScore.isBlackJack(player)) {
            game.setGameStatus(GameStatus.PLAYER_WON);
        } else if (HandScore.isBust(HandScore.value(player))) {
            game.setGameStatus(GameStatus.DEALER_WON);
        } else if (isDealerTurn()) {
            dealerPlay();
            setGameOutcome();
        }
    }

    private void setGameOutcome() {
        countWinner(dealer, player);
    }

    private void countWinner(List<Card> dealer, List<Card> player) {
        int playerCount = HandScore.value(player);
        int dealerCount = HandScore.value(dealer);
        if (HandScore.isBust(playerCount)) {
            game.setGameStatus(GameStatus.DEALER_WON);
        } else if (HandScore.isBust(dealerCount)) {
            game.setGameStatus(GameStatus.PLAYER_WON);
        } else if (playerCount > dealerCount) {
            game.setGameStatus(GameStatus.PLAYER_WON);
        } else if (dealerCount > playerCount) {
            game.setGameStatus(GameStatus.PLAYER_WON);
        } else if (playerCount == dealerCount) {
            game.setGameStatus(GameStatus.PLAYER_WON);
        }
    }

    private void dealerPlay() {
        while (HandScore.isBeforeDealerMinimum(dealer)) {
            deal(dealer);
        }
    }

    private boolean isDealerTurn() {

        return game.getGameStatus() == GameStatus.DEALER_TURN || HandScore.isTarget(player);
    }

    private void deal(List<Card> hand) {
        Card next = requireNonNull(deck.deal());
        //game.getDealer().getCards().add(next);
        LOG.info(game.getId() + " dealt " + next);
        hand.add(next);
    }

    @Override
    public Game createGame(Game newGame) {
        return gameRepository.save(newGame);
    }
}
