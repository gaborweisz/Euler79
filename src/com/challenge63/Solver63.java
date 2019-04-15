package com.challenge63;

import java.math.BigDecimal;

/**
 * Created by gabor on 2019.04.15..
 */
public class Solver63 {

    public void solve() {

        int max_num = 100;
        int max_pow = 100;
        int counter = 0;

        for (Integer n = 1; n <= max_num; n++) {
            for (int p = 1; p <= max_pow; p++) {
                BigDecimal num = new BigDecimal(n);

                BigDecimal result = num.pow(p);

                if (result.toString().length() == p) {
                    counter++;
                    System.out.printf("Found : n = %d; p = %d; num = %s; length = %d\n", n, p, result.toString(), result.toString().length());
                }
            }
        }

        System.out.println("Soluton = " + counter);

    }
}
