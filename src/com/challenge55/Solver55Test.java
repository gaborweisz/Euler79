package com.challenge55;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by gabor on 2019.04.21..
 */
public class Solver55Test {

    @Test
    public void isLychrelTest() {
        Solver55 solver55 = new Solver55();

        assertEquals("47",false, solver55.isLychrel(47));
        assertEquals("349",false, solver55.isLychrel(349));
        assertEquals("196",true, solver55.isLychrel(196));
        assertEquals("4994",true, solver55.isLychrel(4994));
    }

    @Test
    public void reverseSumTest() {
        Solver55 solver55 = new Solver55();

        assertEquals(new BigDecimal("121"), solver55.reverseSum(new BigDecimal("47")));
    }

}
