package com.challenge54;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gabor on 2019.03.16..
 */
public class CardReader {

    private static Map<String, CardColor> colorMap = new HashMap<>();
    private static Map<String, CardRank> rankMap = new HashMap<>();

    static
    {
        colorMap.put("C", CardColor.Clubs);
        colorMap.put("D", CardColor.Diamonds);
        colorMap.put("H", CardColor.Hearth);
        colorMap.put("S", CardColor.Spades);

        rankMap.put("A", CardRank.Ace);
        rankMap.put("2", CardRank.Two);
        rankMap.put("3", CardRank.Three);
        rankMap.put("4", CardRank.Four);
        rankMap.put("5", CardRank.Five);
        rankMap.put("6", CardRank.Six);
        rankMap.put("7", CardRank.Seven);
        rankMap.put("8", CardRank.Eight);
        rankMap.put("9", CardRank.Nine);
        rankMap.put("T", CardRank.Ten);
        rankMap.put("J", CardRank.Jack);
        rankMap.put("Q", CardRank.Queen);
        rankMap.put("K", CardRank.King);

    }

    public static Card read(String rankColor) {
        return read(rankColor.substring(0,1), rankColor.substring(1,2));
    }

    public static Card read(String rank, String color) {
        return new Card(colorMap.get(color), rankMap.get(rank));
    }
}
