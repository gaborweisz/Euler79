package com.challenge47;

import com.util.PrimeCheck;
import com.util.PrimeFactor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by gabor on 2018.02.24..
 */
public class Solver47 {

    private Integer MAX_PRIME = 1000;
    private Integer MAX_NUM = 1000000;

    public void solve() {

        PrimeFactor primeFactor = new PrimeFactor(MAX_PRIME);

        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= MAX_NUM; i++) {
            if (PrimeCheck.isPrime(i)) continue;

            //System.out.println(i);

            Set<Integer> disctFact = primeFactor.distinctFactor(i);

            if (disctFact.size() == 4){

                if (numbers.size() == 0 ) {
                    numbers.add(i);
                    System.out.println(numbers.size() + ": n=" + i + " ;factors = " +disctFact );
                }
                else if (i == numbers.get(numbers.size()-1) +1) {
                    numbers.add(i);
                    System.out.println(numbers.size() + ": n=" + i + " ;factors = " +disctFact );
                }
                else {
                    numbers.clear();
                    numbers.add(i);
                    System.out.println(numbers.size() + ": n=" + i + " ;factors = " +disctFact );
                }

                if (numbers.size() == 4) break;
            }
        }

        System.out.println("Solution : ");
        numbers.stream().forEach(System.out::println);
    }
}
