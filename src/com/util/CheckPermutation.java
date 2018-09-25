package com.util;

import java.util.Arrays;

/**
 * Created by gabor on 2018.03.15..
 */
public class CheckPermutation {

    public static boolean isPermutation(Integer a, Integer b) {
        char[] digitsA = a.toString().toCharArray();
        char[] digitsB = b.toString().toCharArray();

        if (digitsA.length != digitsB.length) return false;

        Integer found = 0;
        for (char ad : digitsA) {
            Integer idx = 0;
            for (char bd : digitsB) {
                if (ad == bd) {
                    digitsB[idx]= 'X';
                    found++;
                    break;
                }
                idx++;
            }
        }

        return found == digitsA.length;
    }
}
