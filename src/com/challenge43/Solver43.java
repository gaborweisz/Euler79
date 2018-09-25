package com.challenge43;

import com.util.Pandigital;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gabor on 2018.02.18..
 */
public class Solver43 {
    public void solve() {
        System.out.println("Solution = " + Pandigital.createPandigitalRaw(0, 9).stream().filter(n -> test(n)).map(n -> Pandigital.concat(n)).mapToLong(n -> n.longValue()).sum());
    }

    private boolean test(List<Integer> digits) {
        if (
                isDivisible(concat(digits, new int[]{2, 3, 4}), 2) &&
                        isDivisible(concat(digits, new int[]{3, 4, 5}), 3) &&
                        isDivisible(concat(digits, new int[]{4, 5, 6}), 5) &&
                        isDivisible(concat(digits, new int[]{5, 6, 7}), 7) &&

                        isDivisible(concat(digits, new int[]{6, 7, 8}), 11) &&
                        isDivisible(concat(digits, new int[]{7, 8, 9}), 13) &&
                        isDivisible(concat(digits, new int[]{8, 9, 10}), 17)) {
            return true;
        } else {
            return false;
        }
    }

    private Integer concat(List<Integer> digits, int[] pos) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < pos.length; i++) {
            sb.append(digits.get(pos[i] - 1));
        }

        return Integer.parseInt(sb.toString());
    }

    private boolean isDivisible(Integer num, Integer divider) {
        return num % divider == 0;
    }

}
