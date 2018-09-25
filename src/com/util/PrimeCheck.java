package com.util;

/**
 * Created by gabor on 2018.02.17..
 */
public class PrimeCheck {
    public static boolean isPrime(Double num) {
        Double sqrNum = Math.sqrt(num);

        for (double i = 2; i <= sqrNum; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }

    public static boolean isPrime(Integer num) {
        return isPrime(num.doubleValue());
    }
}
