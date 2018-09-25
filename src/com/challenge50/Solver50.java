package com.challenge50;

import com.util.PrimeCheck;
import com.util.PrimeList;

/**
 * Created by gabor on 2018.03.15..
 */
public class Solver50 {

    PrimeList primeList = new PrimeList(1000000);

    public void solve() {
        Integer longestPrime = 0;
        Integer longestSequence = 0;

        for (int i = 0; i < primeList.getPrimeList().size(); i++) {

            Integer sumPrime = 0;
            Integer currentSequence = 0;
            for (int j = i; j < primeList.getPrimeList().size(); j++) {
                sumPrime += primeList.getPrimeList().get(j);
                currentSequence ++;
                if (PrimeCheck.isPrime(sumPrime)) {
                    if (currentSequence > longestSequence) {
                        longestSequence = currentSequence;
                        longestPrime = sumPrime;
                        System.out.println("found : " + longestPrime + "; sequence =  " + longestSequence);
                    }
                }

                if (sumPrime > 1000000) break;
            }
        }
    }
}
