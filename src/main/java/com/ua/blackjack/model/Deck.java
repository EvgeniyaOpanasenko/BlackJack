package com.ua.blackjack.model;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.util.Objects.nonNull;

/**
 * Represents a deck of cards which are going to be used in a new game
 *
 * @see DeckFactory#createDeck()
 */
@Component
public class Deck {
    private Queue<Card> cards;

    /**
     * @param cards is the content of the deck not mixed
     */
    public Deck(List<Card> cards) {
        this.cards = new LinkedList<>(cards);
    }

    /**
     * removes and returns the next {@code Card}.
     * <p>
     * can @throw IllegalStateException if the deck is empty
     */
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
