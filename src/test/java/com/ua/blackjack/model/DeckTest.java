package com.ua.blackjack.model;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class DeckTest {

    @Test
    public void test() {
        //create input
        Card card1 = new Card(CardSuit.HEARTS, CardRank.TWO);
        Card card2 = new Card(CardSuit.SPADES, CardRank.KING);
        Card card3 = new Card(CardSuit.DIAMONDS, CardRank.SEVEN);

        List<Card> cards = asList(card1, card2, card3);

        //Deck to test
        Deck deck = new Deck(cards);
        cards.set(0, null);
        cards.set(1, null);
        cards.set(2, null);

        // test deal() returns the cards
        assertSame(card1, deck.deal());
        assertSame(card2, deck.deal());
        assertSame(card3, deck.deal());

        // check there are not more than the expected number of cards in the deck
        try {
            deck.deal();
            fail();
        } catch (IllegalStateException e) {
            assertEquals("deck is empty", e.getMessage());
        }
    }

}