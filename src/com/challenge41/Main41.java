package com.challenge41;

import com.util.PrimeCheck;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.
 * For example, 2143 is a 4-digit pandigital and is also prime.
 * What is the largest n-digit pandigital prime that exists?
 */
public class Main41 {
    public static void main(String[] args) {

        System.out.println(PrimeCheck.isPrime(2143.0));

        Solver41 solver = new Solver41();

        solver.solve();
    }
}
