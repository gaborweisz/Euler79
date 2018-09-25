package com.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by gabor on 2018.02.18..
 */
public class Pandigital {

    public static boolean isPandigital(String number) {
        Set<Character> digits = new HashSet<>();

        for (Character c : number.toCharArray()){
            digits.add(c);
        }

        return !number.contains("0") && digits.size() == number.length();
    }

    public static List<Long> createPandigital(Integer from, Integer max) {
        List<Integer> digits = new ArrayList<>();

        for (int i = from; i <= max ; i++) {
            digits.add(i);
        }

        return Permutations.of(digits).map(p -> concat(p.collect(Collectors.toList()))).collect(Collectors.toList());

    }

    public static List<List<Integer>> createPandigitalRaw(Integer from, Integer max) {
        List<Integer> digits = new ArrayList<>();

        for (int i = from; i <= max ; i++) {
            digits.add(i);
        }

        return Permutations.of(digits).map(p -> (p.collect(Collectors.toList()))).collect(Collectors.toList());

    }


    public static Long concat(List<Integer> digits) {
        StringBuilder sb = new StringBuilder();

        digits.forEach(d -> sb.append(d));

        return Long.parseLong(sb.toString());
    }
}
