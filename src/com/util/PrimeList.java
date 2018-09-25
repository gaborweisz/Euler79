package com.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabor on 2018.03.15..
 */
public class PrimeList {

    List<Integer> primeList = new ArrayList<>();

    public PrimeList(Integer size) {
        init(2, size);
    }

    public PrimeList(Integer min, Integer max) {
        init(min, max);
    }

    public void init(Integer min, Integer max) {
        for (Integer i=min ; i<= max; i++) {
            if (PrimeCheck.isPrime(i)) {
                primeList.add(i);
            }
        }
    }

    public List<Integer> getPrimeList () {
        return primeList;
    }

    public Integer get(Integer idx) {
        return primeList.get(idx);
    }

    public  boolean contains (Integer n){
        return primeList.contains(n);
    }

    public  Integer size() {
        return  primeList.size();
    }
}
