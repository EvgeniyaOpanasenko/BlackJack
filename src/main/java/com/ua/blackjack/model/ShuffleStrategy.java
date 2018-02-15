package com.ua.blackjack.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Contains logic for randomly shuffling element of a list
 */
@Component
public class ShuffleStrategy<T> {
    List<T> shuffle(List<T> input) {
        List<T> copy = new ArrayList<>(input);
        Collections.shuffle(copy);
        return copy;
    }
}
