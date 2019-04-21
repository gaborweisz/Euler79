package com.util;

import java.math.BigDecimal;

/**
 * Created by gabor on 2019.04.21..
 */
public class ReverseUtil {

    public static String reverse(String text) {
        StringBuilder reverseText = new StringBuilder();
        char[] characters = text.toCharArray();
        for (int i = characters.length-1; i>=0; i--){
            reverseText.append(characters[i]);
        }

        return reverseText.toString();
    }

    public static boolean isPalindrom(String text) {
        return text.equals(reverse(text));
    }

    public static boolean isPalindrom(BigDecimal number) {
        return isPalindrom(number.toString());
    }

    public static BigDecimal reverse(BigDecimal number){
        return new BigDecimal(reverse(number.toString()));
    }
}
