package com.challenge54;


import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by gabor on 2019.03.18..
 */
public class WinnerCalculator {

    public static Player calculateWinner(List<Hand> hands) {

        HandPriority priority1 = hands.get(0).getPriority();
        HandPriority priority2 = hands.get(1).getPriority();


        if (priority1.getWeight() > priority2.getWeight()) {
            return Player.Player1;
        } else if (priority2.getWeight() > priority1.getWeight()) {
            return Player.Player2;
        } else {


            CardRank highestRankCardPlayer1;
            CardRank highestRankCardPlayer2;

            switch (priority1) {
                case FourOfaKind:
                    highestRankCardPlayer1 = highestRankFour(hands.get(0));
                    highestRankCardPlayer2 = highestRankFour(hands.get(1));
                    break;
                case ThreeOfaKind:
                    highestRankCardPlayer1 = highestRankThree(hands.get(0));
                    highestRankCardPlayer2 = highestRankThree(hands.get(1));
                    if (highestRankCardPlayer1.rank > highestRankCardPlayer2.rank) {
                        return Player.Player1;
                    } else if (highestRankCardPlayer1.rank < highestRankCardPlayer2.rank) {
                        return Player.Player2;
                    } else {
                        //fall to highest pait
                    }
                case OnePair:
                case TwoPairs:
                    highestRankCardPlayer1 = highestRankPairs(hands.get(0));
                    highestRankCardPlayer2 = highestRankPairs(hands.get(1));
                    if (highestRankCardPlayer1.rank > highestRankCardPlayer2.rank) {
                        return Player.Player1;
                    } else if (highestRankCardPlayer1.rank < highestRankCardPlayer2.rank) {
                        return Player.Player2;
                    } else {
                       //fall to highest card
                    }
                case Straight:
                case Flush:
                case HighCard:
                default:
                    highestRankCardPlayer1 = highestRankCard(hands.get(0));
                    highestRankCardPlayer2 = highestRankCard(hands.get(1));
            }

            if (highestRankCardPlayer1.rank > highestRankCardPlayer2.rank) {
                return Player.Player1;
            } else if (highestRankCardPlayer1.rank < highestRankCardPlayer2.rank) {
                return Player.Player2;
            } else {
                return Player.Draw;
            }
        }
    }

    private static CardRank highestRankCard(Hand hand) {
        return hand.getCards().stream().max(new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.getRank().rank.compareTo(o2.getRank().rank);
            }
        }).get().getRank();
    }


    private static CardRank highestRankPairs(Hand hand) {
        List<CardRank> pairs = rankCount(hand).entrySet().stream().filter(e -> e.getValue() == 2).map(e -> e.getKey()).collect(Collectors.toList());

        return maxCardRank(pairs);
    }

    private static CardRank highestRankThree(Hand hand) {
        List<CardRank> pairs = rankCount(hand).entrySet().stream().filter(e -> e.getValue() == 3).map(e -> e.getKey()).collect(Collectors.toList());

        return maxCardRank(pairs);
    }

    private static CardRank highestRankFour(Hand hand) {
        List<CardRank> pairs = rankCount(hand).entrySet().stream().filter(e -> e.getValue() == 4).map(e -> e.getKey()).collect(Collectors.toList());

        return maxCardRank(pairs);
    }

    private static CardRank maxCardRank(List<CardRank> pairs) {

        return pairs.stream().max(new Comparator<CardRank>() {
            @Override
            public int compare(CardRank o1, CardRank o2) {
                return o1.rank.compareTo(o2.rank);
            }
        }).get();
    }


    private static Map<CardRank, Integer> rankCount(Hand hand) {
        Map<CardRank, Integer> rankCounter = new HashMap<>();
        hand.getCards().forEach(card -> {
            Integer rankCount = rankCounter.get(card.getRank());
            if (rankCount == null) {
                rankCounter.put(card.getRank(), 1);
            } else {
                rankCounter.put(card.getRank(), rankCount + 1);
            }
        });

        return rankCounter;
    }
}
