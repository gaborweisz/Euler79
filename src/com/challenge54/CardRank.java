package com.challenge54;

/**
 * Created by gabor on 2019.03.16..
 */
public enum CardRank {
    Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(11), Queen(12), King(13), Ace(14) ;

    Integer rank;



    CardRank(Integer rank) {
        this.rank = rank;
    }
}
