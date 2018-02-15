package com.ua.blackjack.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeckFactoryTest {
    private static final int EXPECTED_NUMBER_OF_SUITS = 4;
    private static final int EXPECTED_NUMBER_OF_RANKS = 13;
    private static final int EXPECTED_NUMBER_OF_CARDS =
            EXPECTED_NUMBER_OF_SUITS * EXPECTED_NUMBER_OF_RANKS;

    @Test
    public void testShuffleStrategy() {
        // create mocks
        ShuffleStrategy<Card> mockShuffleStrategy = mock(ShuffleStrategy.class);
        Card card1 = new Card(CardSuit.SPADES, CardRank.THREE);
        Card card2 = new Card(CardSuit.CLUBS, CardRank.KING);
        Card card3 = new Card(CardSuit.DIAMONDS, CardRank.SEVEN);
        when(mockShuffleStrategy.shuffle(any())).thenReturn(asList(card1), asList(card2), asList(card3));

        // create object to test
        DeckFactory deckFactory = new DeckFactory(mockShuffleStrategy);

        assertSame(card1, deckFactory.createDeck().deal());
        assertSame(card2, deckFactory.createDeck().deal());
        assertSame(card3, deckFactory.createDeck().deal());
    }

    @Test
    public void testDeckContent() {
        DeckFactory deckFactory = new DeckFactory(new ShuffleStrategy<Card>());
        Deck d = deckFactory.createDeck();

        // deal cards from deck and store in a list
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < EXPECTED_NUMBER_OF_CARDS; i++) {
            Card c = d.deal();
            assertNotNull(c);
            cards.add(c);
        }

        // check there are not more than the expected number of cards in the deck
        try {
            d.deal();
            fail();
        } catch (IllegalStateException e) {
            assertEquals("deck is empty", e.getMessage());
        }
    }
}