package com.challenge54;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabor on 2019.03.16..
 */
public class Hand implements Comparable<Hand>{

    private List<Card> cards = new ArrayList<>();
    private HandPriority priority;
    private Player player;

    public Hand(Player player) {
        this.player = player;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() { return cards; }

    public HandPriority getPriority() {
        return priority;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPriority(HandPriority priority) {
        this.priority = priority;
    }

    @Override
    public String toString(){
        return player.toString().concat(" >" + cards.toString().concat(" : " + priority));
    }

    @Override
    public int compareTo(Hand o) {
        return o.getPriority().getWeight().compareTo(this.getPriority().getWeight());
    }
}
