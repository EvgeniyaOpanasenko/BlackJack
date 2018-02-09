package com.ua.blackjack.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.Collections.unmodifiableList;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;

@Component
public class DeckFactory {
    private static final List<Card> CARDS =
            unmodifiableList(stream(CardRank.values()).map(cardRank -> stream(CardSuit.values())
                    .map(cardSuit -> new Card(cardSuit, cardRank))).flatMap(identity()).collect(toList()));

    private final ShuffleStrategy<Card> shuffleStrategy;


    @Autowired
    DeckFactory(ShuffleStrategy<Card> shuffleStrategy) {
        this.shuffleStrategy = shuffleStrategy;
    }

    Deck createDeck() {
        return new Deck(shuffleStrategy.shuffle(CARDS));
    }
}
