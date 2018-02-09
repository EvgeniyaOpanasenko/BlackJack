package com.ua.blackjack.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
@Entity
@Table(name = "cards")
public class Card implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private CardSuit suit;
    //TODO find the way for better value Int enum storing
    @Enumerated(EnumType.ORDINAL)
    private CardRank value;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private BasicPlayer player;

    private Game gameId;

    public Card() {
    }

    public Card(CardSuit suit, CardRank value) {
        this.suit = suit;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public void setSuit(CardSuit suit) {
        this.suit = suit;
    }

    public CardRank getValue() {
        return value;
    }

    public void setValue(CardRank value) {
        this.value = value;
    }

    public BasicPlayer getPlayer() {
        return player;
    }

    public void setPlayer(BasicPlayer player) {
        this.player = player;
    }
}
