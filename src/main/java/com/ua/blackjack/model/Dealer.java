package com.ua.blackjack.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/*@Entity
@Table(name = "dealers")*/
public class Dealer extends BasicPlayer{
    private Deck deck;

    public Dealer() {
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
}
