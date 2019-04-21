package com.challenge55;

import java.math.BigDecimal;

import static com.util.ReverseUtil.reverse;
import static com.util.ReverseUtil.isPalindrom;

public class Solver55 {

    public void solve() {

        int counter = 0;

        for (int i = 1; i < 10000; i++) {
            if (isLychrel(i)) counter++;
        }

        System.out.println("Solution = " + counter);

    }

    boolean isLychrel(Integer number) {

        int counter = 0;
        int max_iter = 50;
        BigDecimal n = new BigDecimal(number);

        do {
            n = reverseSum(n);
            counter++;
        } while (!isPalindrom(n) && counter < max_iter);

        return counter == max_iter;
    }

    BigDecimal reverseSum(BigDecimal number) {
        return number.add(reverse(number));
    }
}
