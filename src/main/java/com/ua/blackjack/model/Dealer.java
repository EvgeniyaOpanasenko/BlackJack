package com.ua.blackjack.model;

/** Represents dealer of the game*/
public class Dealer extends BasicPlayer {
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
