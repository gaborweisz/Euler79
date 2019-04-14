package com.challenge54;

/**
 * Created by gabor on 2019.03.17..
 */
public enum HandPriority {

    HighCard(1), //Highest value card.
    OnePair(2),//Two cards of the same value.
    TwoPairs(3), //Two different pairs.
    ThreeOfaKind(4), //Three cards of the same value.
    Straight(5), //All cards are consecutive values.
    Flush(6), //All cards of the same suit.
    FullHouse(7), //Three of a kind and a pair.
    FourOfaKind(8), //Four cards of the same value.
    StraightFlush(9), // All cards are consecutive values of same suit.
    RoyalFlush(10); //Ten, Jack, Queen, King, Ace, in same suit.

    private Integer weight;

    HandPriority(Integer weight) {
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }
}
