package com.ua.blackjack.model;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.util.Objects.nonNull;

@Component
public class Deck {
    private Queue<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = new LinkedList<>();
    }

    public Card deal() {
        Card next = poll();
        if (nonNull(next)) {
            return next;
        } else {
            throw new IllegalStateException("deck is empty");
        }
    }

    private Card poll() {
        synchronized (cards) {
            return cards.poll();
        }
    }
}
