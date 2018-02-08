package com.ua.blackjack.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "games")
@Component
public class Game implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private BasicPlayer player;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "dealer_id", referencedColumnName = "id")
    private BasicPlayer dealer;

    //private Deck deck;

    private GameStatus gameStatus;

    public Game() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BasicPlayer getPlayer() {
        return player;
    }

    public void setPlayer(BasicPlayer player) {
        this.player = player;
    }

    public BasicPlayer getDealer() {
        return dealer;
    }

    public void setDealer(BasicPlayer dealer) {
        this.dealer = dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }


    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
