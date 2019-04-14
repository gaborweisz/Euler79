package com.challenge56;


import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by gabor on 2019.04.14..
 */
public class Solver56Test  {


    @Test
    public void testSumDecimals(){
        Solver56 solver56 = new Solver56();

        assertEquals(15, solver56.sumDigits(new BigDecimal("12345")));
    }


}
