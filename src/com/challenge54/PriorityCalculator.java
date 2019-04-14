package com.challenge54;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by gabor on 2019.03.17..
 */
public class PriorityCalculator {

    boolean isFlush = false;
    boolean isStraight = false;
    boolean isHighCard = false;
    boolean isOnePair = false;
    boolean isTwoPairs = false;
    boolean isThreeOfaKind = false;
    boolean isFourOfaKind = false;
    boolean isHighCardAce = false;

    public HandPriority calculate(Hand hand) {
        isFlush = false;
        isStraight = false;
        isHighCard = false;
        isOnePair = false;
        isTwoPairs = false;
        isThreeOfaKind = false;
        isFourOfaKind = false;
        isHighCardAce = false;

        calcFlush(hand);
        calcStraight(hand);
        calcPairs(hand);
        calcHighCard(hand);

        if (isHighCardAce && isFlush &&  isStraight) {
            return HandPriority.RoyalFlush;
        } else if (isFlush &&  isStraight) {
            return HandPriority.StraightFlush;
        } else if (isFourOfaKind) {
            return HandPriority.FourOfaKind;
        } else if (isOnePair && isThreeOfaKind) {
            return HandPriority.FullHouse;
        } else if (isFlush) {
            return HandPriority.Flush;
        } else if (isStraight) {
            return HandPriority.Straight;
        } else if (isThreeOfaKind) {
            return HandPriority.ThreeOfaKind;
        } else if (isTwoPairs) {
            return HandPriority.TwoPairs;
        } else if (isOnePair) {
            return HandPriority.OnePair;
        } else {
            return HandPriority.HighCard;
        }
    }

    public void calcFlush(Hand hand) {
        CardColor firstColor = hand.getCards().get(0).getColor();

        isFlush = hand.getCards().stream().filter(c -> c.getColor().equals(firstColor)).collect(Collectors.toList()).size() == 5;
    }

    public void calcStraight(Hand hand) {
        Collections.sort(hand.getCards());

        if (hand.getCards().get(4).getRank().equals(CardRank.Ace) &&
            hand.getCards().get(0).getRank().equals(CardRank.Two) &&
            hand.getCards().get(1).getRank().equals(CardRank.Three) &&
            hand.getCards().get(2).getRank().equals(CardRank.Four) &&
            hand.getCards().get(3).getRank().equals(CardRank.Five)) {

            isStraight = true;

        } else {
            Integer firstRank = hand.getCards().get(0).getRank().rank;
            isStraight = firstRank + 1 == hand.getCards().get(1).getRank().rank &&
                        firstRank + 2 == hand.getCards().get(2).getRank().rank &&
                        firstRank + 3 == hand.getCards().get(3).getRank().rank &&
                        firstRank + 4 == hand.getCards().get(4).getRank().rank ;
        }
    }

    public void calcPairs(Hand hand) {
        Map<CardRank, Integer> rankCounter = new HashMap<>();
        hand.getCards().forEach(card -> {
            Integer rankCount = rankCounter.get(card.getRank());
            if (rankCount == null) {
                rankCounter.put(card.getRank(), 1);
            } else {
                rankCounter.put(card.getRank(), rankCount + 1);
            }
        });

        if (rankCounter.size() == 5) {
            isHighCard = true;
        } else if (rankCounter.size() == 4) {
            isOnePair = true;
        } else if (rankCounter.size() == 3) {
            if (rankCounter.values().stream().filter(r -> r == 3).collect(Collectors.toList()).size() == 1) {
                isThreeOfaKind = true;
            } else {
                isTwoPairs = true;
            }
        } else if (rankCounter.size() == 2) {
            if (rankCounter.values().stream().filter(r -> r == 4).collect(Collectors.toList()).size() == 1) {
                isFourOfaKind = true;
            } else {
                isThreeOfaKind = true;
                isOnePair = true;
            }
        }

    }

    public void calcHighCard(Hand hand) {
        isHighCardAce = hand.getCards().stream().filter(card -> card.getRank().equals(CardRank.Ace)).collect(Collectors.toList()).size() > 0;
    }
}
