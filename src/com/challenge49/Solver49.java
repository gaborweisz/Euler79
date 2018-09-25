package com.challenge49;

import com.util.CheckPermutation;
import com.util.PrimeList;

/**
 * Created by gabor on 2018.03.15..
 */
public class Solver49 {


    PrimeList primeList = new PrimeList(1000, 9999);

    public void solve(){
        for (Integer i = 0; i < primeList.size(); i++) {
            for (Integer j = i+1 ; j < primeList.size(); j++) {
                Integer a = primeList.get(i);
                Integer b = primeList.get(j);
                Integer diff = b-a;
                Integer c = b + diff;
                if (primeList.contains(c) && CheckPermutation.isPermutation(a,b) && CheckPermutation.isPermutation(b,c)) {
                    System.out.println("Found : a=" + a + " ;b=" + b + " ;c=" + c + " solution = " + a + "" + b + "" + c);
                }

            }
        }
    }
}
