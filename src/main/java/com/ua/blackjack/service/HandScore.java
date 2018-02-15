package com.ua.blackjack.service;

import com.ua.blackjack.model.Card;
import com.ua.blackjack.model.CardRank;

import java.util.Collection;
import java.util.List;

import static com.ua.blackjack.model.CardRank.ACE;

/**
 * Represent the main logic of the game.
 */
public class HandScore {
    /**
     * The win value of the cards. Any player with such value wins
     * any player with value over will bust.
     */
    private final static int TARGET = 21;
    /**
     * The minimum value of the dealer's cards.
     */
    private final static int DEALER_MINIMUM = 17;
    /**
     * The high value of ace which can be assigned to the dealer's card only.
     * Alternative {@code ACE_MINIMUM_VALUE}
     */
    private static final int ACE_HIGH_VALUE = ACE.getValue();
    /**
     * The minimum value of ace which can be assigned to the dealer's card only.
     * Alternative {@code ACE_HIGH_VALUE}
     */
    private static final int ACE_MINIMUM_VALUE = 1;

    public HandScore() {
    }

    public static boolean isBlackJack(List<Card> cards) {

        return cards.size() == 2 && isTarget(cards);
    }

    protected static boolean isTarget(List<Card> cards) {
        return value(cards) == TARGET;
    }

    /**
     * Returns the value of the income cards
     */
    protected static int value(Collection<Card> cards) {
        int value = 0;
        int numberOfAces = 0;

        for (Card c : cards) {
            CardRank v = c.getValue();
            if (isAceFound(v)) {
                numberOfAces++;
            }
            value += v.getValue();
        }
        return countValueIncludingAce(value, numberOfAces);
    }

    private static boolean isAceFound(CardRank v) {
        return v == ACE;
    }

    /**
     * Counts value of the cards including Ace Value
     */
    private static int countValueIncludingAce(int value, int numberOfAces) {
        if (numberOfAces == 0) {
            return value;
        } else if (numberOfAces > 0 && ((value - ACE_HIGH_VALUE) <= TARGET)) {
            return value + ACE_MINIMUM_VALUE;
        }
        return value + ACE_HIGH_VALUE;
    }

    /**
     * IS WHEN TOTAL CARDS VALUE IS MORE THEN 21
     **/
    public static boolean isBust(int value) {
        return value > 21;
    }

    public static boolean isBeforeDealerMinimum(List<Card> dealer) {
        return value(dealer) < DEALER_MINIMUM;
    }
}
