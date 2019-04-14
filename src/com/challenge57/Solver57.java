package com.challenge57;

import java.math.BigDecimal;

/**
 * Created by gabor on 2019.04.14..
 */
public class Solver57{

    private static BigDecimal TWO = new BigDecimal("2");
    private static BigDecimal THREE = new BigDecimal("3");

    public void solve() {

        BigDecimal numerator1 = BigDecimal.ONE;
        BigDecimal denominator1  = BigDecimal.ONE;

        BigDecimal numerator2  = THREE;
        BigDecimal denominator2  = TWO;

        int cntr = 0;

        for (int i = 2; i <= 1000; i++) {

            BigDecimal numerator3 = numerator2.multiply(TWO).add(numerator1);
            BigDecimal denominator3 = denominator2.multiply(TWO).add(denominator1);

            numerator1 = numerator2;
            numerator2 = numerator3;
            denominator1 = denominator2;
            denominator2 = denominator3;

            System.out.printf("iteration = %d; %s / %s \n", i, numerator3.toString(), denominator3.toString());
            cntr = numerator3.toString().length() > denominator3.toString().length() ? cntr + 1 : cntr;
        }

        System.out.println("#of numerator with more digits than denominator = " + cntr );
    }
}
