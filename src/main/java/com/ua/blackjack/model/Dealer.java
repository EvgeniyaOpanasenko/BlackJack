package com.ua.blackjack.model;

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
