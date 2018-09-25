package com.challenge41;

import com.util.Pandigital;
import com.util.Permutations;
import com.util.PrimeCheck;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by gabor on 2018.02.17..
 */
public class Solver41 {

    public void solve() {
        List<Long> nums = Pandigital.createPandigital(1, 7);

        System.out.println("Solution = " + nums.stream().sorted((a,b) -> a.compareTo(b) *-1 ).filter(n -> PrimeCheck.isPrime(n.doubleValue())).mapToLong(n->n.longValue()).max());
    }
}
