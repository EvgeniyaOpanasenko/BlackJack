package com.ua.blackjack.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@MappedSuperclass
public class BasicPlayer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "player", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Card> cards;

    @OneToMany(mappedBy = "player", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Game> games;

    public BasicPlayer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
