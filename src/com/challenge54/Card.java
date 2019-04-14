package com.challenge54;

/**
 * Created by gabor on 2019.03.16..
 */
public class Card implements Comparable<Card> {
    CardColor color;
    CardRank rank;

    Card(CardColor color, CardRank rank) {
        this.color = color;
        this.rank = rank;
    }

    public CardColor getColor() {
        return color;
    }

    public CardRank getRank() {
        return rank;
    }

    @Override
    public String toString(){
        return color + " " + rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (color != card.color) return false;
        return rank == card.rank;
    }

    @Override
    public int compareTo(Card o) {
        return rank.compareTo(o.getRank());
    }
}
