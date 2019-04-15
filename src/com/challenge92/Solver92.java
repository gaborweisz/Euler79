package com.challenge92;



/**
 * Created by gabor on 2019.04.15..
 */
public class Solver92 {

    public void solve() {

        long MAX = 10000000;
        long counter = 0;

        for (long i = 1; i < MAX; i++) {
            if (chain(i) == 89) counter++;
        }

        System.out.printf("Solution = %d\n", counter);

    }

    long chain(Long number){

        long n = number;

        do {
            n = next(n);
        } while (n != 89 && n != 1);

        return n;

    }

    long next(Long number) {
        int sum = 0;
        for (Character digit : number.toString().toCharArray()){
            int d = Integer.parseInt(digit.toString());
            sum += d*d;
        }

        return sum;
    }

}
