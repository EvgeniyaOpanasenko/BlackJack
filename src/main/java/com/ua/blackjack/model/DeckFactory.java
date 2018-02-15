package com.ua.blackjack.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.Collections.unmodifiableList;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;

/**
 * Creates new {@code Deck}
 */
@Component
public class DeckFactory {
    /**
     * Contains {@code Card} for different combinations of {@code Rank} and {@code Suit}
     */
    private static final List<Card> CARDS =
            unmodifiableList(stream(CardRank.values()).map(cardRank -> stream(CardSuit.values())
                    .map(cardSuit -> new Card(cardSuit, cardRank))).flatMap(identity()).collect(toList()));
    /**
     * @param shuffleStrategy
     * is used to mix the cards which contained in {@code Deck}
     * created by {@link #createDeck()} randomly
     */
    private final ShuffleStrategy<Card> shuffleStrategy;


    @Autowired
    DeckFactory(ShuffleStrategy<Card> shuffleStrategy) {
        this.shuffleStrategy = shuffleStrategy;
    }

    /**
     * returns a new {@code Deck} which contains collection of {@code Card}
     * and shuffled
     */
    Deck createDeck() {
        return new Deck(shuffleStrategy.shuffle(CARDS));
    }
}
