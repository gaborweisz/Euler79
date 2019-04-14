package com.challenge56;

import java.math.BigDecimal;

/**
 * Created by gabor on 2019.04.14..
 */
public class Solver56 {

    public void solve() {
        int largestSum = 0;

        for (int a = 2; a < 100; a++ ) {
            for (int b = 2; b < 100; b++) {
                BigDecimal aBig = new BigDecimal(a);
                BigDecimal aPow = aBig.pow(b);

                int aPowSum = sumDigits(aPow);
                largestSum = largestSum >= aPowSum ? largestSum : aPowSum;
                System.out.printf("a = %d; b = %d; sum = %d; power = %s\n", a, b, aPowSum, aPow.toString());

            }
        }

        System.out.println("The maximum digital sum = " + largestSum);
    }

    int sumDigits(BigDecimal num) {
        int sum = 0;

        for (Character digit : num.toString().toCharArray()) {
            sum += Integer.parseInt(digit.toString());
        }

        return sum;
    }
}
