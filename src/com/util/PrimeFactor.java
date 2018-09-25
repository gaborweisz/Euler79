package com.util;

import java.util.*;

/**
 * Created by gabor on 2018.02.24..
 */
public class PrimeFactor {

    private List<Integer> primes = new ArrayList<>();

    public PrimeFactor(Integer max) {
        init(max);
    }

    public Integer get(Integer i) {
        return primes.get(i);
    }

    public Integer size() {
        return primes.size();
    }

    private  void init (Integer max) {

        Integer number = 2;
        while (number < max) {
            if (PrimeCheck.isPrime(number)) primes.add(number);
            number++;
        }
    }

    public List<Integer> factor(Integer number) {

        List<Integer> primeFactors = new ArrayList<>();

        while(number > 1 ) {
            for(Integer prime : primes) {
                Integer remainder = number % prime;
                if (remainder == 0) {
                    primeFactors.add(prime);
                    number = number / prime;
                    break;
                }
                if (PrimeCheck.isPrime(number)) {
                    primeFactors.add(number);
                    return  primeFactors;
                }
            }

        }

        return primeFactors;
    }

    public Set<Integer> distinctFactor(Integer number) {
        Set<Integer> distinctíFactors = new HashSet<>(factor(number));

        return distinctíFactors;
    }
}
