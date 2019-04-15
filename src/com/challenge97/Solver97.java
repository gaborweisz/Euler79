package com.challenge97;


import java.math.BigDecimal;

/**
 * Created by gabor on 2019.04.15..
 */
public class Solver97 {
    BigDecimal TWO = new BigDecimal(2);

    public void solve() {

        long MAX = 7830457;


        BigDecimal number = new BigDecimal(1);
        for (long i = 1; i <= MAX; i++) {
            number = multiplyAndCut(number);
        }

        System.out.println("Solution = " + cutLastTen(number.multiply(new BigDecimal(28433)).add(BigDecimal.ONE).toString()));

    }

    BigDecimal multiplyAndCut(BigDecimal d){
        String number = d.multiply(TWO).toString();

        int len = number.length();

        String lastTenDigit = len > 10 ? cutLastTen(number): number;

        return new BigDecimal(lastTenDigit);
    }

    String cutLastTen(String number) {
        int len = number.length();

        return number.toString().substring(len-10, len);
    }
}
