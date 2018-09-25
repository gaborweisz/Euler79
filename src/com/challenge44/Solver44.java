package com.challenge44;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by gabor on 2018.02.19..
 */
public class Solver44 {
    private Long MAX = 10000L;
    HashSet<Long> PSet = new HashSet<>();

    public void solve() {
        Long minDiff = Long.MAX_VALUE;
        initPSet();;

        for (long i = 1; i < MAX; i++) {
            for (long j = i+1; j < MAX ; j++){
                if(test(P(i), P(j))) {
                    System.out.println(i + "," + j + ": P(i)= " + P(i) + ", P(j) = " + P(j));
                    if(P(j)-P(i) < minDiff) {
                        minDiff = P(j) - P(i);
                    }
                }
            }
        }

        System.out.println("Solution = " + minDiff);
    }

    private void initPSet() {
        for (long i = 1L; i < MAX * 2; i++) {
            PSet.add(P(i));
        }
    }

    private Long P(Long n) {
        return n * ( 3* n - 1) / 2;
    }

    private boolean test(Long P1, Long P2){
        return PSet.contains(P1+P2) && PSet.contains(P2-P1);
    }
}
