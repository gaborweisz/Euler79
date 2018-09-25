package com.challenge46;

import com.util.PrimeCheck;

import java.util.HashMap;

/**
 * Created by gabor on 2018.02.19..
 */
public class Solver46 {

    private Long MAX = 10000L;
    private HashMap<Long, Boolean> primeMap = new HashMap<>();

    public void solve() {
        for (long i = 5; i < MAX; i+=2) {

            if (isPrime(i)) continue;
            boolean found = false;

            for (long j = 1; j < i-1; j++) {
                if(isPrime(j)){
                    if (test(i, j)){
                        //System.out.println("found : " + i + "; prime = " + j);
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                System.out.println("Solution = " + i);
                break;
            }
        }
    }

    private Boolean test(Long n, Long prime) {
        return isSquare((n.doubleValue() - prime.doubleValue()) / 2);
    }

    private Boolean isPrime(Long n) {

        if (!primeMap.containsKey(n)) primeMap.put(n, PrimeCheck.isPrime(n.doubleValue()));

        return primeMap.get(n);
    }

    private Boolean isSquare(Double n) {
        Long sqrt = Math.round(Math.sqrt(n));
        return sqrt * sqrt == n;
    }
}
