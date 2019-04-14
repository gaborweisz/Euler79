package com.challenge54;

import java.util.*;

/**
 * Created by gabor on 2019.03.17..
 */
public class Deal {

    private List<Hand> hands = new ArrayList<>();
    private Player winner;

    Deal(Hand... hand) {
        Arrays.stream(hand).forEach(p -> hands.add(p));
        winner = WinnerCalculator.calculateWinner(hands);
    }

    public Player getWinner() {
        return winner;
    }

    @Override
    public String toString() {
        return hands.toString().concat(" Winner : " + winner);
    }

}
