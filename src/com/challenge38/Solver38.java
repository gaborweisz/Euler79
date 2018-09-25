package com.challenge38;

import com.util.Pandigital;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by gabor on 2018.02.17..
 */
public class Solver38 {

    public void solve() {
        Long maxNum = 0L;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=10000; i++) {
            sb.setLength(0);
            for (int j = 1; j <= 5 ; j++) {
                Integer p = i*j;
                sb.append(p.toString());

                if (sb.toString().length() == 9 && Pandigital.isPandigital(sb.toString())) {
                    System.out.println(sb);
                    if (Long.parseLong(sb.toString()) > maxNum) maxNum = Long.parseLong(sb.toString());
                }
            }


        }

        System.out.println("Solution : " + maxNum);
    }


}
